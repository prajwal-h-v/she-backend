package lti.she.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lti.she.dto.NgoLogin;
import lti.she.dto.NgoRegisterDto;
import lti.she.entity.Ngo;
import lti.she.service.NgoServiceImp;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ngo")
public class NgoController {

    @Autowired
    NgoServiceImp ngoService;

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public Ngo signup(@RequestBody NgoRegisterDto ngoRegisterDto){
        return ngoService.register(ngoRegisterDto.toNgo());
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Ngo login(@RequestBody NgoLogin ngoLogin) {
    	try {
    		System.out.println(ngoLogin);
    		return ngoService.login(ngoLogin);
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
    		return null;
		}
    }
    
    @RequestMapping(value="/getAll")
    public List<Ngo> getAll(){
    	return ngoService.getNgoList();
    }
}
