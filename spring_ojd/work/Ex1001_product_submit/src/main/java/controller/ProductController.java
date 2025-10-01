package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ProductDAO;
import vo.ProductVO;

@Controller
public class ProductController {
	ProductDAO product_dao;
	
	public ProductController(ProductDAO product_dao) {
		this.product_dao = product_dao;
	}
	
	@RequestMapping("list.do") 
	public String productList(ProductVO vo, Model model) {
		String category = vo.getCategory();
		
		if( category == null || category.isEmpty() ) {
			category = "com001";
		}
		
		List<ProductVO> list = product_dao.select(category);
		
		model.addAttribute("list",list);
		
		
		return "product_list";
	}
	
	@RequestMapping("view.do")
	public String productDetail(ProductVO vo, Model model) {
		ProductVO targetVo = product_dao.selectOne(vo.getIdx());
		model.addAttribute("vo", targetVo);
		return "product_content";
	}
	
	@RequestMapping("product_regi_form.do")
	public String productRegiForm() {
		return "product_regi_form";
	}
	
	@RequestMapping("insert.do")
	public String productInsert(ProductVO vo) {
		System.out.println(vo);
		product_dao.insert(vo);
		String path = "redirect:/list.do?category=" + vo.getCategory();
		return path;
	}
}
