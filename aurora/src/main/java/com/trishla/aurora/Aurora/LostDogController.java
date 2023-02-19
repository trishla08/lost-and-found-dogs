package com.trishla.aurora.Aurora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trishla.aurora.APIs;
import com.trishla.aurora.dtos.LostDog;
import com.trishla.aurora.dtos.LostDog.LostDogBuilder;
import com.trishla.aurora.dtos.LostDog.Status;
import com.trishla.aurora.dtos.requests.GetDogsRequest;
import com.trishla.aurora.dtos.requests.SearchDogsRequest;
import com.trishla.aurora.dtos.responses.GetDogsResponse;
import com.trishla.aurora.dtos.responses.SearchDogsResponse;
import com.trishla.aurora.repository.FoundDogRepository;
import com.trishla.aurora.repository.LostDogRepository;

@RestController
public class LostDogController {

    @Autowired
    private LostDogRepository lostDogH2BasedRepository;

    @Autowired
    private FoundDogRepository foundDogH2BasedRepository;

    @PostMapping(value = "/v1/dog/lost")
    public LostDog addLostDog(@RequestBody LostDogBuilder lostDogBuilder) {
        APIs apis = new APIs(lostDogH2BasedRepository, foundDogH2BasedRepository);
      return apis.reportMissing(lostDogBuilder.build());
    }

    @GetMapping("/v1/dog/lost")
    public List<LostDog> getAllLostDogs() {
        APIs apis = new APIs(lostDogH2BasedRepository, foundDogH2BasedRepository);
        GetDogsRequest request = GetDogsRequest.builder().build();
        GetDogsResponse<LostDog> response = apis.getAllLostDogs(request);
        return response.getDogs();
    }

    @GetMapping("/v1/dog/lost/{id}")
    public LostDog getLostDogDetails(@PathVariable String id) {
        APIs apis = new APIs(lostDogH2BasedRepository, foundDogH2BasedRepository);
        LostDog lostDog = apis.getLostDogDetails(id);
        return lostDog;
    }

    @PutMapping("/v1/dog/lost/{id}")
    public void updateLost(@PathVariable String id, @RequestBody LostDogBuilder lostDogBuilder) {
        APIs apis = new APIs(lostDogH2BasedRepository, foundDogH2BasedRepository);
        apis.updateLostDog(lostDogBuilder.build());
    }

    @DeleteMapping("/v1/dog/lost/{id}")
    public LostDog deleteLost(@PathVariable String id) {
        APIs apis = new APIs(lostDogH2BasedRepository, foundDogH2BasedRepository);
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
        APIs apis = new APIs(lostDogH2BasedRepository, foundDogH2BasedRepository);
        SearchDogsRequest searchDogsRequest = new SearchDogsRequest();
        searchDogsRequest.createLostDogRequest(name, sex, breed, city, latitude, longitude,
                maxDistance, status, message, colour, collar, coat, limping, furry);
        SearchDogsResponse<LostDog> searchDogsResponse = apis.searchLostDogs(searchDogsRequest);
        return searchDogsResponse.getList();
    }
}
