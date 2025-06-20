package de.webtech.web;

import de.webtech.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class RestController {

    @CrossOrigin(origins = {"https://frontend-webtech-yosh.onrender.com/", "http://localhost:5173"})
    @GetMapping(path = "/webtech")
    public ResponseEntity<Recipe> getRecipe() {
        List<String> ingredients = Arrays.asList("Kochsahne", "Kartoffel", "Käse", "Muskatnuss");
        final Recipe recipe = new Recipe(
                "Kartoffelgratin",
                1,
                ingredients,
                "Kartoffeln schälen, schneiden, mit Sahne und Gewürzen mischen, mit Käse überbacken.",
                "90 Minuten");
        return ResponseEntity.ok(recipe);
    }

    @CrossOrigin(origins = {"https://frontend-webtech-yosh.onrender.com/", "http://localhost:5173"})
    @PostMapping(path = "/webtech")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        System.out.println("Neues Rezept empfangen: " + recipe.getName());
        return ResponseEntity.ok(recipe);
    }
}
