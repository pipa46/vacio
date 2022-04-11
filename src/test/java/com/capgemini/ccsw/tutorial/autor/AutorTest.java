package com.capgemini.ccsw.tutorial.autor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.tutorial.autor.model.AutorDto;
import com.capgemini.ccsw.tutorial.autor.model.AutorSearchDto;

@SpringBootTest
@Transactional
public class AutorTest {

    private static final int TOTAL_AUTORS = 6;

    @Autowired
    private AutorController authorController;

    @Test
    public void findFirstPageWithFiveSizeShouldReturnFirstFiveResults() {

        int pageSize = 5;

        assertNotNull(authorController);

        AutorSearchDto dto = new AutorSearchDto();
        dto.setPageable(PageRequest.of(0, pageSize));

        Page<AutorDto> resultPage = authorController.findPage(dto);
        List<AutorDto>autor=authorController.findAll();

        assertNotNull(resultPage);
        
      

        assertEquals(TOTAL_AUTORS, resultPage.getTotalElements());
        assertEquals(pageSize, resultPage.getContent().size());

    }
   
    @Test
    public void findSecondPageWithFiveSizeShouldReturnLastTwoResults() {

        int pageSize = 5;
        int elementsCount = TOTAL_AUTORS - pageSize;

        assertNotNull(authorController);

        AutorSearchDto searchDto = new AutorSearchDto();
        searchDto.setPageable(PageRequest.of(1, pageSize));

        Page<AutorDto> resultPage = authorController.findPage(searchDto);

        assertNotNull(resultPage);

        assertEquals(TOTAL_AUTORS, resultPage.getTotalElements());
        assertEquals(elementsCount, resultPage.getContent().size());

    }

    @Test
    public void saveWithoutIdShouldCreateNewAuthor() {

        assertNotNull(authorController);

        String newAuthorName = "Nuevo Autor";
        String newNationality = "Nueva Nacionalidad";

        long newAuthorId = TOTAL_AUTORS + 1;
        long newAuthorSize = TOTAL_AUTORS + 1;

        AutorDto dto = new AutorDto();
        dto.setNombre(newAuthorName);
        dto.setNacionalidad(newNationality);

        authorController.save(null, dto);

        AutorSearchDto searchDto = new AutorSearchDto();
        searchDto.setPageable(PageRequest.of(0, (int) newAuthorSize));

        Page<AutorDto> resultPage = authorController.findPage(searchDto);

        assertNotNull(resultPage);
        assertEquals(newAuthorSize, resultPage.getTotalElements());

        AutorDto author = resultPage.getContent().stream().filter(item -> item.getId().equals(newAuthorId)).findFirst().orElse(null);
        assertNotNull(author);
        assertEquals(newAuthorName, author.getNombre());

    }

    @Test
    public void modifyWithExistIdShouldModifyCategory() {

        assertNotNull(authorController);

        String newAuthorName = "Nuevo Autor";
        long authorId = 3;

        AutorDto dto = new AutorDto();
        dto.setNombre(newAuthorName);

        authorController.save(authorId, dto);

        AutorSearchDto searchDto = new AutorSearchDto();
        searchDto.setPageable(PageRequest.of(0, (int) authorId));

        Page<AutorDto> resultPage = authorController.findPage(searchDto);

        assertNotNull(resultPage);
        assertEquals(TOTAL_AUTORS, resultPage.getTotalElements());

        AutorDto author = resultPage.getContent().stream().filter(item -> item.getId().equals(authorId)).findFirst().orElse(null);
        assertNotNull(author);
        assertEquals(newAuthorName, author.getNombre());

    }

    @Test
    public void modifyWithNotExistIdShouldThrowException() {

        assertNotNull(authorController);

        String newAuthorName = "Nuevo Autor";
        long authorId = TOTAL_AUTORS + 1;

        AutorDto dto = new AutorDto();
        dto.setNombre(newAuthorName);

        assertThrows(Exception.class, () -> authorController.save(authorId, dto));
    }

    @Test
    public void deleteWithExistsIdShouldDeleteCategory() {

        assertNotNull(authorController);

        long newAuthorsSize = TOTAL_AUTORS - 1;
        long deleteAuthorId = 6;

        authorController.delete(deleteAuthorId);

        AutorSearchDto searchDto = new AutorSearchDto();
        searchDto.setPageable(PageRequest.of(0, TOTAL_AUTORS));

        Page<AutorDto> resultPage = authorController.findPage(searchDto);

        assertNotNull(resultPage);
        assertEquals(newAuthorsSize, resultPage.getTotalElements());

    }

    @Test
    public void deleteWithNotExistsIdShouldThrowException() {

        assertNotNull(authorController);

        long deleteAuthorId = TOTAL_AUTORS + 1;

        assertThrows(Exception.class, () -> authorController.delete(deleteAuthorId));

    }
    
    @Test
    public void findAllShouldReturnAllAuthorsInDB()
    {
    	assertNotNull(authorController);
    	
    	List <AutorDto> authors=authorController.findAll();
    	
    	assertNotNull(authors);
    	
    	assertEquals(TOTAL_AUTORS,authors.size());
    }
    
}
