package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.MemberController;
import dao.MemberDAO;
import vo.Member;

class MemberControllerTest {

	private MemberDAO dao;
	private MemberController mc = new MemberController();
	
	@BeforeEach
	void setUp() {
		dao = MemberDAO.getInstance();
	}
	// @BeforeEach : 각 테스트 메서드가 실행된 후에 무조건 실행
	@AfterEach
	void  setDown() throws SQLException {
		dao.connect().prepareStatement("DELETE FROM member").executeUpdate();
		
	}
	
	@Test
	void testRegister() throws SQLException {
		Member m = new Member("test01","테스트01","pass01", 1);
		mc.register(m);
	}
	
//	@Test
//	void testRegisterSameId() throws SQLException {
//		testRegister();
//		Member m = new Member("test01","테스트01","pass01", 1);
//		mc.register(m);
//	}
	
	@Test
	void TestLoginSuccess() throws SQLException {
		testRegister();
		Member m =mc.login("test01", "pass01");
		assertNotEquals(m, null);
	}
	
	@Test
	void TestLoginFail() throws SQLException {
		testRegister();
		Member m =mc.login("test02", "pass02");
		assertEquals(m, null);
	}
	
	@Test
	void TestDelete() throws SQLException {
		testRegister();
		mc.delete("test01");
	}
	
}
