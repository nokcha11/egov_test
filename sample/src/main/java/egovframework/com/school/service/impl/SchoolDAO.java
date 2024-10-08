package egovframework.com.school.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;


import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("SchoolDAO")
public class SchoolDAO extends EgovAbstractMapper{
	
	public List<HashMap<String, Object>> selectSchoolList() {
		return selectList("selectSchoolList");
	}

	public HashMap<String, Object> selectSchoolInfo(int schoolIdx) {
		return selectOne("selectSchoolInfo", schoolIdx);
	}
	
	public int insertSchoolInfo(HashMap<String, Object> ParamMap) {
		return insert("insertSchoolInfo", ParamMap);
	}
	
	public int deleteSchoolInfo(HashMap<String, Object> ParamMap) {
		return delete("deleteSchoolInfo", ParamMap);
	}
	
}
