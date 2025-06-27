package de.webtech.web;

import de.webtech.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import de.webtech.Recipe;
import de.webtech.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/recipes")
@CrossOrigin(origins = {"https://frontend-webtech-yosh.onrender.com", "http://localhost:5173"})
public class RestController {

    private final RecipeService recipeService;

    @Autowired
    public RestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id)
                .map(recipe -> ResponseEntity.ok(recipe))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.createRecipe(recipe);
        URI location = URI.create("/api/recipes/" + savedRecipe.getId());
        return ResponseEntity.created(location).body(savedRecipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipeDetails) {
        try {
            Recipe updatedRecipe = recipeService.updateRecipe(id, recipeDetails);
            return ResponseEntity.ok(updatedRecipe);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        try {
            recipeService.deleteRecipe(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }



//    @CrossOrigin(origins = {"https://frontend-webtech-yosh.onrender.com/", "http://localhost:5173"})
//    @GetMapping(path = "/webtech")
//    public ResponseEntity<Recipe> getRecipe() {
//        List<String> ingredients = Arrays.asList("Kochsahne", "Kartoffel", "Käse", "Muskatnuss");
//        final Recipe recipe = new Recipe(
//                        "Kartoffelgratin",
//                ingredients,
//                "Kartoffeln schälen, schneiden, mit Sahne und Gewürzen mischen, mit Käse überbacken.",
//                "90 Minuten",
//                1);
//        return ResponseEntity.ok(recipe);
//    }

}
