package com.example.challenge.controllers;

import com.example.challenge.dtos.ContactDTO;
import com.example.challenge.dtos.ContactResponseDTO;
import com.example.challenge.services.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping(value = "/create_contact")
    public ResponseEntity<ContactResponseDTO> createContact(@RequestBody ContactDTO contact) {
        try {
            ContactResponseDTO response = contactService.createContact(contact);

            return ResponseEntity.ok().body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ContactResponseDTO(e.getMessage()));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ContactResponseDTO("Internal Server Error"));
        }
    }
}
