package in.harshaunkhehra.billingsoftware.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import in.harshaunkhehra.billingsoftware.entity.CategoryEntity;
import in.harshaunkhehra.billingsoftware.io.CategoryRequest;
import in.harshaunkhehra.billingsoftware.io.CategoryResponse;
import in.harshaunkhehra.billingsoftware.repository.CategoryRepository;
import in.harshaunkhehra.billingsoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    
    // Implementation of adding a category, convert request to entity, save to repository, return response
    @Override
    public CategoryResponse add(CategoryRequest request) {
        //pass request object and get the category entity back
        CategoryEntity newCategory = convertToEntity(request); 

        //save the category entity to the database
        //when we do this we are going to generate the auto increment id for the id property and store that in a variable object 
        newCategory = categoryRepository.save(newCategory); 

        //after getting the new category, we have to do the reverse and convert/copy all of the values into the category response
        return convertToResponse(newCategory);

    }

    private CategoryResponse convertToResponse(CategoryEntity newCategory) {
       return CategoryResponse.builder()
            .categoryId(newCategory.getCategoryId())
            .name(newCategory.getName())
            .description(newCategory.getDescription())
            .bgColor(newCategory.getBgColor())
            .imgUrl(newCategory.getImgUrl())
            .createdAt(newCategory.getCreatedAt())
            .updatedAt(newCategory.getUpdatedAt())
            .build();
    }

    //we copied all of the objects to the category entity and when we get the category entity we can directyl store into the database
    //make sure to generate the image, we havet to store that in a aws s3 bucket
    private CategoryEntity convertToEntity(CategoryRequest request) {
        //use builder pattern to copy all values to the category entity
        return CategoryEntity.builder()
            .categoryId(UUID.randomUUID().toString()) //first generate category id
            .name(request.getName())
            .description(request.getDescription())
            .bgColor(request.getBgColor())
            .build();
    }

}
    
