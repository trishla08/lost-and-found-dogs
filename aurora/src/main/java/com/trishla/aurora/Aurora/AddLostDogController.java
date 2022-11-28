package com.trishla.aurora.Aurora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.LostDog;

@Controller
public class AddLostDogController {

	@PostMapping("/v1/dog/lost")
	public String greeting(@RequestBody LostDog lostDog, Model model) {
		APIs apis = new APIs();
        LostDog createdObj = apis.reportMissing(lostDog);
        model.addAttribute("createdLostDog", createdObj);
		return "greetings";
	}

}