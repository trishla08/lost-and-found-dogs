package com.trishla.aurora.Aurora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.LostDog;

@Controller
public class GetLostDogDetailsController {

	@GetMapping("/v1/dog/lost/{id}")
	public String greeting(@PathVariable String id, Model model) {
		APIs apis = new APIs();
        LostDog lostDog = apis.getLostDogDetails(id);
        model.addAttribute("lostDetails", lostDog);
		return "greetings";
	}

}