package newspapercrud.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialsEntity{
    private String username;
    private String password;
    private int idReader;

}
