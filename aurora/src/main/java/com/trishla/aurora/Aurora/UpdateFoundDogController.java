package com.trishla.aurora.Aurora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.FoundDog;

@Controller
public class UpdateFoundDogController {

	@PutMapping("/v1/dog/found/{id}")
	public String greeting(@RequestBody FoundDog foundDog, Model model) {
		APIs apis = new APIs();
		apis.updateFoundDog(foundDog);
		return "greetings";
	}

}