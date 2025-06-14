package in.harshaunkhehra.billingsoftware.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.harshaunkhehra.billingsoftware.io.CategoryRequest;
import in.harshaunkhehra.billingsoftware.io.CategoryResponse;
import in.harshaunkhehra.billingsoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    //creating category endpoint
    @PostMapping("/admin/categories") //only admin can create categories
    @ResponseStatus(HttpStatus.CREATED)
    //use request part here  because we are sending a multipart file and the request body
    public CategoryResponse addCategory(@RequestPart("category") String categoryString, @RequestPart("file") MultipartFile file){
        //create objectmapper
        ObjectMapper objectMapper = new ObjectMapper();
        CategoryRequest request = null;
        try {
            //convert json string to object
            request = objectMapper.readValue(categoryString, CategoryRequest.class);

            //call service method to add category
            return categoryService.add(request, file);  

        } catch (JsonProcessingException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exception occured while parsing the json: " + ex.getMessage());
        }
        
    }
    
    //reading all categories endpoint and is accessible to all users(roles)
    @GetMapping("/categories")
    public List<CategoryResponse> fetchCategories() {
        return categoryService.read();
    }

    //deleting category endpoint
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/admin/categories/{categoryId}") //only admin can delete categories
    public void remove(@PathVariable String categoryId) {
        try {
            categoryService.delete(categoryId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    
}
