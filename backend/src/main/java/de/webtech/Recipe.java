package de.webtech;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Recipe {
    private String name;
    private int id;
    private List<String> ingredients;
    private String instructions;
    private String preparationTime;
}
