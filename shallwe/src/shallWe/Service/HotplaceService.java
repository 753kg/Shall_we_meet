package shallWe.Service;

import java.util.List;

import shallWe.DAO.HotplaceDAO;
import shallWe.VO.HotplaceVO;

public class HotplaceService {

	public List<HotplaceVO> selectHotplaceLocation() {
		HotplaceDAO htdao = new HotplaceDAO();
		return htdao.selectHotplaceLocation();
	}

	public HotplaceVO selectHotplaceLocationByName(String hotplaceName) {
		HotplaceDAO htdao = new HotplaceDAO();
		return htdao.selectHotplaceLocationByName(hotplaceName);
	}
}
