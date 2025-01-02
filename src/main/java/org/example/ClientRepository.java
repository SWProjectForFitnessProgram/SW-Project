package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ClientRepository {
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> findPendingClients() {
        return clients.stream()
                .filter(client -> !client.isApproved())
                .collect(Collectors.toList());
    }
    public Collection<Client> getAllClients() {
        return new ArrayList<>(clients); //to avoid playing with the real Array so we send a copy
    }

    public boolean updateClient(String email, String newPassword, String newName) {
        Client client  = findClientByEmail(email);
        if (client != null) {
            client.setPassword(newPassword);
            client.setName(newName);
            return true;
        }
        return false;
    }
    public Client findClientByEmail(String email) {
        for (Client client : clients) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }

    public Client findById(Long id) {
        return clients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
