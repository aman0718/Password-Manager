package com.codework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codework.models.Credentials;

@Repository
public interface CredentialRepository extends JpaRepository<Credentials, Long>{


}
