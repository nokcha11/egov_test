package egovframework.com.school.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.school.service.SchoolService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("SchoolService")
public class SchoolServiceimpl extends EgovAbstractServiceImpl implements SchoolService {
	
	
	@Resource(name="SchoolDAO")
	private SchoolDAO schoolDAO;

	@Override
	public List<HashMap<String, Object>> selectSchoolList() {
		// TODO Auto-generated method stub
		
		List<HashMap<String, Object>> list = schoolDAO.selectSchoolList();
		
		return list;
	}

	@Override
	public HashMap<String, Object> selectSchoolInfo(int schoolIdx) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> schoolInfo = schoolDAO.selectSchoolInfo(schoolIdx);
		return schoolInfo;
		
	}
	
	@Override
	public int insertSchoolInfo(HashMap<String, Object> ParamMap) {
		// TODO Auto-generated method stub
		
		int resultChk =0;
		
		resultChk = schoolDAO.insertSchoolInfo(ParamMap);
		return resultChk;
	}



}
