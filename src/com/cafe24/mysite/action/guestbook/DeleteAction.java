package com.cafe24.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.GuestBookDao;
import com.cafe24.mysite.vo.GuestBookVo;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String password = request.getParameter("password");
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println(password);
		System.out.println(no);

		GuestBookDao dao = new GuestBookDao();
		GuestBookVo vo = dao.getGusetBook(no);

		if (password.equals(vo.getPassword())) {
			dao.delete(no);
		}
		WebUtil.redirect(request, response, "/mysite/guestbook");
	}

}
