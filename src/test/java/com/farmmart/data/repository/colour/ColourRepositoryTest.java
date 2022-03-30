package com.farmmart.data.repository.colour;

import com.farmmart.data.model.colour.Colour;
import com.farmmart.data.model.colour.ColourNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
@Sql(scripts={"classpath:db/insert.sql"})
class ColourRepositoryTest {

    @Autowired
    private ColourRepository colourRepository;

    Colour colour;

    @BeforeEach
    void setUp() {
        colour=new Colour();
    }

    @Test
    void testThatYouCanSaveColour(){
        colour.setColourName("Pink");

        log.info("Colour repo {} before saving ", colour);

        //Save Colour

        assertDoesNotThrow(()->colourRepository.save(colour));

        assertEquals("Red",colour.getColourName());

        log.info("Colour repo {} after saving ", colour);
    }

    @Test
    void testThatYouCanFindColourById() throws ColourNotFoundException {
        Long id =4L;
        colour=colourRepository.findById(id).orElseThrow(()->new ColourNotFoundException("Colour Not Found"));

        assertEquals("Yellow", colour.getColourName(), "");

        log.info("Colour {} ", colour);
    }

    @Test
    void testThatYouCanFindColourByNAme() throws ColourNotFoundException {
        String name ="Green";

        colour=colourRepository.findColourByName(name);

        if (colour==null){
            throw new ColourNotFoundException("Colour Not Found");
        }

        assertEquals("Green",colour.getColourName());

        log.info("Colour {}", colour);
    }

    @Test
    void testThatYouCanFindAllColours() throws ColourNotFoundException {
        List<Colour> colours= colourRepository.findAll();

        if (colours.isEmpty()){
            throw new ColourNotFoundException("Colour repo is empty");
        }

        log.info("Colours {} in the repo",colours);
    }

    @Test
    void testThatYouCanUpdateColour() throws ColourNotFoundException {

        Long id =1L;
        colour=colourRepository.findById(id).orElseThrow(()->new ColourNotFoundException("Colour Not Found"));

        colour.setColourName("Mint Green");

        assertDoesNotThrow(()->colourRepository.save(colour));

        assertThat(colour.getColourName()).isEqualTo("Mint Green");

        log.info("Updated colour {}", colour);
    }

    @Rollback(value = false)
    @Test
    void testThatYouCanDeleteColourById() throws ColourNotFoundException {
        Long id=3L;
        colourRepository.deleteById(id);

        Optional<Colour> optionalColour=colourRepository.findById(id);

        if (optionalColour.isPresent()){
            throw new ColourNotFoundException("Colour id "+id+" is not deleted");
        }
    }

    @Rollback
    @Test
    void testThatYouCanDeleteAllColours(){

        colourRepository.deleteAll();

    }
}