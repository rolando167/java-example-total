package com.total.api.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.total.api.Entities.Example;

public interface ExampleRepository extends JpaRepository<Example, Long>{
    @Query(value = "Select * from examples a where name like %:fil%", nativeQuery = true)
    public abstract List<Example> getListByName(@Param("fil") String nombre);

    //@Query(value = "EXEC REPORTS.SP_listarUsers", nativeQuery = true)
    //List<Cliente> listarPedidos(@Param("page_id") Long page_id);
}
