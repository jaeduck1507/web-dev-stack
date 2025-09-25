package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVO;

public class DeptDAO {
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static DeptDAO single = null;

	public static DeptDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new DeptDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory;
	public DeptDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	//부서목록 조회
	public List<DeptVO> selectList(){
		
		SqlSession sqlSession = factory.openSession();
		List<DeptVO> list = 
				sqlSession.selectList("d.dept_list");
		sqlSession.close();
		
		return list;
		
	}
	
	//부서등록
	public int insertDept( DeptVO vo ) {
		
		SqlSession sqlSession = factory.openSession( true );
		int res = sqlSession.insert( "d.dept_insert", vo );
		sqlSession.close();
		
		return res;
		
	}
	
	//부서삭제
	public int delDept( int deptno ) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.delete( "d.dept_del", deptno );
		return res;
	}
	
	//수정할 부서정보 조회
	public DeptVO modifyDept( int deptno ) {
		SqlSession sqlSession = factory.openSession();
		
		DeptVO vo = sqlSession.selectOne( "d.modify_one", deptno );
		
		sqlSession.close();
		
		return vo;
	}
	
	//부서정보 수정
	public int updateFin( Map<String, Object> map ) {
		
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update( "d.upd_fin", map );
		sqlSession.close();
		
		return res;
		
	}
}




















