package com.promigas.persistence;

import com.google.gson.Gson;
import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.repository.SecretPort;
import com.promigas.persistence.repository.SecretRepository;
import com.promigas.persistence.repository.SecretRepositoryImpl;

public class SecretAdapter implements SecretPort {
    @Override
    public ConnectionInfo querySecretConnection(String secretName) {
        SecretRepository repository = new SecretRepositoryImpl();
        String secretValue = repository.querySecret(secretName);
        return new Gson().fromJson(secretValue, ConnectionInfo.class);
    }
}
