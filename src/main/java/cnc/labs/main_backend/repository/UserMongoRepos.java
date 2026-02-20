package cnc.labs.main_backend.repository;

import cnc.labs.main_backend.entity.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepos extends MongoRepository<UserMongo, String> {
    Optional<UserMongo> findByEmail(String email);
}
