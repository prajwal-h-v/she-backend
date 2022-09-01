package com.lti.she.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.lti.she.model.NgoAdmin;
import com.lti.she.service.NgoadminServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class NgoAdminController {
	
	@Autowired
    NgoadminServiceImpl ngoAdminService;
	
	@RequestMapping(value="/getAll")
    public List<NgoAdmin> getAll(){
    	return ngoAdminService.getNgoList();
    }

}
