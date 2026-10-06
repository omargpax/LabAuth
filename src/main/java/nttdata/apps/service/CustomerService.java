package nttdata.apps.service;

import nttdata.apps.dto.CustomerRequest;
import nttdata.apps.dto.CustomerResponse;
import nttdata.apps.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> findAll();
    List<CustomerEntity> findByFirstName(String firstName);
    List<CustomerEntity> findByLastName(String lastName);
    CustomerResponse create(CustomerRequest customerRequest);
}
