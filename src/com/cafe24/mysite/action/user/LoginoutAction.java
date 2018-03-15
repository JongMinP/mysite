package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;

public class LoginoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		// logout 처리
		if (session != null && session.getAttribute("authUser") != null) { // 세션이랑 인증된 계정이 없을 경우
			session.removeAttribute("authUser");
			session.invalidate();
		}

		WebUtil.redirect(request, response, "/mysite/main");
	}

}
