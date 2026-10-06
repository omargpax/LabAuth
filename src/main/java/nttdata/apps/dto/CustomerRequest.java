package nttdata.apps.dto;

import java.time.LocalDate;

public record CustomerRequest(String firstName, String lastName, LocalDate brithDate) {
}
