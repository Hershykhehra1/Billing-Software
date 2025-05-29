package in.harshaunkhehra.billingsoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.harshaunkhehra.billingsoftware.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
    
}
