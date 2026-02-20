package cnc.labs.main_backend.service;


import cnc.labs.main_backend.dto.UserDto;
import cnc.labs.main_backend.entity.UserMongo;
import cnc.labs.main_backend.repository.UserMongoRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMongoRepos userMongoRepos;


    public String loginUser(String usermail, String password) {

        var user = userMongoRepos.findByEmail(usermail).orElseThrow(() -> new RuntimeException("Invalid email"));
        System.out.println("user is: " + user
        );
        System.out.println("UserName is: " + usermail);
        System.out.println("userPassword is: " + password);
        return "test";
    }

    public UserDto createUser(UserDto user) {

        if (userMongoRepos.findByEmail(user.userEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        var usertosave = UserMongo.builder()
                .email(user.userEmail())
                .username(user.username())
                .password(user.password()).build();
        var savedUser = userMongoRepos.save(usertosave);
        return UserDto.builder().userEmail(savedUser.getEmail()).username(savedUser.getUsername()).build();
    }
}
