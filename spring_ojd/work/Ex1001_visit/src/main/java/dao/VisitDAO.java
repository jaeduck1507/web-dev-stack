package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {
	SqlSession sqlSession;
	
	
	public VisitDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 방명록 리스트 조회
	public List<VisitVO> visitList() {
		List<VisitVO> list = sqlSession.selectList("v.select_list");
		return list;
	}
	
	// 방명록 등록
	public int visitRegister(VisitVO vo) {
		int res = sqlSession.insert("v.visit_register", vo);
		return res;
	}
	
	// 방명록 한개 조회(idx값 이용)
	public VisitVO visitSelectOne(int idx) {
		VisitVO vo = sqlSession.selectOne("v.visit_select_one",idx);
		return vo;
	}
	
	// 방명록 삭제(idx값 이용)
	public int visitDelete(int idx) {
		int res = sqlSession.delete("v.visit_delete",idx);
		return res;
	}
	
	// 방명록 수정
	public int visitModify(VisitVO vo) {
		int res = sqlSession.update("v.visit_modify", vo);
		return res;
	}
}
