package dev.puggu.ists.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {
    Low(1), Medium(2), High(3), CRITICAL(4);
    private final int value;
}

