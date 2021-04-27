package shallWe.Service;

import java.util.List;

import shallWe.DAO.ActivityDAO;
import shallWe.VO.ActivityVO;
import shallWe.VO.CafeVO;
import shallWe.VO.RestaurantVO;

public class ActivityService {
	
	ActivityDAO dao = new ActivityDAO();
	
	public List<RestaurantVO> selectRestaurantByLocationName(String location_name) {
		return dao.selectRestaurantByLocationName(location_name);
	}
	
	public List<CafeVO> selectCafeByLocationName(String location_name) {
		return dao.selectCafeByLocationName(location_name);
	}
	
	public List<ActivityVO> selectActivityByLocationName(String location_name) {
		return dao.selectActivityByLocationName(location_name);
	}
}
