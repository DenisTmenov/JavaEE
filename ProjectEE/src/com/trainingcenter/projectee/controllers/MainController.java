package com.trainingcenter.projectee.controllers;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainingcenter.projectee.beans.UserAllInfoBean;
import com.trainingcenter.projectee.beans.UserBean;
import com.trainingcenter.projectee.beans.UserInfoBean;
import com.trainingcenter.projectee.beans.UserRoleBean;
import com.trainingcenter.projectee.controllers.helpers.LinkKeeper;
import com.trainingcenter.projectee.dao.UserDao;
import com.trainingcenter.projectee.dao.mysql.MySqlUserDaoImpl;
import com.trainingcenter.projectee.dao.mysql.MySqlUserInfoDaoImpl;
import com.trainingcenter.projectee.dao.mysql.MySqlUserRoleDaoImpl;
import com.trainingcenter.projectee.utils.HttpUtils;

@WebServlet("/main.html")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ACTION_IN_SESSION_CODE = "actionInSession";

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String userLogin = null;

		String profileValue = returnParameterValue("Profile", request);
		String btnChangeProfileValue = returnParameterValue("BtnChangeProfile", request);
		String btnChangeProfileSave = returnParameterValue("BtnChangeProfileSave", request);
		String BtnChangeProfileCansel = returnParameterValue("BtnChangeProfileCansel", request);
		if (!profileValue.equals("")) {
			session.setAttribute(ACTION_IN_SESSION_CODE, "Profile");
			userLogin = (String) session.getAttribute(LinkKeeper.SESSION_USER_BEAN_LOGIN);
			sendAllUserBeanToSession(userLogin, session);
		}

		if (!btnChangeProfileValue.equals("")) {
			session.setAttribute(ACTION_IN_SESSION_CODE, "ProfileChange");
		}

		if (!btnChangeProfileSave.equals("")) {
			userLogin = (String) session.getAttribute(LinkKeeper.SESSION_USER_BEAN_LOGIN);
			saveInfoInDB(userLogin, request, session);
			sendAllUserBeanToSession(userLogin, session);
			session.setAttribute(ACTION_IN_SESSION_CODE, "Profile");
		}

		if (!BtnChangeProfileCansel.equals("")) {
			session.setAttribute(ACTION_IN_SESSION_CODE, "ProfileChange");
		}

		HttpUtils.forwardToView(LinkKeeper.JSP_MAIN, request, response);

	}

	private String returnParameterValue(String nameParameter, HttpServletRequest request) {
		if (HttpUtils.isParameterExists(request, nameParameter)) {
			String value = (String) request.getParameter(nameParameter);
			return value;
		}
		return "";
	}

	private void sendAllUserBeanToSession(String login, HttpSession session) {
		MySqlUserDaoImpl userDao = new MySqlUserDaoImpl();
		UserAllInfoBean userAllInfoBean = userDao.loadAllUserInfoByLogin(login);

		session.setAttribute(LinkKeeper.SESSION_USER_BEAN_LOGIN, userAllInfoBean.getLogin());
		session.setAttribute(LinkKeeper.SESSION_USER_BEAN_PASSWORD, userAllInfoBean.getPassword());
		session.setAttribute(LinkKeeper.SESSION_USER_BEAN_DEL_STATUS, userAllInfoBean.getDelStatus());
		session.setAttribute(LinkKeeper.SESSION_USER_BEAN_FIRST_NAME, userAllInfoBean.getFirstName());
		session.setAttribute(LinkKeeper.SESSION_USER_BEAN_LAST_NAME, userAllInfoBean.getLastName());
		session.setAttribute(LinkKeeper.SESSION_USER_BEAN_ROLE, userAllInfoBean.getRole());
		session.setAttribute(LinkKeeper.SESSION_USER_BEAN_EMAIL, userAllInfoBean.getEmail());
	}

	private void saveInfoInDB(String userLogin, HttpServletRequest request, HttpSession session) {
		String userLoginNew = returnParameterValue("userLoginNew", request);
		String userPasswordNew = returnParameterValue("userPasswordNew", request);
		String userFirstNameNew = returnParameterValue("userFirstNameNew", request);
		String userLastNameNew = returnParameterValue("userLastNameNew", request);
		String userEmailNew = returnParameterValue("userEmailNew", request);
		// String userDelStatusNew = returnParameterValue("userDelStatusNew",
		// request);
		String userRoleNew = returnParameterValue("userRoleNew", request);

		if (userLoginNew.equals("")) {
			userLoginNew = (String) session.getAttribute(LinkKeeper.SESSION_USER_BEAN_LOGIN);
		}
		if (userPasswordNew.equals("")) {
			userPasswordNew = (String) session.getAttribute(LinkKeeper.SESSION_USER_BEAN_PASSWORD);
		}
		if (userFirstNameNew.equals("")) {
			userFirstNameNew = (String) session.getAttribute(LinkKeeper.SESSION_USER_BEAN_FIRST_NAME);
		}
		if (userLastNameNew.equals("")) {
			userLastNameNew = (String) session.getAttribute(LinkKeeper.SESSION_USER_BEAN_LAST_NAME);
		}
		if (userEmailNew.equals("")) {
			userEmailNew = (String) session.getAttribute(LinkKeeper.SESSION_USER_BEAN_EMAIL);
		}
		// if(userDelStatusNew.equals("")){
		// userDelStatusNew = (String)
		// session.getAttribute(LinkKeeper.SESSION_USER_BEAN_DEL_STATUS);
		// }
		if (userRoleNew.equals("")) {
			userRoleNew = (String) session.getAttribute(LinkKeeper.SESSION_USER_BEAN_ROLE);
		}

		MySqlUserDaoImpl userDao = new MySqlUserDaoImpl();
		MySqlUserInfoDaoImpl userInfoDao = new MySqlUserInfoDaoImpl();
		MySqlUserRoleDaoImpl userRoleDao = new MySqlUserRoleDaoImpl();

		Integer numUserRole = userRoleDao.returnIdRoleByNameRole(userRoleNew);
		Integer numIdUser = userDao.returnIdByLogin(userLogin);

		UserBean userBean = new UserBean();
		userBean.setIdUser(numIdUser);
		userBean.setLogin(userLoginNew);
		userBean.setPassword(userPasswordNew);
		userBean.setDelStatus(false);
		userBean.setFkRole(numUserRole);

		userDao.update(userBean);

		Integer idUserInfo = userInfoDao.returnIdInfoByFkIdUser(numIdUser);

		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setIdInfo(idUserInfo);
		userInfoBean.setFirstName(userFirstNameNew);
		userInfoBean.setLastName(userLastNameNew);
		userInfoBean.setEmail(userEmailNew);
		userInfoBean.setFkIdUser(numIdUser);

		userInfoDao.update(userInfoBean);
	}
}
