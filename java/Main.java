import java.util.List;

class Main {
    public static void main(String[] args) {
        // LostDog lostDog1 = new LostDog(1.0, "A", 1, null, null, null, null, null, null, null, null, null, null,
        //         null);
        // LostDog lostDog2 = new LostDog(2.0, "B", 1, null, null, null, null, null, null, null, null, null, null,
        //         null);
        // LostDog lostDog3 = new LostDog(3.0, "C", 1, null, null, null, null, null, null, null, null, null, null,
        //         null);
        // LostDog lostDog4 = new LostDog(4.0, "D", 1, null, null, null, null, null, null, null, null, null, null,
        //         null);

        // LostDogRepository repo = new LostDogFileBasedRepository();

        // repo.create(lostDog1);
        // repo.create(lostDog2);
        // repo.create(lostDog3);
        // repo.create(lostDog4);
        // System.out.println(repo.read(2.0).getName());

        // System.out.println("break");

        // repo.delete(3.0);

        // List<LostDog> allLostDogs = repo.readAll();
        // for (int i = 0; i < allLostDogs.size(); i++)
        //     System.out.println(allLostDogs.get(i).getName());

        // System.out.println("break");
        // repo.update(4.0, new LostDog(4.0, "E", 1, null, null, null, null, null, null, null, null, null, null,
        //         null));

        // allLostDogs = repo.readAll();
        // for (int i = 0; i < allLostDogs.size(); i++)
        //     System.out.println(allLostDogs.get(i).getName());

        FoundDog foundDog1 = new FoundDog(1.0, null, null, null, null, null, "a", null, null, null, null);
        FoundDog foundDog2 = new FoundDog(2.0, null, null, null, null, null, "b", null, null, null, null);
        FoundDog foundDog3 = new FoundDog(3.0, null, null, null, null, null, "c", null, null, null, null);


        FoundDogRepository repo = new FoundDogFileBasedRepository();

        repo.create(foundDog1);
        repo.create(foundDog2);
        repo.create(foundDog3);
        System.out.println(repo.read(2.0).getMessage());

        System.out.println("break");

        repo.delete(3.0);

        List<FoundDog> allLostDogs = repo.readAll();
        for (int i = 0; i < allLostDogs.size(); i++)
            System.out.println(allLostDogs.get(i).getMessage());

        System.out.println("break");
        repo.update(3.0, new FoundDog(3.0, null, null, null, null, null, "d", null, null, null, null));

        allLostDogs = repo.readAll();
        for (int i = 0; i < allLostDogs.size(); i++)
            System.out.println(allLostDogs.get(i).getMessage());
    }
}