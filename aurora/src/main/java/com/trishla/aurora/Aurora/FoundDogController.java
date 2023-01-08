package com.trishla.aurora.Aurora;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.FoundDog;
import com.trishla.aurora.dtos.FoundDog.FoundDogBuilder;
import com.trishla.aurora.dtos.requests.GetDogsRequest;
import com.trishla.aurora.dtos.requests.SearchDogsRequest;
import com.trishla.aurora.dtos.responses.GetDogsResponse;
import com.trishla.aurora.dtos.responses.SearchDogsResponse;

@RestController
public class FoundDogController {

    @PostMapping(value="/v1/dog/found")
    public FoundDog addFoundDog(@RequestBody FoundDogBuilder foundDogBuilder) {
        APIs apis = new APIs();
        return apis.reportFound(foundDogBuilder.build());
    }

    @GetMapping("/v1/dog/found")
    public List<FoundDog> getAllFoundDogs() {
        APIs apis = new APIs();
        GetDogsRequest request = GetDogsRequest.builder().build();
        GetDogsResponse<FoundDog> response = apis.getAllFoundDogs(request);
        return response.getDogs();
    }

    @GetMapping("/v1/dog/found/{id}")
    public FoundDog getFoundDogDetails(@PathVariable String id) {
        APIs apis = new APIs();
        return apis.getFoundDogDetails(id);
    }

    @PutMapping("/v1/dog/found/{id}")
    public void updateFound(@PathVariable String id, @RequestBody FoundDogBuilder foundDogBuilder) {
        APIs apis = new APIs();
        apis.updateFoundDog(foundDogBuilder.build());
    }

    @DeleteMapping("/v1/dog/found/{id}")
    public FoundDog deleteFound(@PathVariable String id) {
        APIs apis = new APIs();
        return apis.deleteFoundDog(id);
    }

    @GetMapping("/v1/dog/found/search")
    public List<FoundDog> searchLost(@RequestParam("name") String name, @RequestParam("sex") String sex,
            @RequestParam("breed") String breed, @RequestParam("city") String city,
            @RequestParam("lat") Double latitude, @RequestParam("long") Double longitude,
            @RequestParam("maxDist") Double maxDistance,
            @RequestParam("msg") String message,
            @RequestParam("colour") String colour, @RequestParam("collar") Boolean collar,
            @RequestParam("coat") Boolean coat,
            @RequestParam("limp") Boolean limping, @RequestParam("furry") Boolean furry) {
        APIs apis = new APIs();
        SearchDogsRequest searchDogsRequest = new SearchDogsRequest();
        searchDogsRequest.createFoundDogRequest(name, sex, breed, city, latitude, longitude,
                maxDistance, message, colour, collar, coat, limping, furry);
        SearchDogsResponse<FoundDog> searchDogsResponse = apis.searchFoundDogs(searchDogsRequest);
        return searchDogsResponse.getList();
    }
}