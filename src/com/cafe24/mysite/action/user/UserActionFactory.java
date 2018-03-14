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
		}

		else { // 메인 action으로 포워딩
			action = new IndexAction();
		}

		return action;
	}

}
