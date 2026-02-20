package cnc.labs.main_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record UserDto(

        @NotBlank(message = "User name is required")
        @Size(min = 4, message = "Minimum length should be 4 characters")
        String username,

        @NotBlank(message = "User name is required")
        @Email(message = "Please provide a valid email address")
        String userEmail,

        @NotBlank(message = "Password is required")
        String password
) {
}
