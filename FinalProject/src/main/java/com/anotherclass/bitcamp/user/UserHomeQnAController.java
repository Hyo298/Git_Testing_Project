package com.anotherclass.bitcamp.user;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anotherclass.bitcamp.service.UserHomeQnAService;
import com.anotherclass.bitcamp.vo.UserHomeQnAVO;

@Controller
public class UserHomeQnAController {
	@Inject
	UserHomeQnAService userHomeQnAService;
	
	//고객지원 - 홈페이지문의->리스트목록보기
	@RequestMapping("/HomeQnAAsk/list")
	public ModelAndView HomeQnAAskList() {
		
		ModelAndView mav = new ModelAndView();	
		mav.addObject("list",userHomeQnAService.userHomeQnAAllSelect());		
		mav.setViewName("/user/HomeQnA/userHelper_HomeQnA_list");		
		return mav;
	}
	//문의하기(글쓰기)페이지로 이동
	@RequestMapping("/HomeQnAAsk/write")
	public String HomeQnAAskWrite() {
		return "/user/HomeQnA/userHelper_HomeQnA_write";
	}
	
	//글등록
	@RequestMapping(value="/HomeQnAAsk/writeOk",method=RequestMethod.POST)
	public ModelAndView HomeQnAAskWriteOk(UserHomeQnAVO vo, HttpSession ses) {
	
		vo.setMember_id((String)ses.getAttribute("member_id"));
		int result = userHomeQnAService.userHomeQnAWrite(vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:list");
		return mav;
	}
	
	//제목누르면 글보기
	@RequestMapping("/HomeQnAAsk/view")
	public ModelAndView HomeQnAAskView(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo",userHomeQnAService.userHomeQnAView(no));
		mav.setViewName("/user/HomeQnA/userHelper_HomeQnA_view");
		return mav;
	}
	
	//수정페이지로 이동
	@RequestMapping("/HomeQnAAsk/editForm")
	public ModelAndView HomeQnAAskEditForm(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", userHomeQnAService.userHomeQnAView(no));
		mav.setViewName("/user/HomeQnA/userHelper_HomeQnA_edit");
		return mav;
	}
	
	//글수정
	@RequestMapping(value="/HomeQnAAsk/edit",method = RequestMethod.POST)
	public ModelAndView HomeQnAAskEdit(UserHomeQnAVO vo, HttpSession ses) {
		vo.setMember_id((String)ses.getAttribute("member_id"));
		int result = userHomeQnAService.userHomeQnAEdit(vo);
		ModelAndView mav = new ModelAndView();
		if(result>0) {
			mav.setViewName("redirect:view");
			mav.addObject("no",vo.getUser_qna_no());
		}else{
			 mav.setViewName("/user/HomeQnA/userHelper_HomeQnA_result");

		}
		return mav;
	}
	
	//글삭제 -> 컬럼값 업데이트....답글이잇다면 답글 컬럼값도 업데이트
	@RequestMapping(value="/HomeQnAAsk/del",method=RequestMethod.POST)
	public ModelAndView HomeQnAAskDel(int no , HttpSession session) {
		
		String member_id = (String)session.getAttribute("member_id"); //이부분은 삭세해도될거같은데
		int result = userHomeQnAService.userHomeQnADel(no);
		ModelAndView mav = new ModelAndView();
		if(result>0) {
			mav.setViewName("redirect:list"); //디ㅏ른컨트롤러호풀
		}else {
			System.out.println("삭제실패");
			mav.addObject("no",no); //no라는 변수에 매개변수no를 보맨다
			mav.setViewName("redirect:view");
		}
		return mav;
	}
	
	
	
}
