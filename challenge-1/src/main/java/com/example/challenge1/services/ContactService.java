package com.example.challenge1.services;

import com.example.challenge1.dtos.ContactDTO;
import com.example.challenge1.dtos.ContactResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    public ContactResponseDTO createContact(ContactDTO contact) {
        validateContact(contact);

        ContactResponseDTO response = new ContactResponseDTO(contact.getMessage());

        String message = "Thank " + contact.getName() +
                ", for getting in touch and sharing your interests. We look forward to hearing from you soon.";

        response.setMsg(message);

        return response;
    }

    private void validateContact(ContactDTO contact) {
        if (contact.getName() == null || contact.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (contact.getEmail() == null || contact.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        } else if (contact.getMessage() == null || contact.getMessage().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        } else if (contact.getInterest() == null || contact.getInterest().isEmpty()) {
            throw new IllegalArgumentException("Interest cannot be empty");
        }
    }
}
