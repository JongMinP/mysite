package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String no = request.getParameter("no");

		BoardDao dao = new BoardDao();

		BoardVo vo = dao.getBoard(Integer.parseInt(no));

		vo.setTitle(title);
		vo.setContent(content);

		dao.update(vo);

		WebUtil.redirect(request, response, "/mysite/board?a=detail&no=" + no);
	}

}
