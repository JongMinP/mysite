package com.cafe24.mysite.action.user;

import com.cafe24.mvc.action.AbstractActionFactory;
import com.cafe24.mvc.action.Action;
import com.cafe24.mysite.action.main.IndexAction;

public class UserActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("joinform".equals(actionName)) {
			action = new JoinFormAction();

		} else if ("loginform".equals(actionName)) {
			action = new LoginFormAction();

		} else if ("joinsuccess".equals(actionName)) {
			action = new JoinSuccessAction();

		} else if ("join".equals(actionName)) {
			action = new JoinAction();

		} else if ("login".equals(actionName)) {
			action = new LoginAction();

		} else if ("logout".equals(actionName)) {
			action = new LoginoutAction();

		} else if ("updateform".equals(actionName)) {
			action = new UpdateFormAction();

		} else if ("update".equals(actionName)) {
			action = new UpdateAction();

		} else if ("updatesuccess".equals(actionName)) {
			action = new UpdateSuccessAction();

		}else { // 메인 action으로 포워딩
			action = new IndexAction();
		}

		return action;
	}

}
