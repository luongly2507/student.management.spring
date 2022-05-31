package student.management.spring.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateRegulation {
    private String minAge;
    private String maxAge;
    private String passScore; 
    private String classCount; 
}
