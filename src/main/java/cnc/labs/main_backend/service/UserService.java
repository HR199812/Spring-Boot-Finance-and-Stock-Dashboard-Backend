package cnc.labs.main_backend.service;


import cnc.labs.main_backend.dto.UserDto;
import cnc.labs.main_backend.entity.UserMongo;
import cnc.labs.main_backend.exception.UserNotFoundException;
import cnc.labs.main_backend.repository.UserMongoRepos;
import cnc.labs.main_backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMongoRepos userMongoRepos;

    @Autowired
    private JwtUtil jwtUtil;


    public String loginUser(String usermail, String password) {

        var user = userMongoRepos.findByEmail(usermail).orElseThrow(() -> new UserNotFoundException("User not found with email: " + usermail));

        if(user.getPassword().equals(password)) {
           return jwtUtil.generateToken(user);
       }
        return "Undefined user";
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
