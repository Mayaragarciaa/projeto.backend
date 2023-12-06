package br.com.fatec.cadastrocliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.cadastrocliente.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    
}
