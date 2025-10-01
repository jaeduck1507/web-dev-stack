package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CartDAO;
import vo.CartVO;

@Controller
public class CartController {
	CartDAO cart_dao;
	
	public CartController(CartDAO cart_dao) {
		this.cart_dao = cart_dao;
	}
	
	@RequestMapping("cart_list.do")
	public String cartList(CartVO vo, Model model) {
		List<CartVO> list = cart_dao.select(vo.getM_idx());
		int total = cart_dao.selectTotalAmount(vo.getM_idx());
		model.addAttribute("list", list);
		model.addAttribute("total", total);
		
		return "cartList";
	}
	
	@ResponseBody
	@RequestMapping("cart_insert.do")
	public String cartInsert(CartVO vo) {
		String result = "no";
		
		CartVO resVo = cart_dao.selectOne(vo);
		
		if( resVo == null ) {
			
			result = "yes";
			//상품을 장바구니에 등록
			cart_dao.insert(vo);
		}
		
		return result;
	}
	
	@RequestMapping("cart_delete.do")
	public String  cartDelete(CartVO vo) {
		cart_dao.delete(vo.getC_idx());
		String path = "redirect:/cart_list.do?m_idx=" + vo.getM_idx();
		return path;
	}
	
	@RequestMapping("cart_update.do") 
	public String cartUpdate(CartVO vo) {
		cart_dao.update_cnt(vo);
		String path = "redirect:/cart_list.do?m_idx=" + vo.getM_idx();
		return path;
	}
}
