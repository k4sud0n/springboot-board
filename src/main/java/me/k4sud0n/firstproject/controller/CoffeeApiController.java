package me.k4sud0n.firstproject.controller;

import me.k4sud0n.firstproject.dto.CoffeeForm;
import me.k4sud0n.firstproject.entity.Coffee;
import me.k4sud0n.firstproject.repository.CoffeeRepository;
import me.k4sud0n.firstproject.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoffeeApiController {
    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("/api/coffee")
    public List<Coffee> coffee() {
        return coffeeService.index();
    }

    @GetMapping("/api/coffee/{id}")
    public Coffee getCoffee(@PathVariable long id) {
        return coffeeService.show(id);
    }

    @PostMapping("/api/coffee")
    public ResponseEntity<Coffee> postCoffee(@RequestBody CoffeeForm dto) {
        Coffee created = coffeeService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable Long id, @RequestBody CoffeeForm dto) {
        Coffee updated = coffeeService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> deleteCoffee(@PathVariable long id) {
        Coffee deleted = coffeeService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
