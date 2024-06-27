package com.ferry.bank.controller;

import com.ferry.bank.model.dtos.ClientDto;
import com.ferry.bank.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDto>> getAllClients(Pageable page) {
        return ResponseEntity.ok(clientService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }
}
