package newspapercrud.ui;

import jakarta.inject.Inject;
import newspapercrud.domain.model.CredentialsDTO;
import newspapercrud.domain.service.CredentialService;


public class CredentialUi {
    private final CredentialService credentialsService;

    @Inject
    public CredentialUi(CredentialService credentialsService) {
        this.credentialsService = credentialsService;
    }


    public boolean checkLogin(CredentialsDTO credentialsDTO) {
        return credentialsService.checkLogin(credentialsDTO);
    }
}
