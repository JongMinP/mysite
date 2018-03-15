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

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");

		HttpSession session = request.getSession(true);

		UserDao dao = new UserDao();

		UserVo vo = new UserVo();

		vo.setNo(((UserVo) session.getAttribute("authUser")).getNo());
		vo.setName(name);
		vo.setPassword(password);
		vo.setGender(gender);

		dao.update(vo);

		if (session != null && session.getAttribute("authUser") != null) { // 세션이랑 인증된 계정이 없을 경우
			session.removeAttribute("authUser");
			session.invalidate();
		}

		WebUtil.redirect(request, response, "/mysite/user?a=updatesuccess");
	}

}
