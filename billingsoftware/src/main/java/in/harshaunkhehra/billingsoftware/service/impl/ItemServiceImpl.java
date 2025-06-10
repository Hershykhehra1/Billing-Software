package in.harshaunkhehra.billingsoftware.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import in.harshaunkhehra.billingsoftware.entity.CategoryEntity;
import in.harshaunkhehra.billingsoftware.entity.ItemEntity;
import in.harshaunkhehra.billingsoftware.io.ItemRequest;
import in.harshaunkhehra.billingsoftware.io.ItemResponse;
import in.harshaunkhehra.billingsoftware.repository.CategoryRepository;
import in.harshaunkhehra.billingsoftware.repository.ItemRepository;
import in.harshaunkhehra.billingsoftware.service.FileUploadService;
import in.harshaunkhehra.billingsoftware.service.ItemService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final FileUploadService fileUploadService;
    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;
    
    @Override
    public ItemResponse add(ItemRequest request, MultipartFile file) {
        String imgUrl = fileUploadService.uploadFile(file);

        //convert request object to response object to get the new item
        ItemEntity newItem = convertToEntity(request);
        //set the category for the new item
        CategoryEntity existingCategory = categoryRepository.findByCategoryId(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found: " + request.getCategoryId()));
        
        newItem.setCategory(existingCategory);
        newItem.setImgUrl(imgUrl); //image url recieved from the upload file service
        newItem = itemRepository.save(newItem);
        return convertToResponse(newItem);
    }

    private ItemResponse convertToResponse(ItemEntity newItem) {
        return ItemResponse.builder()
                .itemId(newItem.getItemId())
                .name(newItem.getName())
                .description(newItem.getDescription())
                .price(newItem.getPrice())
                .imgUrl(newItem.getImgUrl())
                .categoryName(newItem.getCategory().getName())
                .categoryId(newItem.getCategory().getCategoryId())
                .createdAt(newItem.getCreatedAt())
                .updatedAt(newItem.getUpdatedAt())
                .build();
    }

    private ItemEntity convertToEntity(ItemRequest request) {
        return ItemEntity.builder()
                .itemId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
                
    }

    @Override
    public List<ItemResponse> fetchItems() {
        return itemRepository.findAll().stream()
                .map(itemEntity -> convertToResponse(itemEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteItem(String itemId) {
        ItemEntity existingItem = itemRepository.findByItemId(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found: " + itemId));
        
        boolean isFileDeleted = fileUploadService.deleteFile(existingItem.getImgUrl());

        if(isFileDeleted) {
            itemRepository.delete(existingItem);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to delete image");
        }

    } 
    
}
