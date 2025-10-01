package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVO;

public class ProductDAO {
	SqlSession sqlSession;

	public ProductDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<ProductVO> select(String category) {

		List<ProductVO> list = sqlSession.selectList("p.pro_list", category);

		return list;
	}

	// 상품등록
	public int insert(ProductVO vo) {

		int res = sqlSession.insert("p.pro_insert", vo);
		return res;

	}

	// 상세보기를 위한 상품조회
	public ProductVO selectOne(int idx) {

		ProductVO vo = sqlSession.selectOne("p.pro_one", idx);

		return vo;
	}
}
