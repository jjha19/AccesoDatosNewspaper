package newspapercrud.dao;

import newspapercrud.dao.model.CredentialsEntity;

import java.util.List;

public interface CredentialsRepository {
    List<CredentialsEntity> getAll();
    CredentialsEntity get(String username);
    int save(CredentialsEntity credentialsEntity);
    void delete(CredentialsEntity credentialsEntity);
    void update(CredentialsEntity credentialsEntity);
}
