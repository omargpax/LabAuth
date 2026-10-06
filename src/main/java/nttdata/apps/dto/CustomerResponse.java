package nttdata.apps.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record CustomerResponse(UUID id, String firstName, String lastName, LocalDate birthDate, LocalDateTime createdAt) {
}
