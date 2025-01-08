package org.example;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface AdminService {
    //1
    List<Instructor> getPendingInstructors();
    List<Client> getPendingClients();



    InstructorRepository getInstructorRepository();

    Collection<Client> getClients();

    ClientRepository getClientsRepository();


    void addArticle(Article article);

    void approveArticle(Article article);

    void rejectRecipe(Recipe recipe);

    void addComplaint(Complaint complaint);

    void addTip(HealthTip tip);

    void approveTip(HealthTip tip);

    void resolveComplaint(Complaint complaint);

    void addRecipe(Recipe recipe);

    void rejectArticle(Article article);

    Collection<Instructor> getInstructors();
}
