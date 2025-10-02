package controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import dao.ProductDAO;
import vo.ProductVO;

@Controller
public class ProductController {
	ProductDAO product_dao;
	
	@Autowired
	ServletContext app;
	
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
		vo.setP_image_s(fileUpload(vo.getP_image_s_file()));
		vo.setP_image_l(fileUpload(vo.getP_image_l_file()));
		product_dao.insert(vo);
		String path = "redirect:/list.do?category=" + vo.getCategory();
		return path;
	}
	
	// 파일 업로드 메소드
		public String fileUpload(MultipartFile file) {
			String webPath = "/resources/upload/";
			String savePath = app.getRealPath(webPath);
			
			String filename = "no_file";
			
			if(!file.isEmpty()) {
				
				filename = file.getOriginalFilename();
				
				File saveFile = new File(savePath,filename);
				if(!saveFile.exists()) {
					saveFile.mkdirs();
				} else {
					long time = System.currentTimeMillis();
					filename = String.format("%d_%s",time,filename );
					saveFile = new File(savePath,filename);
				}
				
				try {
					file.transferTo(saveFile);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
			}
			
			return filename;
		}
}
