package in.harshaunkhehra.billingsoftware.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.harshaunkhehra.billingsoftware.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

    Optional<CategoryEntity> findByCategoryId(String categoryId);
    
}
