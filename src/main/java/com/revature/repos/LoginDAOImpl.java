package com.revature.repos;

import com.revature.models.Login;
import com.revature.utils.ConnectionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class LoginDAOImpl implements LoginDAO{
    HttpServletRequest request;


    @Override
    public boolean checkAll(Login login) {
        try(Connection conn = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE login SET user_id=?, username = ?, password = ?, user_role=?" +
                    "WHERE user_id = ?; ";
            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setInt(++count, login.getUser_Id());
            statement.setString(++count, login.getUsername());
            statement.setString(++count, login.getPassword());
            statement.setString(++count, login.getUser_Role());
            statement.setInt(++count, login.getUser_Id());

      String user=login.getUsername();
      int id=login.getUser_Id();

            String sqlDeposit = "SELECT * FROM  login where user_id="+id+ ";";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlDeposit);
            if(!(rs.next())) {
              return  false;
            }

            statement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<Login> findAllLogin() {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  login;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Login> list=new ArrayList<>();
            while(result.next()){
                Login login = new Login();
                login.setUser_Id(result.getInt("user_Id"));
                login.setUsername(result.getString("username"));
                login.setPassword(result.getString("password"));
                login.setUser_Role(result.getString("user_Role"));
                list.add(login);
            }
            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Login findLoginById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  login user_id="+ id +" ;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Login login = new Login();

            while(result.next()){
                login.setUser_Id(result.getInt("user_Id"));
                login.setUsername(result.getString("username"));
                login.setPassword(result.getString("password"));
                login.setUser_Role(result.getString("user_Role"));

            }
            return login;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new Login();
    }

    @Override
    public boolean updateLogin(Login login) {
        try(Connection conn = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE login SET user_id=?, username = ?, password = ?, user_role=?" +
                    "WHERE user_id = ?; ";
            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, login.getUser_Id());
            statement.setString(++count, login.getUsername());
            statement.setString(++count, login.getPassword());
            statement.setString(++count, login.getUser_Role());
            statement.setInt(++count, login.getUser_Id());
            statement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addLogin(Login Login)  {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO  login  (user_Id,  username, password, user_Role) VALUES (?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, Login.getUser_Id());
            statement.setString(++count, Login.getUsername());
/*
     String password= Login.getPassword();
String encryptedpassword=null;

            MessageDigest m = null;
            try {
                m = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            m.update(password.getBytes());

            byte[] bytes = m.digest();

            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            encryptedpassword = s.toString();
*/
            statement.setString(++count, Login.getPassword());

            statement.setString(++count, Login.getUser_Role());
            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteLogin(int id) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "delete FROM  login WHERE user_Id = "+id+" ;";
            PreparedStatement statement = conn.prepareStatement(sql);

           //  Login login = new Login();


            //--int count=0;
            //statement.setInt(++count, Login.getLogin_Id());
            statement.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }


    public boolean customer(boolean login)
    {
        return false;
    }
    public boolean manager(boolean login)
    {
        return false;
    }
    public boolean employee( boolean login)
    {
        return false;
    }

}
