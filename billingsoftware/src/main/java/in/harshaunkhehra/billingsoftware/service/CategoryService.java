package in.harshaunkhehra.billingsoftware.service;

import java.util.List;

import in.harshaunkhehra.billingsoftware.io.CategoryRequest;
import in.harshaunkhehra.billingsoftware.io.CategoryResponse;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request);

    List<CategoryResponse> read();

    void delete(String categoryId);
    
}
