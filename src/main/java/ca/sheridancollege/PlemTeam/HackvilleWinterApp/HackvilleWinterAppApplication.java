package ca.sheridancollege.PlemTeam.HackvilleWinterApp;

import ca.sheridancollege.PlemTeam.HackvilleWinterApp.beans.user;
import ca.sheridancollege.PlemTeam.HackvilleWinterApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class HackvilleWinterAppApplication  implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public HackvilleWinterAppApplication(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(HackvilleWinterAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		if(userRepository.findAll().isEmpty()){
			userRepository.save(new user("Luis", "Santos", 18, "Panama", "luis@gmail.com", "lusa0821"));
		}

		for(user u : userRepository.findAll()){
			System.out.println(u);
		}
	}
}
