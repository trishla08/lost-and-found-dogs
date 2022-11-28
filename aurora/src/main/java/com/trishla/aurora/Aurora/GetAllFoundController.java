package com.trishla.aurora.Aurora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.FoundDog;
import com.trishla.aurora.dtos.requests.GetDogsRequest;
import com.trishla.aurora.dtos.responses.GetDogsResponse;

@Controller
public class GetAllFoundController {

	@GetMapping("/v1/dog/found")
	public String greeting(Model model) {
		APIs apis = new APIs();
        GetDogsRequest request = new GetDogsRequest();
        GetDogsResponse<FoundDog> response = apis.getAllFoundDogs(request);
        model.addAttribute("foundDogsList", response.getDogs());
		return "greetings";
	}

}