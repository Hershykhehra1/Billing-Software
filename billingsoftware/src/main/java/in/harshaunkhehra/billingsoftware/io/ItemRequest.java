package in.harshaunkhehra.billingsoftware.io;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemRequest {

    private String name;
    private BigDecimal price; 
    private String categoryId;
    private String description;
    
}
