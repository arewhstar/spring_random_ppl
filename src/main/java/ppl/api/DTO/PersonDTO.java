package ppl.api.DTO;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String nationality;
}
