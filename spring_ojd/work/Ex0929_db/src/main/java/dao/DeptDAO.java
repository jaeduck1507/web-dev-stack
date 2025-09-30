package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

public class DeptDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 부서목록
	
	public List<DeptVO> selectList() {
		List<DeptVO> list = sqlSession.selectList("d.dept_list");
		return list;
	}
	
	public DeptVO selectOne(int deptno) {
		DeptVO vo = sqlSession.selectOne("d.dept_one",deptno);
		return vo;
	}
	
	public int modifyDept(DeptVO vo) {
		int res = sqlSession.update("d.modify_dept",vo);
		return res;
	}
	
	public int deleteDept(int deptno) {
		int  res = sqlSession.delete("d.delete_dept",deptno);
		return res;
	}
	
	public int insertDept(DeptVO vo) {
		int res = sqlSession.insert("d.insert_dept",vo);
		return res;
	}
}
