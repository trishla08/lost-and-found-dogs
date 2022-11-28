package com.trishla.aurora.Aurora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.FoundDog;

@Controller
public class AddFoundDogController {

	@PostMapping("/v1/dog/found")
	public String greeting(@RequestBody FoundDog foundDog, Model model) {
		APIs apis = new APIs();
        FoundDog createdObj = apis.reportFound(foundDog);
        model.addAttribute("createdFoundDog", createdObj);
		return "greetings";
	}

}