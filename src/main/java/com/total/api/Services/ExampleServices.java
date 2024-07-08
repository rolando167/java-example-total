package com.total.api.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.total.api.Dtos.ExampleCreateDto;
import com.total.api.Dtos.ExampleFindNameDto;
import com.total.api.Entities.Example;
import com.total.api.Repositories.ExampleRepository;

@Service
public class ExampleServices implements IExampleServices {
    @Autowired
    private ExampleRepository exampleRepository;

    @Override
    public List<Example> getAll() {
        return exampleRepository.findAll();
    }

    @Override
    public Example getOne(long id) {
        Optional<Example> example = exampleRepository.findById(id);
        if (example.isPresent()) {
            return example.get();
        }
        return new Example();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExampleFindNameDto> getByName(String name) {
        List<Example> examples = exampleRepository.getListByName(name);
        List<ExampleFindNameDto> examplesDto = new ArrayList<>();
        examples.stream().forEach(item -> {
            ExampleFindNameDto exampleDto = new ExampleFindNameDto();
            exampleDto.setName(item.getName());
            exampleDto.setLast_name(item.getLast_name());
            exampleDto.setSalary(item.getSalary());
            examplesDto.add(exampleDto);
        });
        return examplesDto;
    }

    public List<ExampleFindNameDto> getByName2(String name) {
        List<Example> examples = exampleRepository.getListByName(name);
        List<ExampleFindNameDto> examplesDto = new ArrayList<>();
        examples.stream().forEach(item -> {
            ExampleFindNameDto exampleDto = new ExampleFindNameDto();
            exampleDto.setName(item.getName());
            exampleDto.setLast_name(item.getLast_name());
            exampleDto.setSalary(item.getSalary());
            examplesDto.add(exampleDto);
        });
        return examplesDto;
    }

    @Override
    public Example save(ExampleCreateDto exampleDto) {
        Example example = Example.builder()
                .name(exampleDto.getName())
                .last_name(exampleDto.getLast_name())
                .status(exampleDto.getStatus())
                .salary(exampleDto.getSalary())
                .published(exampleDto.isPublished())
                .build();
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
        if (example.isPresent()) {
            exampleRepository.deleteById(id);
            return example.get();
        }
        return new Example();
    }

}
