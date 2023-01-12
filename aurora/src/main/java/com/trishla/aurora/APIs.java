package com.trishla.aurora;

import java.util.List;

import com.trishla.aurora.dtos.FoundDog;
import com.trishla.aurora.dtos.LostDog;
import com.trishla.aurora.dtos.requests.GetDogsRequest;
import com.trishla.aurora.dtos.requests.SearchDogsRequest;
import com.trishla.aurora.dtos.responses.GetDogsResponse;
import com.trishla.aurora.dtos.responses.SearchDogsResponse;
import com.trishla.aurora.repository.FoundDogFileBasedRepository;
import com.trishla.aurora.repository.FoundDogRepository;
import com.trishla.aurora.repository.LostDogFileBasedRepository;
import com.trishla.aurora.repository.LostDogRepository;
import com.trishla.aurora.utils.SortDogsList;

public class APIs {

    public Double lostIndex = (double) 0;
    public Double foundIndex = (double) 0;

    LostDogRepository lostDogRepository = new LostDogFileBasedRepository();
    FoundDogRepository foundDogRepository = new FoundDogFileBasedRepository();

    public APIs() {
    }

    public LostDog reportMissing(LostDog lostDog) {
        lostDogRepository.create(lostDog);
        return lostDog;
    }

    public FoundDog reportFound(FoundDog foundDog) {
        foundDogRepository.create(foundDog);
        return foundDog;
    }

    public GetDogsResponse<LostDog> getAllLostDogs(GetDogsRequest req) {
        List<LostDog> lostDogs = lostDogRepository.readAll();
        List<LostDog> sortedLostDogs = SortDogsList.sortLostDogsList(lostDogs, req.getSort());

        return GetDogsResponse.<LostDog>builder()
                .total(lostDogs.size())
                .dogs(sortedLostDogs)
                .build();
    }

    public GetDogsResponse<FoundDog> getAllFoundDogs(GetDogsRequest req) {
        List<FoundDog> foundDogs = foundDogRepository.readAll();
        List<FoundDog> sortedFoundDogs = SortDogsList.sortFoundDogsList(foundDogs, req.getSort());

        return GetDogsResponse.<FoundDog>builder()
                .total(foundDogs.size())
                .dogs(sortedFoundDogs)
                .build();
    }

    public LostDog getLostDogDetails(String UID) {
        return lostDogRepository.read(UID);
    }

    public FoundDog getFoundDogDetails(String UID) {
        return foundDogRepository.read(UID);
    }

    public void updateLostDog(LostDog lostDog) {
        lostDogRepository.update(lostDog);
    }

    public void updateFoundDog(FoundDog foundDog) {
        foundDogRepository.update(foundDog);
    }

    public LostDog deleteLostDog(String UID) {
        return lostDogRepository.delete(UID);
    }

    public FoundDog deleteFoundDog(String UID) {
        return foundDogRepository.delete(UID);
    }

    public SearchDogsResponse<LostDog> searchLostDogs(SearchDogsRequest request) {
        List<LostDog> lostDogsList = lostDogRepository.search(request);
        return new SearchDogsResponse.Builder<LostDog>()
                .total(lostDogsList.size())
                .dogs(lostDogsList)
                .build();
    }

    public SearchDogsResponse<FoundDog> searchFoundDogs(SearchDogsRequest request) {
        List<FoundDog> lostDogsList = foundDogRepository.search(request);
        return new SearchDogsResponse.Builder<FoundDog>()
                .total(lostDogsList.size())
                .dogs(lostDogsList)
                .build();
    }
}
