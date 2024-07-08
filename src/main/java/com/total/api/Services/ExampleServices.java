package com.total.api.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.total.api.Entities.Example;
import com.total.api.Repositories.ExampleRepository;

@Service
public class ExampleServices implements IExampleServices{
    @Autowired
    private ExampleRepository exampleRepository;

    @Override
    public List<Example> getAll() {
        return exampleRepository.findAll();
    }

    @Override
    public Example getOne(long id) {
        Optional<Example> example = exampleRepository.findById(id);
        if(example.isPresent()){
            return example.get();
        }
        return new Example();
    }

    @Override
    public List<Example> getByName(String name) {
        return exampleRepository.getListByName(name);
    }

    @Override
    public Example save(Example example) {
        return exampleRepository.save(example);
    }

    @Override
    public Example update(Example example, long id) {
        example.setId(id);
        return exampleRepository.save(example);
    }

    @Override
    public Example delete(long id) {
        Optional<Example> example = exampleRepository.findById(id);
        if(example.isPresent()){
            exampleRepository.deleteById(id);
            return example.get();
        }
        return new Example();
    }

}

