package com.total.api.Controllers;

import java.util.List;

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

import com.total.api.Dtos.ExampleCreateDto;
import com.total.api.Dtos.MensajeResponse;
import com.total.api.Entities.Example;
import com.total.api.Services.ExampleServices;

@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @Autowired
    private ExampleServices exampleServices;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Example> listExamples = exampleServices.getAll();
        if (listExamples.size() == 0) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros")
                            .object(null)
                            .build(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(listExamples)
                        .build(),
                HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(
                exampleServices.getOne(id),
                null,
                HttpStatus.OK);
    }

    @GetMapping("/findbyname")
    public ResponseEntity<?> findByName(@RequestParam(name = "nombre") String name) {
        // .../findbyname?nombre=Lucc
        return new ResponseEntity<>(
                exampleServices.getByName(name),
                null,
                HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Example> create(@RequestBody ExampleCreateDto exampleCreateDto) {

        return new ResponseEntity<>(
                exampleServices.save(exampleCreateDto),
                HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Example> update(@RequestBody Example example, @PathVariable long id) {

        return new ResponseEntity<>(
                exampleServices.update(example, id),
                HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Example> delete(@PathVariable long id) {

        return new ResponseEntity<>(
                exampleServices.delete(id),
                HttpStatus.OK);
    }
}
