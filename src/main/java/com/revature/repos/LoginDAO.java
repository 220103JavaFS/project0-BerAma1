package com.revature.repos;
import com.revature.models.Login;
import java.util.List;
public interface LoginDAO {
    List<Login> findAllLogin();
    Login findLoginById(int id);
    boolean updateLogin(Login login);
    boolean checkAll(Login login);
    boolean addLogin(Login login);
    boolean deleteLogin(int id);
    /*boolean customer(Login login);
    boolean employee(Login login);
    boolean manager(Login login);
     */
    
}
