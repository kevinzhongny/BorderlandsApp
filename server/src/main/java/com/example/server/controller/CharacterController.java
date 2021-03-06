package com.example.server.controller;
import com.example.server.model.Characters;
import com.example.server.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
//http://localhost:8080/characters

public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping
    public Iterable<Characters> getCharacters() {
        return characterService.getCharacters();
    }

    @GetMapping("/{characterId}")
    public Characters findCharacterById(@PathVariable Long characterId) {
        return characterService.findCharacterById(characterId);
    }

    @PostMapping
    public Characters createCharacter(@RequestBody Characters characters) {
        return characterService.createCharacter(characters);
    }

    @PatchMapping("/{characterId}")
    public Characters updateCharacter(@PathVariable Characters characters) {
        return characterService.updateCharacter(characters);
    } // need to make sure the IDs will not change

    @DeleteMapping("/{characterId}")
    public HttpStatus deleteCharacter(@PathVariable Long characterId) {
        return characterService.deleteCharacter(characterId);
    }
}
