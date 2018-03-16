package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.mysite.vo.UserVo;

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bno = request.getParameter("bno");

		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDao dao = new BoardDao();

		BoardVo vo = dao.getBoard(Integer.parseInt(bno));

		BoardVo bvo = new BoardVo();

		HttpSession session = request.getSession(true);

		bvo.setContent(content);
		bvo.setTitle(title);
		bvo.setGroupNo(vo.getGroupNo());
		bvo.setOrderNo(vo.getOrderNo() + 1);
		bvo.setDepth(vo.getDepth() + 1);
		bvo.setUser((UserVo) session.getAttribute("authUser"));

		dao.replyWrite(bvo);

		WebUtil.redirect(request, response, "/mysite/board");

	}

}
