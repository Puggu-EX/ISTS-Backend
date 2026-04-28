package dev.puggu.ists.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Tags that can be included with the ticket submission
 */
@Getter
@AllArgsConstructor
public enum Tag {
    DESKTOP("Desktop"), LAPTOP("Laptop"), MOBILE("Mobile"),
    NETWORK("Network"), INTERNET("Internet"), OTHER("Other"),
    PASSWORD("Password"), ACCOUNT("Account"), ACCESSORY("Computer Accessory");

    private final String value;
}

