package egovframework.com.studentMng.service;

import java.util.HashMap;
import java.util.List;

public interface StudentMngService {
	public List<HashMap<String, Object>> selectStudentMngList();
	
	public HashMap<String, Object> selectStudentMngInfo(int studentlId);
	
	public int insertStudentMngList(HashMap<String, Object> paramMap);
}