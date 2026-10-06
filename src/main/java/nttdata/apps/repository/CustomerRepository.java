package nttdata.apps.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import nttdata.apps.entity.CustomerEntity;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CustomerRepository implements PanacheRepositoryBase<CustomerEntity, UUID> {
    public List<CustomerEntity> findByFirstName(String firstName) {
        return list("firstName", firstName);
    }
    public List<CustomerEntity> findByLastName(String lastName) {
        return list("lastName", lastName);
    }
}
