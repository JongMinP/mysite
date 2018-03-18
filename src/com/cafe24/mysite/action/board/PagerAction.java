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

public class PagerAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageStart = Integer.parseInt(request.getParameter("pageStart"));
//		int pageEnd = Integer.parseInt(request.getParameter("pageEnd"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int totalCount = Integer.parseInt(request.getParameter("totalCount"));

		BoardDao dao = new BoardDao();

		List<BoardVo> list = dao.getListPage(pageStart, 5);

		request.setAttribute("boards", list);

		Pager pager = new Pager();

		pager.setCurrentPage(currentPage);
		pager.setTotalCount(totalCount);

		request.setAttribute("pager", pager);
		
		WebUtil.foward(request, response, "/WEB-INF/views/board/list.jsp");

	}

}
