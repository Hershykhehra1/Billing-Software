package in.harshaunkhehra.billingsoftware.io;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryRequest {
    //io objects 

    private String name;
    private String description;
    private String bgColor;
    
}
