package com.cafe24.mysite.action.board;

import com.cafe24.mvc.action.AbstractActionFactory;
import com.cafe24.mvc.action.Action;

public class BoardActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("write".equals(actionName)) {
			action = new WriteAction();
		} else if ("insertForm".equals(actionName)) {
			action = new InsertFormAction();
		} else if ("modify".equals(actionName)) {
			action = new ModifyAction();
		} else if ("modifyForm".equals(actionName)) {
			action = new ModifyFormAction();
		} else if ("detail".equals(actionName)) {
			action = new DetailAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if ("replyForm".equals(actionName)) {
			action = new ReplyFormAction();
		} else if ("reply".equals(actionName)) {
			action = new ReplyAction();
		} else if ("search".equals(actionName)) {
			action = new SearchAction();
		} else if ("pager".equals(actionName)) {
			action = new PagerAction();
		} else if ("arrow".equals(actionName)) {
			action = new ArrowAction();
		} else if ("comment".equals(actionName)) {
			action = new CommentAction();

		} else if ("commentDelete".equals(actionName)) {
			action = new CommentDeleteAction();
		} else {
			action = new ListAction();
		}

		return action;
	}

}
