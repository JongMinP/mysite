package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.UserDao;
import com.cafe24.mysite.vo.UserVo;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 널체크
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		UserVo authUser = new UserDao().get(email, password);
		
		if(authUser == null) {
			/* 인증실패 */
//			WebUtil.redirect(request, response, "/mysite/user?a=loginform&result=fail"); // redirect 방식
			
			request.setAttribute("result", "fail");
			request.setAttribute("email", email);
			WebUtil.foward(request, response, "/WEB-INF/views/user/loginform.jsp");  // forward 방식
			return; //여기서 밑에 코드 실행 안하기 위해 리턴
		}
		
		/* 인증성공 */
		// Application > Session > request > page
		// cookies
		/* 인증 처리 */
		HttpSession session =  request.getSession(true); // ture이면 만들어서 줌
		session.setAttribute("authUser", authUser);
		
		
		WebUtil.redirect(request, response, "/mysite/main");
		
	}

}
