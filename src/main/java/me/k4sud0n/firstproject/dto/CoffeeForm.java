package me.k4sud0n.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import me.k4sud0n.firstproject.entity.Coffee;

@AllArgsConstructor
@ToString
public class CoffeeForm {
    private Long id;
    private String name;
    private String price;

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }
}
