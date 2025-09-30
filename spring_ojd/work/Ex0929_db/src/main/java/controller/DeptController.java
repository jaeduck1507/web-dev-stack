package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class DeptController {
	
	DeptDAO dept_dao;
	public DeptController(DeptDAO dept_dao) {
		this.dept_dao = dept_dao;
	}
	
	@RequestMapping("list.do")
	public String list(Model model) {
		
		List<DeptVO> list = dept_dao.selectList();
		model.addAttribute("list",list); // DBㅔ서 가져온 값을 list에서 담아서 바인딩
		
		return "dept_list";
	}
	
	@RequestMapping("modifyform.do")
	public String modifyDept(DeptVO vo,Model model) {
//		System.out.println(vo.getDeptno());
		DeptVO res = dept_dao.selectOne(vo.getDeptno());
		model.addAttribute("res",res);
		return "dept_modifyfrom";
	}
	
	@RequestMapping("modify.do")
	public String modifyDo(DeptVO vo, Model model) {
		System.out.println(vo.getDname());
		dept_dao.modifyDept(vo);
		return "redirect:/list.do";
	}
	
	@RequestMapping("delete.do")
	public String deleteDept(int deptno) {
		System.out.println(deptno);
		dept_dao.deleteDept(deptno);
		return "redirect:/list.do";
	}
	
	@RequestMapping("insertform.do")
	public String insertDept() {
		
		return "insertform";
		
	}
	
	@RequestMapping("insert.do")
	public String insertDo(DeptVO vo) {
		System.out.println(vo.getDeptno());
		dept_dao.insertDept(vo);
		return "redirect:/list.do";
	}
}
