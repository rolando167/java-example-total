package com.total.api.Services;
import java.util.List;

import com.total.api.Dtos.ExampleDto;
import com.total.api.Entities.Example;

public interface IExampleServices {
    public List<Example> getAll();
    public Example getOne(long id);
    public List<ExampleDto> getByName(String name);
    public Example save(Example example);
    public Example update(Example example, long id);
    public Example delete(long id);
}
