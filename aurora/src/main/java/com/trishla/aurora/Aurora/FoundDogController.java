package com.trishla.aurora.Aurora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.FoundDog;
import com.trishla.aurora.dtos.requests.GetDogsRequest;
import com.trishla.aurora.dtos.responses.GetDogsResponse;

@Controller
public class FoundDogController {

	@PostMapping("/v1/dog/found")
	public String addFoundDog(@RequestBody FoundDog foundDog, Model model) {
		APIs apis = new APIs();
        FoundDog createdObj = apis.reportFound(foundDog);
        model.addAttribute("createdFoundDog", createdObj);
		return "greetings";
	}

    @GetMapping("/v1/dog/found")
	public String getAllFoundDogs(Model model) {
		APIs apis = new APIs();
        GetDogsRequest request = new GetDogsRequest();
        GetDogsResponse<FoundDog> response = apis.getAllFoundDogs(request);
        model.addAttribute("foundDogsList", response.getDogs());
		return "greetings";
	}

    @GetMapping("/v1/dog/found/{id}")
	public String getFoundDogDetails(@PathVariable String id, Model model) {
		APIs apis = new APIs();
        FoundDog foundDog = apis.getFoundDogDetails(id);
        model.addAttribute("foundDetails", foundDog);
		return "greetings";
	}

    @PutMapping("/v1/dog/found/{id}")
	public String updateFound(@PathVariable String id, @RequestBody FoundDog foundDog, Model model) {
		APIs apis = new APIs();
		apis.updateFoundDog(foundDog);
		return "greetings";
	}

    @DeleteMapping("/v1/dog/found/{id}")
	public String deleteLost(@PathVariable String id, Model model) {
		APIs apis = new APIs();
        FoundDog deletedDog = apis.deleteFoundDog(id);
        model.addAttribute("deletedFoundDog", deletedDog);
		return "greetings";
	}
}