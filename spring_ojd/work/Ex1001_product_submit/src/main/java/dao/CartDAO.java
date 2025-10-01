package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.CartVO;

public class CartDAO {
	SqlSession sqlSession;
	
	public CartDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//회원별 장바구니 목록
		public List<CartVO> select( int m_idx ){
			
			List<CartVO> list = sqlSession.selectList("c.cart_list", m_idx);
			
			return list;
			
		}
		
		//장바구니에 담긴 상품들의 총 합
		public int selectTotalAmount( int m_idx ) {
			
			int total = sqlSession.selectOne("c.cart_total_amount", m_idx);
			
			return total;
		}
		
		//이미 장바구니에 등록된 상품인지 조회
		public CartVO selectOne( CartVO vo ) {
			
			CartVO resVo = sqlSession.selectOne("c.cart_one", vo);
			
			return resVo;
			
		}
		
		//장바구니에 항목 추가
		public int insert( CartVO vo ) {
			
			int res = sqlSession.insert("c.cart_insert", vo);
			
			return res;
		}
		
		//장바구니 수량 업데이트
		public int update_cnt( CartVO vo ) {
			
			int res = sqlSession.update("c.cart_cnt", vo);
			
			return res;
			
		}
		
		//장바구니 상품 삭제
		public int delete( int c_idx ) {
			
			int res = sqlSession.delete( "c.cart_del", c_idx );
			
			return res;
		}
}
