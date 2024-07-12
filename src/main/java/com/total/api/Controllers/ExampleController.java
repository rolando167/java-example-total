package com.total.api.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.total.api.Dtos.ExampleCreateDto;
import com.total.api.Dtos.MensajeResponse;
import com.total.api.Entities.Example;
import com.total.api.Exceptions.ResourceNotFoundException;
import com.total.api.Services.ExampleService;

/*
 * Author: RH
 * Updated at: 12-07-2024
*/

@RestController
@RequestMapping("example")
public class ExampleController {

    private static Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @Autowired
    private ExampleService exampleServices;

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
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Example example = exampleServices.getOne(id);
        if (example == null) {
            throw new ResourceNotFoundException("Not found Example with id = " + id);
        }
        return new ResponseEntity<>(
                example,
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
    public ResponseEntity<?> create(@RequestBody ExampleCreateDto exampleCreateDto) {
        try {
            return new ResponseEntity<>(
                    exampleServices.save(exampleCreateDto),
                    HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Example> update(@RequestBody Example example, @PathVariable Long id) {

        return new ResponseEntity<>(
                exampleServices.update(example, id),
                HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Example> delete(@PathVariable Long id) {
        Example example = exampleServices.getOne(id);

        if (example == null) {
            throw new ResourceNotFoundException("Not found Example with id = " + id);
        }
        return new ResponseEntity<>(
                exampleServices.delete(id),
                HttpStatus.OK);
        // return ResponseEntity.badRequest().build();
    }

    @GetMapping("test/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void testLogger(@PathVariable Long id, @RequestBody Example example) {
        logger.debug("Obteniendo datos example con id {} y data {}", id, example);
        logger.info("Logger info");
        logger.warn("Logger warn");
        logger.error("Logger error");
    }
}
