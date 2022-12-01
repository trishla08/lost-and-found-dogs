package com.trishla.aurora.Aurora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trishla.aurora.dtos.requests.GetDogsRequest;
import com.trishla.aurora.dtos.responses.GetDogsResponse;
import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.LostDog;

@Controller
public class LostDogController {

	@PostMapping("/v1/dog/lost")
	public String addLostDog(@RequestBody LostDog lostDog, Model model) {
		APIs apis = new APIs();
        LostDog createdObj = apis.reportMissing(lostDog);
        model.addAttribute("createdLostDog", createdObj);
		return "greetings";
	}

    @GetMapping("/v1/dog/lost")
	public String getAllLostDogs(Model model) {
		APIs apis = new APIs();
        GetDogsRequest request = new GetDogsRequest();
        GetDogsResponse<LostDog> response = apis.getAllLostDogs(request);
        model.addAttribute("lostDogsList", response.getDogs());
		return "greetings";
	}

    @GetMapping("/v1/dog/lost/{id}")
	public String getLostDogDetails(@PathVariable String id, Model model) {
		APIs apis = new APIs();
        LostDog lostDog = apis.getLostDogDetails(id);
        model.addAttribute("lostDetails", lostDog);
		return "greetings";
	}

    @PutMapping("/v1/dog/lost/{id}")
	public String updateLost(@PathVariable String id, @RequestBody LostDog lostDog, Model model) {
		APIs apis = new APIs();
        apis.updateLostDog(lostDog);
		return "greetings";
	}

    @DeleteMapping("/v1/dog/lost/{id}")
	public String deleteLost(@PathVariable String id, Model model) {
		APIs apis = new APIs();
        LostDog deletedDog = apis.deleteLostDog(id);
        model.addAttribute("deletedLostDog", deletedDog);
		return "greetings";
	}
}