package nttdata.apps.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import nttdata.apps.dto.CustomerRequest;
import nttdata.apps.dto.CustomerResponse;
import nttdata.apps.entity.CustomerEntity;
import nttdata.apps.repository.CustomerRepository;
import nttdata.apps.service.CustomerService;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;

    @Inject
    public CustomerServiceImpl(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<CustomerResponse> findAll() {
        return repo.findAll().
                stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public List<CustomerEntity> findByFirstName(String firstName) {
        return repo.findByFirstName(firstName);
    }

    @Override
    public List<CustomerEntity> findByLastName(String lastName) {
        return repo.findByLastName(lastName);
    }

    @Override
    @Transactional
    public CustomerResponse create(CustomerRequest customerRequest) {
        var entity = this.toEntity(customerRequest);
        repo.persist(entity);
        return this.toResponse(entity);
    }


    //Map-structure
    CustomerResponse toResponse(CustomerEntity entity) {
        return new CustomerResponse(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getBirthDate(), entity.getCreatedAt());
    }

    CustomerEntity toEntity(CustomerRequest request){
        return  new CustomerEntity(null,request.firstName(),request.lastName(),request.brithDate(), LocalDateTime.now());
    }
}
