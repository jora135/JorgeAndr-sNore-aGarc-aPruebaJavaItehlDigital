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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app_academy.cursos.model.descuento;
import app_academy.cursos.repository.DescuentoRepository;

@RestController
@RequestMapping("/api")
class DescuentoController {

    @Autowired
    DescuentoRepository repository;

    @GetMapping("/descuento")
    public ResponseEntity<List<descuento>> getAll() {
        try {
            List<descuento> items = new ArrayList<descuento>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/descuento/{id}")
    public ResponseEntity<descuento> getById(@PathVariable("id") int id) {
        Optional<descuento> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/descuento")
    public ResponseEntity<descuento> create(  @RequestParam String nombre_des, 
                                            @RequestParam String modalidad, 
                                            @RequestParam String pais,
                                            @RequestParam int descuento,
                                            @RequestParam String curso, 
                                            @RequestParam String fecha_fin_promo){
            descuento item = new descuento(nombre_des, modalidad, pais, descuento, curso, fecha_fin_promo);
        try {
            descuento savedItem = repository.save(item);//save(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/descuento/{id}")
    public ResponseEntity<descuento> update(@PathVariable("id") int id, @RequestBody descuento item) {
        Optional<descuento> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            descuento existingItem = existingItemOptional.get();
            System.out.println("TODO for developer - update logic is unique to entity and must be implemented manually.");
            //existingItem.setSomeField(item.getSomeField());
            return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/descuento/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}