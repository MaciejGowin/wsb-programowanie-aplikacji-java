package pl.wsb.programowaniejava.maciejgowin.przyklad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.Customer;

import java.util.List;

@Repository
public interface CustomerCrudRepository extends JpaRepository<Customer, Integer> {

    @Query("FROM Customer ORDER BY firstName")
    List<Customer> findAllOrderByFirstName();

    @Query("FROM Customer ORDER BY lastName")
    List<Customer> findAllOrderByLastName();

    @Query("FROM Customer ORDER BY id")
    List<Customer> findAllOrderById();

    @Query("FROM Customer WHERE lastName = :lastName")
    List<Customer> findAllByLastName(@Param("lastName") String lastName);
}
