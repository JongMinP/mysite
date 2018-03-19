package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.CommentDao;
import com.cafe24.mysite.vo.CommentVo;
import com.cafe24.mysite.vo.UserVo;

public class CommentAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String boardNo=request.getParameter("boardNo");
		String content = request.getParameter("content");

		CommentDao dao = new CommentDao();
		
		CommentVo vo = new CommentVo();
		
		HttpSession session = request.getSession(true);
		
		vo.setContent(content);
		vo.setBoardNo(Long.parseLong(boardNo));
		vo.setUser((UserVo)session.getAttribute("authUser"));
		
		dao.insert(vo);
		
		WebUtil.redirect(request, response, "/mysite/board?a=detail&no="+boardNo);
		
	}

}
