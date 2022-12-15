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

import com.trishla.aurora.dtos.requests.GetDogsRequest;
import com.trishla.aurora.dtos.requests.SearchDogsRequest;
import com.trishla.aurora.dtos.responses.GetDogsResponse;
import com.trishla.aurora.dtos.responses.SearchDogsResponse;
import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.LostDog;
import com.trishla.aurora.dtos.LostDog.Status;

@RestController
public class LostDogController {

    @PostMapping(value = "/v1/dog/lost")
    public LostDog addLostDog(@RequestBody LostDog.Builder lostDogBuilder) {
        APIs apis = new APIs();
        return apis.reportMissing(lostDogBuilder.build());
    }

    @GetMapping("/v1/dog/lost")
    public List<LostDog> getAllLostDogs() {
        APIs apis = new APIs();
        GetDogsRequest request = new GetDogsRequest();
        GetDogsResponse<LostDog> response = apis.getAllLostDogs(request);
        return response.getDogs();
    }

    @GetMapping("/v1/dog/lost/{id}")
    public LostDog getLostDogDetails(@PathVariable String id) {
        APIs apis = new APIs();
        LostDog lostDog = apis.getLostDogDetails(id);
        return lostDog;
    }

    @PutMapping("/v1/dog/lost/{id}")
    public void updateLost(@PathVariable String id, @RequestBody LostDog.Builder lostDogBuilder) {
        APIs apis = new APIs();
        apis.updateLostDog(lostDogBuilder.build());
    }

    @DeleteMapping("/v1/dog/lost/{id}")
    public LostDog deleteLost(@PathVariable String id) {
        APIs apis = new APIs();
        LostDog deletedDog = apis.deleteLostDog(id);
        return deletedDog;
    }

    @GetMapping("/v1/dog/lost/search")
    public List<LostDog> searchLost(@RequestParam("name") String name, @RequestParam("sex") String sex,
            @RequestParam("breed") String breed, @RequestParam("city") String city,
            @RequestParam("lat") Double latitude, @RequestParam("long") Double longitude,
            @RequestParam("maxDist") Double maxDistance, @RequestParam("status") Status status,
            @RequestParam("msg") String message,
            @RequestParam("colour") String colour, @RequestParam("collar") Boolean collar,
            @RequestParam("coat") Boolean coat,
            @RequestParam("limp") Boolean limping, @RequestParam("furry") Boolean furry) {
        APIs apis = new APIs();
        SearchDogsRequest searchDogsRequest = new SearchDogsRequest();
        searchDogsRequest.create(name, sex, breed, city, latitude, longitude,
                maxDistance, status, message, colour, collar, coat, limping, furry);
        SearchDogsResponse<LostDog> searchDogsResponse = apis.searchLostDogs(searchDogsRequest);
        return searchDogsResponse.getList();
    }
}
