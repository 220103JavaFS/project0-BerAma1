package com.revature.repos;

import com.revature.models.Account;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public List<Account> findAllAccount() {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  account;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Account> list=new ArrayList<>();
            while(result.next()){
                Account account = new Account();
                account.setAccount_Id(result.getInt("account_Id"));
                account.setAct_Balance(result.getDouble("act_Balance"));
                account.setAcct_Type(result.getString("acct_Type"));
                account.setOpen_Date(result.getString("open_Date"));
                account.setInterest_Rate(result.getDouble("interest_Rate"));
                account.setAct_Status(result.getString("act_Status"));
                list.add(account);
            }
            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Account findAccountById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  account WHERE account_Id = "+id+" ;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Account account = new Account();

            while(result.next()){
                account.setAccount_Id(result.getInt("account_Id"));
                account.setAct_Balance(result.getDouble("act_Balance"));
                account.setAcct_Type(result.getString("acct_Type"));
                account.setOpen_Date(result.getString("open_Date"));
                account.setInterest_Rate(result.getDouble("interest_Rate"));
                account.setAct_Status(result.getString("act_Status"));

            }
            return account;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new Account();
    }

    @Override
    public boolean updateAccount(Account account) {
        try(Connection conn = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE account SET account_id = ?, acct_type = ?, act_balance = ?,   act_status = ?, interest_rate = ?" +
                    "WHERE account_id = ?; ";
            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
             statement.setInt(++count, account.getAccount_Id());
            statement.setString(++count, account.getAcct_Type());
          statement.setDouble(++count, account.getAct_Balance());
           statement.setString(++count, account.getAct_Status());
            //statement.setString(++count, account.getOpen_Date()); // default date
            statement.setDouble(++count,account.getInterest_Rate());
            statement.setInt(++count, account.getAccount_Id());
            statement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addAccount(Account account)  {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO  account  (account_Id, acct_type, act_balance, act_status, interest_rate) VALUES (?,?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, account.getAccount_Id());
            statement.setString(++count, account.getAcct_Type());
            statement.setDouble(++count, account.getAct_Balance());
            statement.setString(++count, account.getAct_Status());
            //statement.setString(++count, account.getOpen_Date()); // make it default current date
            statement.setDouble(++count,account.getInterest_Rate());
            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAccount(int id) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "delete FROM  account WHERE account_Id = "+id+" ;";
            PreparedStatement statement = conn.prepareStatement(sql);
            Account account = new Account();


            //--int count=0;
            //statement.setInt(++count, account.getAccount_Id());
            statement.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}

