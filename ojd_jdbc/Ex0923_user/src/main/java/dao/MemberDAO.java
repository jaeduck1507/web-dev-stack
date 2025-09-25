package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVO;

public class MemberDAO {

	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static MemberDAO single = null;

	public static MemberDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new MemberDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory;
	public MemberDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	//전체 회원 조회
	public List<MemberVO> selectList(){
		SqlSession sqlSession = factory.openSession();
		List<MemberVO> list = sqlSession.selectList( "m.selectList" );
		sqlSession.close();
		
		return list;
	}
	
	//회원등록
	public int insertMember( MemberVO vo ) {
		
		SqlSession sqlSession = factory.openSession(true);
		
		int res = sqlSession.insert("m.insert_member", vo);
		
		sqlSession.close();
		return res;
		
	}
	
	//회원삭제
	public int deleteMember( int idx ) {
		
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.delete("m.del_member", idx);
		sqlSession.close();
		
		return res;
		
	}
	
	//수정할 회원의 정보 조회
	public MemberVO searchIdx( int idx ) {
		SqlSession sqlSession = factory.openSession();
		MemberVO vo = sqlSession.selectOne("m.search_idx", idx);
		sqlSession.close();
		
		return vo;
	}
	
	//회원정보 수정
	public int modifyFin( MemberVO vo ) {
		SqlSession sqlSession = factory.openSession( true );
		int res = sqlSession.update("m.modify_fin", vo);
		sqlSession.close();
		
		return res;
	}
	
	//아이디 중복체크
	public MemberVO selectOne( String id ) {
		
		SqlSession sqlSession = factory.openSession();
		MemberVO vo = sqlSession.selectOne("m.selectOne", id);
		sqlSession.close();
		
		return vo;
		
	}
}
















