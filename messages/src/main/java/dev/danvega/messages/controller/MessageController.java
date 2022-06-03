package dev.danvega.messages.controller;

import dev.danvega.messages.model.Message;
import dev.danvega.messages.repository.MessageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Message> findAll() {
        return repository.findAll();
    }

}
