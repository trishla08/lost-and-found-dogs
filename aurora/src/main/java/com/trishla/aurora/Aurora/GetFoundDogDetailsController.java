package com.trishla.aurora.Aurora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.FoundDog;

@Controller
public class GetFoundDogDetailsController {

	@GetMapping("/v1/dog/found/{id}")
	public String greeting(@PathVariable String id, Model model) {
		APIs apis = new APIs();
        FoundDog foundDog = apis.getFoundDogDetails(id);
        model.addAttribute("foundDetails", foundDog);
		return "greetings";
	}

}