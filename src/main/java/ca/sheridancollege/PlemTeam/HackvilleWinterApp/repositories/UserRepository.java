package ca.sheridancollege.PlemTeam.HackvilleWinterApp.repositories;

import ca.sheridancollege.PlemTeam.HackvilleWinterApp.beans.user;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<user, String> {
}
