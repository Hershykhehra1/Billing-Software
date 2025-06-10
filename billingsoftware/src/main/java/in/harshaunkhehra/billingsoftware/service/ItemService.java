package in.harshaunkhehra.billingsoftware.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.harshaunkhehra.billingsoftware.io.ItemRequest;
import in.harshaunkhehra.billingsoftware.io.ItemResponse;

public interface ItemService {

    ItemResponse add(ItemRequest request, MultipartFile file);

    List<ItemResponse> fetchItems();

    void deleteItem(String itemId);
    
}
