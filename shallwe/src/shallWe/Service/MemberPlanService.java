package shallWe.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import shallWe.DAO.HotplaceDAO;
import shallWe.DAO.MemberPlanDAO;
import shallWe.VO.HotplaceVO;
import shallWe.VO.MemberPlanVO;

public class MemberPlanService {
	MemberPlanDAO mpdao = new MemberPlanDAO();

	public double[] convertToDouble(String temp) {
		// (37.5334512248726, 126.994610005044)
		String str = temp;
		double lat = 0.0;
		double lon = 0.0;
		// (경도,위도)
		double[] locationList = new double[3];

		String[] location = str.split(",| ");

		for (int i = 0; i < location.length; i++) {
			String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s\'.']";
			location[i] = location[i].replaceAll(match, "");

			if (i == 0) {// 경도
				lon = Double.parseDouble(location[i]);
			} else if (i == 2) {// 위도
				lat = Double.parseDouble(location[i]);
			}
		}
		// lat(위도 127) ,lon(경도)37
		System.out.println(lat + "," + lon);
		locationList[0] = lat;// 위도
		locationList[1] = lon;// 경도

		return locationList;
	}

	public int updateMemberLocation(String member_id, String plan_id, String lat_s, String lon_s) {
		MemberPlanDAO mpdao = new MemberPlanDAO();
		double lat = Double.parseDouble(lat_s);
		double lon = Double.parseDouble(lon_s);

		return mpdao.updateMemberLocation(member_id, plan_id, lat, lon);

	}

	//중간거리에서 가까운 핫플레이스 3개 String배열로 리턴
	public String[] informMiddlePlace(String plan_id) {
		MemberPlanDAO mpdao = new MemberPlanDAO();
		HotplaceDAO hpdao = new HotplaceDAO();
		List<HotplaceVO> hotplaces = new ArrayList<HotplaceVO>();
		List<MemberPlanVO> mlist = new ArrayList<MemberPlanVO>();
		hotplaces = hpdao.selectHotplaceLocation();
		mlist = mpdao.selectLocationByGroup(plan_id);
		Comparator<Double> comparator = (d1, d2) -> d1.compareTo(d2);
		TreeMap<Double, String> hotplace_result = new TreeMap<Double, String>(comparator);
		double lat_sum = 0;
		double lon_sum = 0;
		int count = 0;
		for (MemberPlanVO member : mlist) {
			lat_sum += member.getLat();
			lon_sum += member.getLon();
			count += 1;
		}
		double middle_lat = lat_sum / count;
		double middle_lon = lon_sum / count;
		// 위도 37 경도 127
		for (HotplaceVO hotplace : hotplaces) {
			
			double result = distance(middle_lat, middle_lon, hotplace.getLat(), hotplace.getLon(), "kilometer");
			hotplace_result.put(result, hotplace.getHotplace_name());
			
		}
		
		int num =0;
		String[] hotplace3 =new String[3];
		for (Map.Entry<Double, String> entry : hotplace_result.entrySet()) {
			if(num<=2) {
			hotplace3[num]=entry.getValue();
			}
			else break;
			num++;
		}
		
		return hotplace3;

	}
	
	public List<MemberPlanVO> selectLocationByGroup(String plan_id) {
		MemberPlanDAO mpdao = new MemberPlanDAO();
		return mpdao.selectLocationByGroup(plan_id);
	}

	public int insertMemberPlan(String plan_id, String member_id, double lat, double lon) {
		return mpdao.insertMemberPlan(plan_id, member_id, lat, lon);
	}
	
	
	
	//거리구하는 메소드

	private double distance(double lat1, double lon1, double lat2, double lon2, String unit) {

		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;

		if (unit == "kilometer") {
			dist = dist * 1.609344;
		} else if (unit == "meter") {
			dist = dist * 1609.344;
		}

		return (dist);
	}

	// This function converts decimal degrees to radians
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	// This function converts radians to decimal degrees
	private double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}


}
