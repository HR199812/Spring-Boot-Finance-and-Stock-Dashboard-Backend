package cnc.labs.main_backend.controller;


import cnc.labs.main_backend.dto.UserDto;
import cnc.labs.main_backend.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestHeader("userEmail") String mail, @RequestHeader("userPassword") String password) {
        var createdUser = userService.loginUser(mail, password);

        return ResponseEntity.ok().body(createdUser);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@Valid @RequestBody UserDto userDto) {
        var createUser = userService.createUser(userDto);
        System.out.println(createUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }
}
