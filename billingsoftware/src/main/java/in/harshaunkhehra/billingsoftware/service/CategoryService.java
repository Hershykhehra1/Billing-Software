package in.harshaunkhehra.billingsoftware.service;

import in.harshaunkhehra.billingsoftware.io.CategoryRequest;
import in.harshaunkhehra.billingsoftware.io.CategoryResponse;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request);
    
}
