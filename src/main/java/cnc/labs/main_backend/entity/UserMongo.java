package cnc.labs.main_backend.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection="user")
@NoArgsConstructor
@AllArgsConstructor
public class UserMongo {

    @Id
    private String id;

    @NotBlank(message = "User name is required")
    @Size(min = 4, message = "Minimum length should be 4 characters")
    private String username;

    @NotBlank(message="User email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    private String password;
}
