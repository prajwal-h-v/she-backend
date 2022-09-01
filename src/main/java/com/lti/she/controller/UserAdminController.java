package com.lti.she.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.she.model.UserAdmin;
import com.lti.she.service.UserAdminService;
import com.lti.she.service.UserAdminServiceImpl;

@RestController
public class UserAdminController {
	@Autowired
    UserAdminServiceImpl userAdminService;
	
	@RequestMapping(value="/getAllUser")
    public List<UserAdmin> getAllUser(){
    	return userAdminService.getUserList();
    }

}
