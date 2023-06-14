package com.artificialncool.hostapp.controller;

import com.artificialncool.hostapp.model.Korisnik;
import com.artificialncool.hostapp.service.KorisnikService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value="/api/korisnik")
@RequiredArgsConstructor
public class KorisnikController {

    private final KorisnikService korisnikService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Korisnik>> getAll() {
        return new ResponseEntity<>(korisnikService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/username/{username}")
    public ResponseEntity<Korisnik> getByUsername(@PathVariable String username) {
        try {
            return new ResponseEntity<>(korisnikService.getByUsername(username), HttpStatus.OK);
        }
        catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Korisnik nije pronadjen", ex);
        }
    }

    @PostMapping(value = "/fill-up")
    public ResponseEntity<Void> createKorisnici() {
        korisnikService.createKorisnici();
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<Korisnik> createNew(@RequestBody Korisnik korisnik) {
        Korisnik saved = korisnikService.createNew(korisnik);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
