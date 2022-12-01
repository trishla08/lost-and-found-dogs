package com.trishla.aurora.Aurora;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trishla.aurora.dtos.FoundDog;
import com.trishla.aurora.repository.FoundDogFileBasedRepository;
import com.trishla.aurora.repository.FoundDogRepository;

@SpringBootApplication
public class AuroraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuroraApplication.class, args);

		// FoundDog.Builder foundDogBuilder = new FoundDog.Builder();
		// FoundDog foundDog1 = foundDogBuilder.uid("1.0").message("msg1").build();
		// FoundDog foundDog2 = foundDogBuilder.uid("2.0").message("msg2").build();
		// FoundDog foundDog3 = foundDogBuilder.uid("3.0").message("msg3").build();

		// FoundDogRepository repo = new FoundDogFileBasedRepository();

		// repo.create(foundDog1);
		// repo.create(foundDog2);
		// repo.create(foundDog3);
		// System.out.println(repo.read("2.0").getMessage());

		// System.out.println("break");

		// // repo.delete(3.0);

		// // List<FoundDog> allLostDogs = repo.readAll();
		// // for (int i = 0; i < allLostDogs.size(); i++)
		// // System.out.println(allLostDogs.get(i).getMessage());

		// repo.update(new FoundDog.Builder().uid("3.0").message("msg4").build());

		// List<FoundDog> allLostDogs = repo.readAll();
		// for (int i = 0; i < allLostDogs.size(); i++)
		// 	System.out.println(allLostDogs.get(i).getMessage());

	}

}