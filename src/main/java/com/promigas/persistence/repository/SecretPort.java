package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;

public interface SecretPort {
    public ConnectionInfo querySecretConnection(String secretName);
}
