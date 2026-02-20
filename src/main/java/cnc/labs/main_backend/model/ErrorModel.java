package cnc.labs.main_backend.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ErrorModel {
    private LocalDate date;
    private String message;
    private String details;
}
