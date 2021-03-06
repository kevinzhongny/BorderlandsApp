package com.example.server.controller;

import com.example.server.model.Creatures;
import com.example.server.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creatures")
//http://localhost:8080/creatures

public class CreatureController {

    @Autowired
    CreatureService creatureService;

    @GetMapping
    public Iterable<Creatures> getCreatures() {
        return creatureService.getCreatures();
    }

    @GetMapping ("/{id}")
    public Creatures getCreatureById(@PathVariable Long creature_id) {
        return creatureService.findCreatureById(creature_id);
    }

    @PostMapping
    public Creatures createCreature(@RequestBody Creatures creatures) {
        return creatureService.createCreature(creatures);
    }

    @PatchMapping("/{id}")
    public Creatures updateCreature(@RequestBody Creatures creatures) {
        return creatureService.updateCreature(creatures);
    } // need to make sure the IDs will not change

    @DeleteMapping ("/{creature_id}")
    public HttpStatus deleteCreature(@PathVariable Long creature_id) {
        return creatureService.deleteCreature(creature_id);
    }
}
