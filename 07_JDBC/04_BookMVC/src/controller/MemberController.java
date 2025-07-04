package controller;

import java.sql.SQLException;

import dao.MemberDAO;
import vo.Member;

public class MemberController {

	private MemberDAO dao = MemberDAO.getInstance();
	
	// 4. 회원가입
	public void register(Member member) throws SQLException {
	
			dao.register(member);
		
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) {
		try {
			return dao.login(id, pwd);
			
		} catch(Exception e) {
			
			
			return null;
		}
		
	}
	
	// 6. 회원탈퇴
	public void delete(String id) {
		try {
			dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 회원탈퇴시 대여중인 책을 모두 기록 삭제
	}
}






