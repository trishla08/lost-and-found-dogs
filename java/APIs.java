
class APIs {


    LostDog reportMissing(String name, Integer age, String sex, String breed, Pair<Double,Double> location, String city, String photo, String message, 
    String ownerName, String ownerEmail, String ownerNumber) {
        LostDog lostDog = new LostDog(lostIndex, name, age, sex,breed,location,city,photo,message,ownerName,ownerEmail,ownerNumber, Status.lost);
        lostIndex++;
        create(lostDog, 'lostDogs');

    }

    FoundDog reportFound( String sex, String breed, Pair<Double,Double> location, String city, String photo, String message, 
    String finderName, String finderEmail, String finderNumber) {
        FoundDog foundDog = new LostDog(foundIndex,sex,breed,location,city,photo,message,finderName,finderEmail,finderNumber);
        foundIndex++;
        create(foundDog, 'foundDogs');

    }
}