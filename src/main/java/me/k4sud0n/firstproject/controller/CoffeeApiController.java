package me.k4sud0n.firstproject.controller;

import me.k4sud0n.firstproject.dto.ArticleForm;
import me.k4sud0n.firstproject.dto.CoffeeForm;
import me.k4sud0n.firstproject.entity.Article;
import me.k4sud0n.firstproject.entity.Coffee;
import me.k4sud0n.firstproject.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoffeeApiController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("/api/coffee")
    public List<Coffee> coffee() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/api/coffee/{id}")
    public Coffee getCoffee(@PathVariable long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/coffee")
    public Coffee postCoffee(@RequestBody CoffeeForm dto) {
        Coffee coffee = dto.toEntity();
        return coffeeRepository.save(coffee);
    }

    @PatchMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable Long id, @RequestBody CoffeeForm dto) {
        Coffee coffee = dto.toEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if (target == null || id != coffee.getId()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        target.patch(coffee);
        Coffee updatedCoffee = coffeeRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> deleteCoffee(@PathVariable long id) {
        Coffee coffee = coffeeRepository.findById(id).orElse(null);

        if (coffee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        coffeeRepository.delete(coffee);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
