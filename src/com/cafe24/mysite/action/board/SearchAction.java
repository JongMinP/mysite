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

public class SearchAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kwd = request.getParameter("kwd");
		
		BoardDao dao = new BoardDao();
		
		Pager pager = new Pager();
		List<BoardVo> list  = dao.getListSearch(kwd, pager.getPageStart()-1,10);
		
		pager.setTotalCount(dao.getTotalCount(kwd));
		pager.setIndexCount(dao.getTotalCount(kwd));
		
//		System.out.println(dao.getTotalCount(kwd));
//		System.out.println(pager);
		request.setAttribute("boards", list);
		
		request.setAttribute("kwd", kwd);
		request.setAttribute("pager", pager);
		
		WebUtil.foward(request, response, "/WEB-INF/views/board/list.jsp");
		
	}

}
