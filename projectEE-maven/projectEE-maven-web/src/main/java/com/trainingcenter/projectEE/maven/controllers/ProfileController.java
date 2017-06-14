package com.trainingcenter.projectEE.maven.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainingcenter.projectEE.maven.controllers.helpers.LinkKeeper;
import com.trainingcenter.projectEE.maven.dao.entity.UserEntity;
import com.trainingcenter.projectEE.maven.dao.entity.UserInfoEntity;
import com.trainingcenter.projectEE.maven.dao.mysql.MySqlUserDaoImpl;
import com.trainingcenter.projectEE.maven.dao.mysql.MySqlUserInfoDaoImpl;
import com.trainingcenter.projectEE.maven.dao.mysql.MySqlUserRoleDaoImpl;
import com.trainingcenter.projectEE.maven.domain.ProfileDto;
import com.trainingcenter.projectEE.maven.utils.HttpUtils;

@WebServlet("/profile.html")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String BTN_CHANGE_PROFILE_CODE = "BtnChangeProfile";
	private final String BTN_CHANGE_PROFILE_CANSEL_CODE = "BtnChangeProfileCansel";
	private final String BTN_CHANGE_PROFILE_SAVE_CODE = "BtnChangeProfileSave";
	private final String BTN_CHANGE_PROFILE_VALUE = "Change profile information";
	private final String BTN_CHANGE_PROFILE_CANSEL_VALUE = "Cansel";
	private final String BTN_CHANGE_PROFILE_SAVE_VALUE = "Save";

	private final String ROLE_NAME_ADMIN = "Administrator";
	private final String ROLE_NAME_MODERATOR = "Moderator";
	private final String ROLE_NAME_USER = "User";

	private final String PROFILE_IS_CHANGE_CODE = "bobyProfileIsChange";
	private final String PROFILE_IS_CHANGE_VALUE = "true";

	private final String PROFILE_DTO_IN_SESSION = "profileDto";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		sendProfileDtoToSession(request);

		HttpUtils.includeView(LinkKeeper.JSP_HEADER, request, response);
		HttpUtils.includeView(LinkKeeper.JSP_MENU, request, response);
		includeBobyProfilePage(request, response);
		HttpUtils.includeView(LinkKeeper.JSP_FOOTER, request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String btnChangeProfile = HttpUtils.returnRequestParameterValue(BTN_CHANGE_PROFILE_CODE, request);
		String btnChangeProfileCansel = HttpUtils.returnRequestParameterValue(BTN_CHANGE_PROFILE_CANSEL_CODE, request);
		String btnChangeProfileSave = HttpUtils.returnRequestParameterValue(BTN_CHANGE_PROFILE_SAVE_CODE, request);
		String login = (String) session.getAttribute(WelcomeController.SESSION_USER_BEAN_LOGIN);

		if (btnChangeProfile.equals(BTN_CHANGE_PROFILE_VALUE)) {
			session.setAttribute(PROFILE_IS_CHANGE_CODE, PROFILE_IS_CHANGE_VALUE);
		}
		if (btnChangeProfileCansel.equals(BTN_CHANGE_PROFILE_CANSEL_VALUE)) {
			// очистить все поля
			System.out.println("button cansel");
		}
		if (btnChangeProfileSave.equals(BTN_CHANGE_PROFILE_SAVE_VALUE)) {
			saveInfoInDB(login, request, session);
			sendProfileDtoToSession(request);
			session.removeAttribute(PROFILE_IS_CHANGE_CODE);

		}

		response.sendRedirect(LinkKeeper.PAGE_PROFILE);
	}

	private void sendProfileDtoToSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute(WelcomeController.SESSION_USER_BEAN_LOGIN);
		ProfileDto profileDto = profileDtoFromDB(login);
		session.setAttribute(PROFILE_DTO_IN_SESSION, profileDto);
	}

	private ProfileDto profileDtoFromDB(String login) {
		MySqlUserDaoImpl userDao = new MySqlUserDaoImpl();

		UserEntity userEntity = userDao.loadUserByLogin(login);
		UserInfoEntity userInfoEntity = userDao.returnUserInfoByLogin(login);
		String userRole = userDao.returnRoleByLogin(login);

		ProfileDto profileDto = new ProfileDto();

		profileDto.setLogin(userEntity.getLogin());
		profileDto.setPassword(userEntity.getPassword());
		profileDto.setDelStatus(userEntity.getDelStatus());
		profileDto.setEmail(userInfoEntity.getEmail());
		profileDto.setFirstName(userInfoEntity.getFirstName());
		profileDto.setLastName(userInfoEntity.getLastName());
		profileDto.setRole(userRole);

		return profileDto;

	}

	private void includeBobyProfilePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute(WelcomeController.SESSION_USER_BEAN_ROLE);
		String nameBody = (String) session.getAttribute(PROFILE_IS_CHANGE_CODE);
		if (role.equals(ROLE_NAME_USER)) {
			if (nameBody == null) {
				HttpUtils.includeView(LinkKeeper.JSP_PROFILE_USER_CLEAN, request, response);
			} else if (nameBody.equals(PROFILE_IS_CHANGE_VALUE)) {
				HttpUtils.includeView(LinkKeeper.JSP_PROFILE_USER_CHANGE, request, response);
			}
		} else if (role.equals(ROLE_NAME_ADMIN)) {
			if (nameBody == null) {
				HttpUtils.includeView(LinkKeeper.JSP_PROFILE_ADMINISTRATOR_CLEAN, request, response);
			} else if (nameBody.equals(PROFILE_IS_CHANGE_VALUE)) {
				HttpUtils.includeView(LinkKeeper.JSP_PROFILE_ADMINISTRATOR_CHANGE, request, response);
			}
		} else if (role.equals(ROLE_NAME_MODERATOR)) {
			if (nameBody == null) {
				HttpUtils.includeView(LinkKeeper.JSP_PROFILE_MANAGER_CLEAN, request, response);
			} else if (nameBody.equals(PROFILE_IS_CHANGE_VALUE)) {
				HttpUtils.includeView(LinkKeeper.JSP_PROFILE_MANAGER_CHANGE, request, response);
			}
		}
	}

	private void saveInfoInDB(String login, HttpServletRequest request, HttpSession session) {
		ProfileDto profileDtoNew = createProfileFromPageInfo(request);
		ProfileDto profileDtoReplase = replaseEmptyFromDB(profileDtoNew, login);

		MySqlUserDaoImpl userDao = new MySqlUserDaoImpl();
		MySqlUserInfoDaoImpl userInfoDao = new MySqlUserInfoDaoImpl();
		MySqlUserRoleDaoImpl userRoleDao = new MySqlUserRoleDaoImpl();

		UserEntity userEntity = new UserEntity();
		userEntity.setLogin(profileDtoReplase.getLogin());
		userEntity.setPassword(profileDtoReplase.getPassword());
		userEntity.setDelStatus(profileDtoReplase.getDelStatus());
		Integer fkRole = userRoleDao.returnIdRoleByNameRole(profileDtoReplase.getRole());
		userEntity.setFkRole(fkRole);
		userEntity.setIdUser(userDao.returnIdByLogin(login));

		userDao.update(userEntity);

		UserInfoEntity userInfoEntity = new UserInfoEntity();
		userInfoEntity.setEmail(profileDtoReplase.getEmail());
		userInfoEntity.setFirstName(profileDtoReplase.getFirstName());
		userInfoEntity.setLastName(profileDtoReplase.getLastName());
		userInfoEntity.setIdInfo(userInfoDao.returnIdInfoByFkIdUser(userDao.returnIdByLogin(login)));
		userInfoEntity.setFkIdUser(userDao.returnIdByLogin(login));

		userInfoDao.update(userInfoEntity);
	}

	private ProfileDto replaseEmptyFromDB(ProfileDto profileDto, String login) {
		String userLoginNew = profileDto.getLogin();
		String userPasswordNew = profileDto.getPassword();
		String userFirstNameNew = profileDto.getFirstName();
		String userLastNameNew = profileDto.getLastName();
		String userEmailNew = profileDto.getEmail();
		Boolean userDelStatusNew = profileDto.getDelStatus();
		String userRoleNew = profileDto.getRole();

		ProfileDto profileDtoFromDB = profileDtoFromDB(login);

		if (userLoginNew.equals("")) {
			userLoginNew = profileDtoFromDB.getLogin();
		}
		if (userPasswordNew.equals("")) {
			userPasswordNew = profileDtoFromDB.getPassword();
		}
		if (userFirstNameNew.equals("")) {
			userFirstNameNew = profileDtoFromDB.getFirstName();
		}
		if (userLastNameNew.equals("")) {
			userLastNameNew = profileDtoFromDB.getLastName();
		}
		if (userEmailNew.equals("")) {
			userEmailNew = profileDtoFromDB.getEmail();
		}
		if (userDelStatusNew == null || userDelStatusNew.equals("")) {
			userDelStatusNew = profileDtoFromDB.getDelStatus();
		}
		if (userRoleNew.equals("")) {
			userRoleNew = profileDtoFromDB.getRole();
		}

		profileDto.setLogin(userLoginNew);
		profileDto.setPassword(userPasswordNew);
		profileDto.setFirstName(userFirstNameNew);
		profileDto.setLastName(userLastNameNew);
		profileDto.setEmail(userEmailNew);
		profileDto.setDelStatus(userDelStatusNew);
		profileDto.setRole(userRoleNew);

		return profileDto;
	}

	private ProfileDto createProfileFromPageInfo(HttpServletRequest request) {
		String userLoginNew = HttpUtils.returnRequestParameterValue("userLoginNew", request);
		String userPasswordNew = HttpUtils.returnRequestParameterValue("userPasswordNew", request);
		String userFirstNameNew = HttpUtils.returnRequestParameterValue("userFirstNameNew", request);
		String userLastNameNew = HttpUtils.returnRequestParameterValue("userLastNameNew", request);
		String userEmailNew = HttpUtils.returnRequestParameterValue("userEmailNew", request);
		String userDelStatus = HttpUtils.returnRequestParameterValue("userDelStatusNew", request);
		String userRoleNew = HttpUtils.returnRequestParameterValue("userRoleNew", request);

		Boolean userDelStatusNew = null;
		if (userDelStatus.equals("True")) {
			userDelStatusNew = true;
		} else if (userDelStatus.equals("False")) {
			userDelStatusNew = false;
		}

		ProfileDto profileDto = new ProfileDto();

		profileDto.setLogin(userLoginNew);
		profileDto.setPassword(userPasswordNew);
		profileDto.setDelStatus(userDelStatusNew);
		profileDto.setEmail(userEmailNew);
		profileDto.setFirstName(userFirstNameNew);
		profileDto.setLastName(userLastNameNew);
		profileDto.setRole(userRoleNew);

		return profileDto;
	}

}
