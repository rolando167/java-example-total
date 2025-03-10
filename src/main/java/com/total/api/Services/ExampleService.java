package com.total.api.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.total.api.Dtos.ExampleCreateDto;
import com.total.api.Dtos.ExampleFindNameDto;
import com.total.api.Entities.Example;
import com.total.api.Repositories.ExampleRepository;

@Service
public class ExampleService implements IExampleService {
    @Autowired
    private ExampleRepository exampleRepository;

    @Override
    public List<Example> getAll() {
        return exampleRepository.findAll();
    }

    @Override
    public Example getOne(Long id) {
        Optional<Example> example = exampleRepository.findById(id);
        if (example.isPresent()) {
            return example.get();
        }
        return null;
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
        // Optional
        List<ExampleFindNameDto> listExamples = exampleRepository.getListByName(name)
                .stream()
                .map(maker -> ExampleFindNameDto.builder()
                        .name(maker.getName())
                        .last_name(maker.getLast_name())
                        .salary(maker.getSalary())
                        .build())
                .collect(Collectors.toList());
        return listExamples;
    }

    @Override
    public Example save(ExampleCreateDto exampleDto) {
        Example example = Example.builder()
                .name(exampleDto.getName())
                .last_name(exampleDto.getLast_name())
                .email(exampleDto.getEmail())
                .status(exampleDto.getStatus())
                .salary(exampleDto.getSalary())
                .published(exampleDto.isPublished())
                .build();
        return exampleRepository.save(example);
    }

    @Override
    public Example update(Example example, Long id) {
        example.setId(id);
        return exampleRepository.save(example);
    }

    @Override
    public Example delete(Long id) {
        Optional<Example> example = exampleRepository.findById(id);
        if (example.isPresent()) {
            exampleRepository.deleteById(id);
            return example.get();
        }
        return null;
    }

}
