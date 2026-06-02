package com.agudelo.api.controller;

import com.agudelo.api.model.Person;
import com.agudelo.api.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "*")
public class PersonCtrl {

    @Autowired
    private PersonRepo repo;

    @GetMapping
    public List<Person> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person p) {
        return repo.save(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person p) {
        return repo.findById(id).map(existing -> {
            existing.setNombre(p.getNombre());
            existing.setApellido(p.getApellido());
            existing.setFechaNacimiento(p.getFechaNacimiento());
            existing.setPuesto(p.getPuesto());
            existing.setSueldo(p.getSueldo());
            return ResponseEntity.ok(repo.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
