package egovframework.com.studentMng.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("StudentMngDAO")
public class StudentMngDAO extends EgovAbstractMapper{
	
	public List<HashMap<String, Object>> selectStudentMngList(){
		return selectList("selectStudentMngList");
	}
	
	//세부정보
	public HashMap<String, Object> selectStudentMngInfo(int studentlId){
		return selectOne("selectStudentMngInfo", studentlId);
	}

	public int insertStudentMngList(HashMap<String, Object> paramMap) {
		return insert("insertStudentMngList", paramMap);
	}
	
	public int insertStudentMng(HashMap<String, Object> paramMap) {
		return insert("insertStudentMng", paramMap);
	}
}