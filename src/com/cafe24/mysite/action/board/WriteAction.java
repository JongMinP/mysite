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

public class WriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession(true);
		
		UserVo vo =(UserVo)session.getAttribute("authUser");
		
		BoardVo bVo = new BoardVo();
		
		bVo.setTitle(title);
		bVo.setContent(content);
		
		bVo.setUser(vo);
		
		new BoardDao().insert(bVo);
		
		WebUtil.redirect(request, response, "/mysite/board");
		
		
	}

}
