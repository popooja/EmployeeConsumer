package com.example.DemoConsumer.client;

import com.example.DemoConsumer.model.EmployeeDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

public interface EmployeeClient {

    @GET("employee/{id}")
    Mono<EmployeeDTO> getEmployee(@Path("id") String id);

    @GET("employee")
    Flux<EmployeeDTO []> getAllEmployee();

    @POST("employee")
    public Mono<EmployeeDTO> addEmployee(@Body EmployeeDTO employee);

    @PUT("employee")
    public Mono<EmployeeDTO> updateEmployee(@Body EmployeeDTO employee);

    @DELETE("employee/{id}")
    public Mono<Void> deleteEmployee(@Path("id") String id);



    }

