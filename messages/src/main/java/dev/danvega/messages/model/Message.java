package dev.danvega.messages.model;

import org.springframework.data.annotation.Id;

public record Message(@Id  Integer id, String username, String text) {
}
