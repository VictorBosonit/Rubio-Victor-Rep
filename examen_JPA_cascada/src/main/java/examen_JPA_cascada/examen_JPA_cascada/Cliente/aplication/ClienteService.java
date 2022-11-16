package examen_JPA_cascada.examen_JPA_cascada.Cliente.aplication;

import examen_JPA_cascada.examen_JPA_cascada.Cliente.domain.Cliente;
import examen_JPA_cascada.examen_JPA_cascada.Cliente.infraestructure.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements  ClienteSrviceInt{

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Cliente addCliente(Cliente cliente) {

        clienteRepository.save(cliente);

        return cliente;
    }
}
