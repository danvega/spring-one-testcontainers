package dev.danvega.readinglist.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
@ActiveProfiles("test")
class BookRepositoryIntegrationTest {

    @Container
    static PostgreSQLContainer psql = new PostgreSQLContainer("postgres:alpine");

    @DynamicPropertySource
    static void configureContainer(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",psql::getJdbcUrl);
        registry.add("spring.datasource.username",psql::getUsername);
        registry.add("spring.datasource.password",psql::getPassword);
    }

    @Autowired
    BookRepository repository;

    @Test
    void findAll_shouldReturn1Books() {
        Integer mappedPort = psql.getMappedPort(5432);
        System.out.println("Mapped Port: " + mappedPort);
        assertEquals(1, repository.findAll().size());
    }

}