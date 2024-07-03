package com.codework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codework.models.Credentials;
import com.codework.services.CredentialService;

@RestController
@RequestMapping("/api/passwords")
@CrossOrigin(origins = "http://localhost:3000")
public class CredentialController {

    @Autowired
    private CredentialService credentialService;


    @PostMapping("/add")
    public ResponseEntity<Credentials> addCredential(@RequestBody Credentials credentials) {
        Credentials saveCredential = credentialService.saveCredentials(credentials);
        return new ResponseEntity<>(saveCredential, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeCredentials(@PathVariable Long id) {
        credentialService.removeCredentials(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Credentials> updateCredentials(@PathVariable Long id, @RequestBody Credentials credentials) {
        Credentials updatedCredentials = credentialService.saveCredentials(credentials);
        return new ResponseEntity<>(updatedCredentials, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Credentials>> getAllCredentials() {
        List<Credentials> credentialsList = credentialService.getPasswords();
        return new ResponseEntity<>(credentialsList, HttpStatus.OK);
    }

}
