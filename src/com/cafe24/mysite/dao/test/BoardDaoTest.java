package com.cafe24.mysite.dao.test;

import java.util.List;

import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.mysite.vo.UserVo;

public class BoardDaoTest {

	public static void main(String[] args) {
		// insert();
		// getList();
		// getListPage();
		getCount();
	}

	public static void getCount() {

		int result = new BoardDao().getTotalCount();
		
		System.out.println(result);
	}

	public static void getListPage() {

		BoardDao dao = new BoardDao();

		List<BoardVo> boards = dao.getListPage(0, 5);

		for (BoardVo vo : boards) {
			System.out.println(vo);
		}

	}

	public static void insert() {

		BoardDao dao = new BoardDao();

		BoardVo vo = new BoardVo();

		vo.setTitle("실험1");
		vo.setContent("실험 내용1");
		vo.setGroupNo(1L); // 그룹에서 가장 큰 그룹 넘버 찾아와서 default 1
		vo.setOrderNo(1L);
		vo.setDepth(1L);
		vo.setCount(0L); // 디폴트 0을 주자
		vo.setFile("파일1");
		vo.setUser(new UserVo(1L));

		// System.out.println(vo);

		dao.insert(vo);

	}

	public static void getList() {

		BoardDao dao = new BoardDao();

		List<BoardVo> list = dao.getList();

		for (BoardVo vo : list) {
			System.out.println(vo);
		}

	}

}
