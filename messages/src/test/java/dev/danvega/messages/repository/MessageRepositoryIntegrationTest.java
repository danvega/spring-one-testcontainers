package dev.danvega.messages.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class MessageRepositoryIntegrationTest {

    @Autowired
    MessageRepository repository;

    @Test
    void shouldFindAll5Messages() {
        assertEquals(5, StreamSupport.stream(repository.findAll().spliterator(),false).count());
    }

}
