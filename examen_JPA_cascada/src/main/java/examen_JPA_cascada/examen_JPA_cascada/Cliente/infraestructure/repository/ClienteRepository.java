package examen_JPA_cascada.examen_JPA_cascada.Cliente.infraestructure.repository;

import examen_JPA_cascada.examen_JPA_cascada.Cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}