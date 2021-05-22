package com.shallwe.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shallwe.dao.HotplaceDAO;
import com.shallwe.dao.MemberPlanDAO;
import com.shallwe.model.HotplaceVO;
import com.shallwe.model.MemberPlanVO;

@Service
public class MemberPlanService {
	
	@Autowired
	MemberPlanDAO mpdao;
	
	@Autowired
	HotplaceDAO hpdao;

	public double[] convertToDouble(String temp) {
		// (37.5334512248726, 126.994610005044)
		String str = temp;
		double lat = 0.0;
		double lon = 0.0;
		// (�浵,����)
		double[] locationList = new double[3];

		String[] location = str.split(",| ");

		for (int i = 0; i < location.length; i++) {
			String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s\'.']";
			location[i] = location[i].replaceAll(match, "");

			if (i == 0) {// �浵
				lon = Double.parseDouble(location[i]);
			} else if (i == 2) {// ����
				lat = Double.parseDouble(location[i]);
			}
		}
		// lat(���� 127) ,lon(�浵)37
		System.out.println(lat + "," + lon);
		locationList[0] = lat;// ����
		locationList[1] = lon;// �浵

		return locationList;
	}

	public int updateMemberLocation(MemberPlanVO mpvo) {
		return mpdao.updateMemberLocation(mpvo);

	}
	
	
	//����� ���÷��̽����� �Ÿ����
	public double[] selectMemberLocation(String plan_id,String member_id) {
		return mpdao.selectMemberLocation(plan_id, member_id);
	}

	//�߰��Ÿ����� ����� ���÷��̽� 3�� String�迭�� ����
	public String[] informMiddlePlace(String plan_id) {
		
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
		// ���� 37 �浵 127
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
		return mpdao.selectLocationByGroup(plan_id);
	}

	public int insertMemberPlan(String plan_id, String member_id, double lat, double lon) {
		return mpdao.insertMemberPlan(plan_id, member_id, lat, lon);
	}
	
	
	
	//�Ÿ����ϴ� �޼ҵ�

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

	public String[] calculateMemberDistance(double[] memberLocation, List<HotplaceVO> hotlist) {
		String[] distance = new String[3];
		for(int i = 0 ; i < 3 ; i++) {
			double result = distance(memberLocation[0], memberLocation[1], 
					hotlist.get(i).getLat(), hotlist.get(i).getLon(), "kilometer");
			distance[i]=String.format("%.2f",result);
		}
		return distance;
	}


}
