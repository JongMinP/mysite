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

public class ArrowAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String page = request.getParameter("page");
		String indexCount = request.getParameter("indexCount");
		String kwd = request.getParameter("kwd");
		BoardDao dao = new BoardDao();

		Pager pager = new Pager();
		pager.setPage(Integer.parseInt(page));
		pager.setCurrentPage(pager.getPageStart());
		pager.setTotalCount(dao.getTotalCount());
		pager.setIndexCount(Integer.parseInt(indexCount));

		if (kwd == null) {
			kwd = "";
		}

		// List<BoardVo> list = dao.getListPage(pager.getPageStart() * 10 - 10, 10);
		List<BoardVo> list = dao.getListSearch(kwd, pager.getPageStart() * 10 - 10, 10);

		System.out.println(pager.getPageStart() + " " + pager.getPageEnd());
		request.setAttribute("boards", list);
		request.setAttribute("pager", pager);
		request.setAttribute("kwd",kwd);

		WebUtil.foward(request, response, "/WEB-INF/views/board/list.jsp");
	}

}
