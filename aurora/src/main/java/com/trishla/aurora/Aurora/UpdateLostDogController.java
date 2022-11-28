package com.trishla.aurora.Aurora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.LostDog;

@Controller
public class UpdateLostDogController {

	@PutMapping("/v1/dog/lost/{id}")
	public String greeting(@RequestBody LostDog lostDog, Model model) {
		APIs apis = new APIs();
        apis.updateLostDog(lostDog);
		return "greetings";
	}

}