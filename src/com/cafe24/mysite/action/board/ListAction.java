package com.cafe24.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.mysite.vo.Pager;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao dao = new BoardDao();
		
		List<BoardVo> list = dao.getListPage(0, 10);
		
		request.setAttribute("boards", list);
		
		int totalCount = dao.getTotalCount();
		
		Pager pager = new Pager();
		pager.setTotalCount(totalCount);
		pager.setIndexCount(totalCount);
		
		request.setAttribute("pager", pager);
		
		
		WebUtil.foward(request, response, "/WEB-INF/views/board/list.jsp");
	}

}
