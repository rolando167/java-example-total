package com.total.api.Services;

import java.util.List;

import com.total.api.Dtos.ExampleCreateDto;
import com.total.api.Dtos.ExampleFindNameDto;
import com.total.api.Entities.Example;

public interface IExampleService {
    public List<Example> getAll();
    public Example getOne(long id);
    public List<ExampleFindNameDto> getByName(String name);
    public Example save(ExampleCreateDto exampleDto);
    public Example update(Example example, long id);
    public Example delete(long id);
}
