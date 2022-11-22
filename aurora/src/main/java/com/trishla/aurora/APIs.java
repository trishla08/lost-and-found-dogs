package com.trishla.aurora;

import java.util.List;

import com.trishla.aurora.dtos.FoundDog;
import com.trishla.aurora.dtos.LostDog;
import com.trishla.aurora.dtos.requests.GetDogsRequest;
import com.trishla.aurora.dtos.responses.GetDogsResponse;
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

    LostDog reportMissing(LostDog lostDog) {
        lostDogRepository.create(lostDog);
        return lostDog;
    }

    FoundDog reportFound(FoundDog foundDog) {
        foundDogRepository.create(foundDog);
        return foundDog;
    }

    GetDogsResponse<LostDog> getAllLostDogs(GetDogsRequest req) {
        List<LostDog> lostDogs = lostDogRepository.readAll();
        List<LostDog> sortedLostDogs = SortDogsList.sortLostDogsList(lostDogs, req.getSort());

        return new GetDogsResponse.Builder<LostDog>()
                .total(lostDogs.size())
                .dogs(sortedLostDogs)
                .build();
    }

    GetDogsResponse<FoundDog> getAllFoundDogs(GetDogsRequest req) {
        List<FoundDog> foundDogs = foundDogRepository.readAll();
        List<FoundDog> sortedFoundDogs = SortDogsList.sortFoundDogsList(foundDogs, req.getSort());

        return new GetDogsResponse.Builder<FoundDog>()
                .total(foundDogs.size())
                .dogs(sortedFoundDogs)
                .build();
    }

    LostDog getLostDogDetails(String UID) {
        return lostDogRepository.read(UID);
    }

    FoundDog getFoundDogDetails(String UID) {
        return foundDogRepository.read(UID);
    }
}