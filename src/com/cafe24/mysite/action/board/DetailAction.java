package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

public class DetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		BoardDao dao = new BoardDao();
		
		BoardVo vo = dao.getBoard(Integer.parseInt(no));
		
		vo.setCount(vo.getCount()+1);
		
		dao.update(vo);
		
		request.setAttribute("board",vo);
		
		WebUtil.foward(request, response, "/WEB-INF/views/board/view.jsp");
		
	}

}
