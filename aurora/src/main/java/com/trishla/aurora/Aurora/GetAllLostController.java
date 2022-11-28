package com.trishla.aurora.Aurora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.LostDog;
import com.trishla.aurora.dtos.requests.GetDogsRequest;
import com.trishla.aurora.dtos.responses.GetDogsResponse;

@Controller
public class GetAllLostController {

	@GetMapping("/v1/dog/lost")
	public String greeting(Model model) {
		APIs apis = new APIs();
        GetDogsRequest request = new GetDogsRequest();
        GetDogsResponse<LostDog> response = apis.getAllLostDogs(request);
        model.addAttribute("lostDogsList", response.getDogs());
		return "greetings";
	}

}