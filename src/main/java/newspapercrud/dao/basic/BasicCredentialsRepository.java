package newspapercrud.dao.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import newspapercrud.dao.CredentialsRepository;
import newspapercrud.dao.model.CredentialsEntity;

import java.util.List;

@Data
@AllArgsConstructor
public class BasicCredentialsRepository implements CredentialsRepository {


    @Override
    public List<CredentialsEntity> getAll() {
        return List.of();
    }

    public CredentialsEntity get(String username) {
        //connect DB
        //Send the query SQL and get the answer
        //return the answer
        return new CredentialsEntity("root", "root", 1);
    }

    @Override
    public int save(CredentialsEntity credentialsEntity) {
        return 0;
    }

    @Override
    public void delete(CredentialsEntity credentialsEntity) {

    }

    @Override
    public void update(CredentialsEntity credentialsEntity) {

    }
}
