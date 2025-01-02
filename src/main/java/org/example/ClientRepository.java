package org.example;

import java.util.ArrayList;
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

    public Client findById(Long id) {
        return clients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
