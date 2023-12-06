package br.com.fatec.cadastrocliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.cadastrocliente.entities.Client;
import br.com.fatec.cadastrocliente.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;

    public List<Client> getClientes(){
        return repository.findAll();
    }

    public Client getClientById(int id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Cliente não existe")
        );
    }

    public void deleteClientById(int id){
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Cliente não existe");
        }
    }

    public Client save(Client client) {
        return this.repository.save(client);
    }

    public void update(int id, Client client) {
    
        try{
            Client aux = repository.getReferenceById(id);
            aux.setName(client.getName());
            aux.setEmail(client.getEmail());
            aux.setTelefone(client.getTelefone());
            aux.setEndereço(client.getEndereço());
            aux.setCidade(client.getCidade());
            aux.setCep(client.getCep());
            aux.setEstado(client.getEstado());
            this.repository.save(aux);
        }
        catch(EntityNotFoundException e)
        {
            throw new EntityNotFoundException("Cliente não cadastrado");
        }
        catch(Exception e)
        {
            throw new EntityNotFoundException("Nao sei qual é o erro!");
        }
        

    }

}
