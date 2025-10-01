package newspapercrud.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialsDTO {
    private String username;
    private String password;
}
