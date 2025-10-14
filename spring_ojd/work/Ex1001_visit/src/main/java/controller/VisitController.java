package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import util.PwdBcrypt;
import vo.VisitVO;

@Controller
public class VisitController {
	VisitDAO visit_dao;
	
	@Autowired
	ServletContext app;
	
	
	// 생성자 함수
	public VisitController(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	// 기본 경로에 방명록 리스트 전송
	@RequestMapping("/")
	public String visitList(Model model) {
		List<VisitVO> list = visit_dao.visitList(); 
		model.addAttribute("list", list);
		return "visit_list";
	}
	
	// 등록폼 이동
	@RequestMapping("/visit_regi_form.do")
	public String visitRegiForm() {
		return "visit_regi_form";
		
	}
	
	// 방명록 등록 기능
	@RequestMapping("/visit_register.do")
	public String visitRegister(VisitVO vo, HttpServletRequest request) {
		System.out.println(vo.getFile().isEmpty());
		// 방명록 비밀번호 암호화
		PwdBcrypt pbc = new PwdBcrypt();
		vo.setIp(request.getRemoteAddr());
		vo.setPwd(pbc.encodingPwd(vo.getPwd()));
		
		// 파일경로 저장
		vo.setFilename(fileUpload(vo.getFile()));
		
		
		
		visit_dao.visitRegister(vo);
		return "redirect:/";
	}
	
	
	// 방명록 삭제 기능(비밀번호 확인 포함)
	@ResponseBody
	@RequestMapping("/visit_delete.do")
	public String visitDelete(VisitVO vo) {
		PwdBcrypt pbc = new PwdBcrypt(); // util패키지에 만들어놓은 PwdBcrypt를 이용하여 객체 생성
		String res = "no"; // 비밀번호 판별의 결과 전송을 위한 데이터 초기화
		VisitVO checkingVo = visit_dao.visitSelectOne(vo.getIdx()); // 방명록 데이터를 idx정보를 통해 가져오기
		
		if(!pbc.validPwd(vo.getPwd(), checkingVo.getPwd())) { // 비밀번호 체크하여 틀릴시 그대로 데이터(no) 전송
			return res;
		}
		
		int delCheck = visit_dao.visitDelete(vo.getIdx()); // 비밀번호 일치 시 삭제 기능 실행
		if(delCheck == 0) {
			res = "error"; // 삭제 실패시 error 전송
		}
		
		if(!checkingVo.getFilename().equals("no_file")) {
			String webPath = "/resources/upload/";
			String savePath = app.getRealPath(webPath);
			
			String filename = savePath + checkingVo.getFilename();
			
			File file = new File(filename);
			
			if(file.exists()) {
				file.delete();
			}
			
		}
		
		res = "yes"; // 삭제 성공 시 yes 전송
		
		return res;
		 
	}
	
	// 방명록 수정폼 이동을 위한 비밀번호 일치 여부 확인 및 idx값 반환 기능
	@ResponseBody
	@RequestMapping("visit_modify_pwd_check.do")
	public String visitModifyPwdCheck(VisitVO vo) {
		PwdBcrypt pbc = new PwdBcrypt();
		VisitVO checkingVo = visit_dao.visitSelectOne(vo.getIdx());
		
		if(!pbc.validPwd(vo.getPwd(), checkingVo.getPwd())) {
			return "-1"; // idx정보를 보내야하는데 만약 비밀번호 불일치시 -1 전송
		}
		
		return Integer.toString(checkingVo.getIdx()); // 문자열로 변환하는 이유 ajax로 보내는 데이터는 문자열이여야함
		
	}
	
	// 방명록 수정폼 이동 기능
	@RequestMapping("visit_modify_form.do")
	public String visitModifyForm(int idx, Model model) {
		VisitVO vo = visit_dao.visitSelectOne(idx);
		
		model.addAttribute("vo", vo);
		return "visit_modify_form";
	}
	
	// 방명록 수정
	@RequestMapping("visit_modify.do")
	public String visitModify(VisitVO vo, HttpServletRequest request) {
		vo.setIp(request.getRemoteAddr());
		
		if(!vo.getFile().isEmpty()) {
			vo.setFilename(fileUpload(vo.getFile()));
		}
		
		visit_dao.visitModify(vo);
		return "redirect:/";
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
