package com.trishla.aurora.Aurora;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.FoundDog;
import com.trishla.aurora.dtos.requests.GetDogsRequest;
import com.trishla.aurora.dtos.responses.GetDogsResponse;

@RestController
public class FoundDogController {

	@PostMapping(value="/v1/dog/found")
	public FoundDog addFoundDog(@RequestBody FoundDog.Builder foundDogBuilder) {
		APIs apis = new APIs();
        return apis.reportFound(foundDogBuilder.build());
	}

    @GetMapping("/v1/dog/found")
	public List<FoundDog> getAllFoundDogs() {
		APIs apis = new APIs();
        GetDogsRequest request = new GetDogsRequest();
        GetDogsResponse<FoundDog> response = apis.getAllFoundDogs(request);
		return response.getDogs();
	}

    @GetMapping("/v1/dog/found/{id}")
	public FoundDog getFoundDogDetails(@PathVariable String id) {
		APIs apis = new APIs();
        return apis.getFoundDogDetails(id);
	}

    @PutMapping("/v1/dog/found/{id}")
	public void updateFound(@PathVariable String id, @RequestBody FoundDog.Builder foundDogBuilder) {
		APIs apis = new APIs();
	    apis.updateFoundDog(foundDogBuilder.build());
	}

    @DeleteMapping("/v1/dog/found/{id}")
	public FoundDog deleteFound(@PathVariable String id) {
		APIs apis = new APIs();
        return apis.deleteFoundDog(id);
	}
}