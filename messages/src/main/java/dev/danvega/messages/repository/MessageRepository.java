package dev.danvega.messages.repository;

import dev.danvega.messages.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Integer> {
}
