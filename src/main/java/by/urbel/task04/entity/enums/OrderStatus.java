package by.urbel.task04.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    NEW("New"),
    ACCEPTED("Accepted"),
    FINISHED("Finished"),
    CANCELED("Canceled");
    private final String name;
}
