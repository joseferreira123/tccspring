package com.itb.inf2am.pizzaria.services;


import com.itb.inf2am.pizzaria.exceptions.BadRequest;
import com.itb.inf2am.pizzaria.exceptions.NotFound;
import com.itb.inf2am.pizzaria.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.itb.inf2am.pizzaria.model.Cliente;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public Cliente salvarCliente(Cliente cliente) {
        if (!cliente.validarCliente()) {
            throw new BadRequest(cliente.getMessage());
        }
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public boolean deletarCliente(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            throw new NotFound("Cliente não encontrado com o id " + id);
        }
    }

    @Override
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente listarClientePorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NotFound("Cliente não encontrado com o id " + id));
    }

    @Override
    @Transactional
    public Cliente atualizarCliente(Cliente cliente, Integer id) {
        if (!cliente.validarCliente()) {
            throw new BadRequest(cliente.getMessage());
        }

        Cliente clienteBd = clienteRepository.findById(id)
                .orElseThrow(() -> new NotFound("Cliente não encontrado com o id " + id));

        clienteBd.setNome(cliente.getNome());
        clienteBd.setSenha(cliente.getSenha());
        clienteBd.setEmail(cliente.getEmail());
        return clienteRepository.save(clienteBd); // Atualiza o cliente
    }
}
