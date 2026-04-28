package dev.puggu.ists.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Indicates the status of a ticket
 */
@Getter
@AllArgsConstructor
public enum Status {
    SUBMITTED("Submitted", 1),
    UNDER_REVIEW("Under Review", 2),
    SOLVED("Solved", 3),
    ESCALATED("Escalated", 4),
    CANCELLED("Cancelled",5);

    private final String asString;
    private final int id;

    public Status fromId(int id) {
        return switch (id) {
            case 1 -> SUBMITTED;
            case 2 -> UNDER_REVIEW;
            case 3 -> SOLVED;
            case 4 -> ESCALATED;
            case 5 -> CANCELLED;
            default -> null;
        };
    }
}

