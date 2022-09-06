package app_academy.cursos.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import app_academy.cursos.model.Curso;
import app_academy.cursos.repository.CursosRepository;

@RestController
@RequestMapping("/api")
class CursosController {

    @Autowired
    CursosRepository repository;

    @GetMapping("/cursos")
    public ResponseEntity<List<Curso>> getAll() {
        try {
            List<Curso> items = new ArrayList<Curso>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> getById(@PathVariable("id") int id) {
        Optional<Curso> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> create(  @RequestParam String nombre, 
                                            @RequestParam int costo, 
                                            @RequestParam String descripcion,
                                            @RequestParam int horas_duracion,
                                            @RequestParam String dirigido_a, 
                                            @RequestParam String modalidad){
            Curso item = new Curso(nombre, costo, descripcion, horas_duracion, dirigido_a, modalidad);
        try {
            Curso savedItem = repository.save(item);//save(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/cursos/{id}")
    public ResponseEntity<Curso> update(@PathVariable("id") int id, @RequestBody Curso item) {
        Optional<Curso> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            Curso existingItem = existingItemOptional.get();
            System.out.println("TODO for developer - update logic is unique to entity and must be implemented manually.");
            //existingItem.setSomeField(item.getSomeField());
            return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}