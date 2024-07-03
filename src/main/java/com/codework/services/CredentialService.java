package com.codework.services;

import java.util.List;

import com.codework.models.Credentials;

public interface CredentialService {

    Credentials saveCredentials(Credentials credentials);

    List<Credentials> getPasswords();

    void removeCredentials(Long id);

    Credentials updateCredentials(Long id, Credentials credentials);

}
