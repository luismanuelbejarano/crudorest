package com.willybe.spring.crudrest.rest;

import java.util.List;

import com.willybe.spring.crudrest.entity.Mailing;
import com.willybe.spring.crudrest.service.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MailingRestController {

	private MailingService mailingService;
	
	@Autowired
	public MailingRestController(MailingService theMailingService) {
		mailingService = theMailingService;
	}
	
	// mapping for GET endpoint "/subscribers" return list of subscribers
	@GetMapping("/subscribers")
	public List<Mailing> findAll() {
		return mailingService.findAll();
	}

	// mapping for GET endpoint /subscribers/{subscriberId} return a subscriber
	@GetMapping("/subscribers/{subscriberId}")
	public Mailing getSubscriber(@PathVariable int subscriberId) {
		
		Mailing theMailing = mailingService.findById(subscriberId);
		
		if (theMailing == null) {
			throw new RuntimeException("Mailing id not found - " + subscriberId);
		}
		
		return theMailing;
	}
	
	// mapping for POST endpoint /subscribers - add new subscriber
	@PostMapping("/subscribers")
	public Mailing addSubscriber(@RequestBody Mailing theMailing) {
		// if they pass an id in JSON then set id to 0
		// in order to force a save of new item (no update)
		theMailing.setId(0);
		mailingService.save(theMailing);

		return theMailing;
	}
	
	// add mapping for endpoint PUT /subscribers - update a subscriber
	@PutMapping("/subscribers")
	public Mailing updateSubscriber(@RequestBody Mailing theMailing) {
		
		mailingService.save(theMailing);
		
		return theMailing;
	}
	
	// mapping for endpoint DELETE /subscribers/{subscriberId} - delete subscriber
	@DeleteMapping("/subscribers/{subscriberId}")
	public String deleteSubscriber(@PathVariable int subscriberId) {
		
		Mailing tempMailing = mailingService.findById(subscriberId);

		if (tempMailing == null) {
			throw new RuntimeException("Subscriber id not found - " + subscriberId);
		}
		
		mailingService.deleteById(subscriberId);
		return "Deleted subscriber id - " + subscriberId;
	}
	
}










