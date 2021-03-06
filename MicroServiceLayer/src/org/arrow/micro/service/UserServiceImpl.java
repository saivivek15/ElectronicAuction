package org.arrow.micro.service;

import org.arrow.micro.dao.UserDaoImpl;
import org.arrow.micro.model.UserDetailsModel;
import org.arrow.micro.simple.model.LoginResponseModel;
import org.arrow.micro.simple.model.SimpleToDBModelConverter;
import org.arrow.micro.simple.model.SimpleUserModel;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl {
	@Autowired
	private UserDaoImpl userDao;

	public SimpleUserModel getUserDetails(int userid) {
		
		UserDetailsModel udm = userDao.getUserDetails(userid);
		SimpleUserModel sum =  SimpleToDBModelConverter.ConvertToSimpleUserModel(udm);
		return sum;
		
	}

	public LoginResponseModel updateUserDetails(SimpleUserModel userModel,LoginResponseModel lr) {
		
		UserDetailsModel udm = SimpleToDBModelConverter.ConvertToUserDetailsModel(userModel);
		udm.setUserId(userModel.getUserId());
		return userDao.update(udm,lr);
		
	}
}
