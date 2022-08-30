package lti.she.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lti.she.dto.AccommodationRegisterDTO;
import lti.she.entity.Accommodation;
import lti.she.service.AccommodationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/accommodation")
public class AccommodationController {

	@Autowired
	AccommodationService accommodationService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Accommodation addAccommodation(@RequestBody AccommodationRegisterDTO accommodationRegisterDTO) {
		
		return accommodationService.createAccommodation(accommodationRegisterDTO);
	}
	
	@RequestMapping(value = "/get-accommodation-by-ngo/{ngoId}")
	public List<Accommodation> getAccommodationByNgo(@PathVariable int ngoId){
		return accommodationService.listAccommodationsBtNgo(ngoId);
	}
	
}
