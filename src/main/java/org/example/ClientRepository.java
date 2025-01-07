package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Repository class for managing clients.
 * Provides methods to add, update, and retrieve clients.
 * Author: Taqwa Odeh
 */
public class ClientRepository {

    private List<Client> clients = new ArrayList<>();

    /**
     * Adds a new client to the repository.
     *
     * @param client the client to be added.
     */
    public void addClient(Client client) {
        clients.add(client);
    }

    /**
     * Finds and returns a list of clients whose accounts are pending approval.
     *
     * @return a list of pending clients.
     */
    public List<Client> findPendingClients() {
        return clients.stream()
                .filter(client -> !client.isApproved())
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all clients in the repository.
     *
     * @return a copy of the list of all clients.
     */
    public Collection<Client> getAllClients() {
        return new ArrayList<>(clients); // to avoid modifying the original list, return a copy
    }

    /**
     * Updates the information of a client identified by their email.
     *
     * @param email       the email of the client to be updated.
     * @param newPassword the new password to set.
     * @param newName     the new name to set.
     * @return true if the client was updated successfully, false otherwise.
     */
    public boolean updateClient(String email, String newPassword, String newName) {
        Client client = findClientByEmail(email);
        if (client != null) {
            client.setPassword(newPassword);
            client.setName(newName);
            return true;
        }
        return false;
    }

    /**
     * Finds a client by their email.
     *
     * @param email the email of the client to find.
     * @return the client if found, or null if not found.
     */
    public Client findClientByEmail(String email) {
        for (Client client : clients) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }

    /**
     * Finds a client by their unique ID.
     *
     * @param id the ID of the client to find.
     * @return the client if found, or null if not found.
     */
    public Client findById(Long id) {
        return clients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}