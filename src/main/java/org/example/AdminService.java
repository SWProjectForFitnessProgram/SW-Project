package org.example;

import java.util.List;

public interface AdminService {
    List<Instructor> getPendingInstructors();
    List<Client> getPendingClient();
    Object getUserActivityReport();
}
