package com.example.DemoConsumer.resource;

import com.example.DemoConsumer.client.EmployeeClient;
import com.example.DemoConsumer.model.EmployeeDTO;
import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import org.springframework.core.ReactiveAdapter;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import retrofit2.CallAdapter;
import retrofit2.CallAdapter.Factory;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import java.util.List;

@RestController
@RequestMapping("/consumer/employee")
public class EmployeeController {
    private EmployeeClient empClient;

    public EmployeeController() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(ReactorCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://localhost:8080/")
                .build();
        empClient = retrofit.create(EmployeeClient.class);
    }

    @GetMapping("/{id}")
    public Mono<EmployeeDTO> getEmployee(@PathVariable String id) {
        return empClient.getEmployee(id);

    }
    @GetMapping
    public Flux<EmployeeDTO []> getAllEmployee() {
        return empClient.getAllEmployee();
    }
    @PostMapping
    public Mono<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employee) {
        return empClient.addEmployee(employee);
    }

    @PutMapping
    public Mono<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employee) {
        return empClient.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteEmployee(@PathVariable String id) {
       return empClient.deleteEmployee(id);

    }
}
