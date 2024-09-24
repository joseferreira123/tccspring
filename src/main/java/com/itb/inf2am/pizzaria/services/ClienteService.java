package com.itb.inf2am.pizzaria.services;


import com.itb.inf2am.pizzaria.model.Cliente;

import java.util.List;

public interface ClienteService {

    public Cliente salvarCliente(Cliente cliente);
    public boolean deletarCliente(Integer id);
    public List<Cliente> listarTodosClientes();
    public Cliente listarClientePorId(Integer id);
    public Cliente atualizarCliente(Cliente cliente, Integer id);


}
