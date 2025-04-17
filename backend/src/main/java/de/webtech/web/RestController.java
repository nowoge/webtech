package de.webtech.web;

import de.webtech.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class RestController {

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
}
