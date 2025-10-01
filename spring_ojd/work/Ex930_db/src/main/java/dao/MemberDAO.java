package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class MemberDAO {
	SqlSession sqlSession;
	
	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MemberVO> memberList() {
		List<MemberVO> list = sqlSession.selectList("m.member_list");
		return list;
	}
	
	public int memberRegiter(MemberVO vo) {
		int res = sqlSession.insert("m.member_register",vo);
		return res;
	}
	
	public MemberVO selectIdCheck(String id) {
		MemberVO vo = sqlSession.selectOne("m.id_check",id);
		
		return vo;
	}
	
	public int memberDelete(int idx) {
		int res = sqlSession.delete("m.member_delete",idx);
		return res;
	}
	
	public MemberVO modifyForm(int idx) {
		MemberVO vo = sqlSession.selectOne("m.modify_form", idx);
		return vo;
	}
	
	public int modifyFin(MemberVO vo) {
		int res = sqlSession.insert("m.modify_fin",vo);
		return res;
	}
	
}
