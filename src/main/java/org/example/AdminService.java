package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface AdminService {
    List<Instructor> getPendingInstructors();
    List<Client> getPendingClient();
    Object getUserActivityReport();
    Map<Program, Integer> getProgramEnrollmentStatistics();
}
