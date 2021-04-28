package shallWe.Service;

import java.util.ArrayList;
import java.util.List;

import shallWe.DAO.MemberPlanDAO;

public class MemberPlanService {
	MemberPlanDAO mpdao = new MemberPlanDAO();
	
	public double[] convertToDouble(String temp) {
		// (37.5334512248726, 126.994610005044)
		String str = temp;
		double lat=0.0;
		double lon=0.0;
		//(경도,위도)
		double[] locationList= new double[3];
		
		 String[] location = str.split(",| ");
		 
		  
		  for(int i=0; i<location.length; i++) {
			  String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s\'.']";
		      location[i]=location[i].replaceAll(match, "");
		     
		      if(i==0) {//경도
		    	  lon = Double.parseDouble(location[i]);
		      }
		      else if(i==2) {//위도
		    	  lat = Double.parseDouble(location[i]);
		      }
		  }
		  //lat(위도 127) ,lon(경도)37
		  System.out.println(lat+","+lon);
		  locationList[0]=lat;//위도
		  locationList[1]=lon;//경도
		  
		
		return locationList;
	}
	

	public int insertMemberLocation(String member_id,String plan_id ,double lat,double lon) {
		MemberPlanDAO mpdao = new MemberPlanDAO();
		return mpdao.insertMemberToMemberPlan(member_id,plan_id,lat, lon);

	}
	
	public int insertMemberPlan(String plan_id, String member_id, double lat, double lon) {
		return mpdao.insertMemberPlan(plan_id, member_id, lat, lon);
	}
}
