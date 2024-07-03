package com.codework.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codework.customExceptions.ResourceNotFoundException;
import com.codework.models.Credentials;
import com.codework.repository.CredentialRepository;

@Service
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public List<Credentials> getPasswords() {
        return credentialRepository.findAll();
    }

    @Override
    public Credentials saveCredentials(Credentials credentials) {
        return credentialRepository.save(credentials);
    }

    @Override
    public void removeCredentials(Long id) {
        Credentials credentials = credentialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Credential with given id is not found"));
        credentialRepository.delete(credentials);
    }

    @Override
    public Credentials updateCredentials(Long id, Credentials updatedCredentials) {
        Credentials credentials = credentialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Credentials not found with id " + id));

        credentials.setSiteId(updatedCredentials.getSiteId());
        credentials.setSiteName(updatedCredentials.getSiteName());
        credentials.setSitePassword(updatedCredentials.getSitePassword());
        
        return credentialRepository.save(credentials);
    }

}
