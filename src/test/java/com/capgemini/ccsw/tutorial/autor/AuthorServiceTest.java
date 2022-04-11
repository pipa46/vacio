package com.capgemini.ccsw.tutorial.autor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.tutorial.autor.model.Autor;

@SpringBootTest
@Transactional
public class AuthorServiceTest {

    @Autowired
    private AutorService authorService;

    @Test
    public void getExistsAuthorIdShouldReturnAuthor() {
        assertNotNull(authorService);

        Long authorId = 1L;

        Autor author = authorService.get(1L);

        assertNotNull(author);

        assertEquals(authorId, author.getId());

    }

    @Test
    public void getNotExistsAuthorIdShouldReturnNull() {
        assertNotNull(authorService);

        Long authorId = 0L;

        Autor author = authorService.get(authorId);

        assertNull(author);

    }

}

