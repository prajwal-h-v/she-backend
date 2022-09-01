package lti.she.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lti.she.dto.AccommodationRegisterDTO;
import lti.she.entity.Accommodation;
import lti.she.entity.AccommodationStatus;
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
	
	@RequestMapping(value = "/get-accommodation-by-ngo/{ngoId}/{flag}")
	public List<Accommodation> getAccommodationByNgo(@PathVariable int ngoId, @PathVariable boolean flag){
		List<Accommodation> vAccommodations = new ArrayList<Accommodation>();
		List<Accommodation> accommodations = accommodationService.listAccommodationsBtNgo(ngoId);
		for(Accommodation accommodation : accommodations) {
			if(accommodation.isVerified() == flag) {
				vAccommodations.add(accommodation);
			}
		}
		return vAccommodations;
	}
	
//	STEP ADDED
	@GetMapping("/list-resdents-for-accomodation/{accomodationId}")
	public List<AccommodationStatus> listResidentsForAccomodation(@PathVariable int accomodationId){
		return accommodationService.listResidentsByAccomodationId(accomodationId);
		
	}
	@GetMapping("/list-accomodation")
	public List<Accommodation> listAllAccomodations(){
		return accommodationService.listAllAccomodations();
	}
	@GetMapping("/{accomodationId}/register/{userId}")
	public AccommodationStatus register(@PathVariable int accomodationId,@PathVariable int userId) {
		return accommodationService.registerForAccomodation(accomodationId,userId);
	}
	
}
