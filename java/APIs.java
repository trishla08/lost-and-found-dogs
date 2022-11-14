import java.util.List;
import java.util.Map;

public class APIs {

    public Double lostIndex = (double) 0;
    public Double foundIndex = (double) 0;

    LostDogRepository lostDogRepository = new LostDogFileBasedRepository();
    FoundDogRepository foundDogRepository = new FoundDogFileBasedRepository();

    public APIs() {
    }

    LostDog reportMissing(String name, Integer age, String sex, String breed, Location location, String city,
            String photo, String message,
            String ownerName, String ownerEmail, String ownerNumber, Map<String, String> physicalAttributes) {
        LostDog lostDog = new LostDog(lostIndex, name, age, sex, breed, location, city, photo, message, ownerName,
                ownerEmail, ownerNumber, physicalAttributes, LostDog.Status.Lost);
        lostIndex++;
        lostDogRepository.create(lostDog);
        return lostDog;
    }

    FoundDog reportFound(String sex, String breed, Location location, String city, String photo, String message,
            String finderName, String finderEmail, String finderNumber, Map<String, String> physicalAttributes) {
        FoundDog foundDog = new FoundDog(foundIndex, sex, breed, location, city, photo, message, finderName,
                finderEmail, finderNumber, physicalAttributes);
        foundIndex++;
        foundDogRepository.create(foundDog);
        return foundDog;
    }

    List<LostDog> getAllLostDogs() {
        return lostDogRepository.readAll();
    }

    List<FoundDog> getAllFoundDogs() {
        return foundDogRepository.readAll();
    }

    LostDog getLostDogDetails(double UID) {
        return lostDogRepository.read(UID);
    }

    FoundDog getFoundDogDetails(double UID) {
        return foundDogRepository.read(UID);
    }
}