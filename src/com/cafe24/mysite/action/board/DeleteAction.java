package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.dao.CommentDao;
import com.cafe24.mysite.vo.BoardVo;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String no = request.getParameter("no");
		String groupNo = request.getParameter("groupNo");
		String orderNo = request.getParameter("orderNo");

		BoardDao dao = new BoardDao();

		new CommentDao().boardDelete(Integer.parseInt(no));

		dao.groupDelete(Integer.parseInt(groupNo), Integer.parseInt(orderNo));

		dao.delete(Integer.parseInt(no));

		WebUtil.redirect(request, response, "/mysite/board");
	}

}
