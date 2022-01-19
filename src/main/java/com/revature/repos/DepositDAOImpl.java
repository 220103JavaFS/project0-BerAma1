package com.revature.repos;

import com.revature.models.Deposit;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepositDAOImpl implements DepositDAO{


    @Override
    public List<Deposit> findAllDeposit() {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  deposit;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Deposit> list=new ArrayList<>();
            while(result.next()){
                Deposit deposit = new Deposit();
                deposit.setDeposit_Id(result.getInt("deposit_Id"));
                deposit.setSender_Id(result.getInt("sender_Id"));
                deposit.setSender_Account(result.getInt("sender_account"));

                deposit.setReceiver_Id(result.getInt("receiver_Id"));
                deposit.setReceiver_Account(result.getInt("receiver_account"));
                deposit.setDeposit_Amount(result.getDouble("deposit_Amount"));
                deposit.setDeposit_date(result.getString("deposit_Date"));
                list.add(deposit);
            }
            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Deposit findDepositById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  deposit WHERE deposit_Id = "+id+" ;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Deposit deposit = new Deposit();

            while(result.next()){
                deposit.setDeposit_Id(result.getInt("deposit_Id"));
                deposit.setSender_Id(result.getInt("sender_Id"));
                deposit.setSender_Account(result.getInt("sender_account"));
                deposit.setReceiver_Id(result.getInt("receiver_Id"));
                deposit.setReceiver_Account(result.getInt("receiver_account"));
                deposit.setDeposit_Amount(result.getDouble("deposit_Amount"));
                deposit.setDeposit_date(result.getString("deposit_Date"));
                //line start

                int receiver=result.getInt("receiver_account");
                double amt=result.getDouble("deposit_amount");
                String sqlDeposit = "SELECT * FROM  account WHERE account_id = "+receiver +" ;";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sqlDeposit);
                double originalAmt=rs.getDouble("act_balance");

                double total=amt+originalAmt;

                String sqlDepositUpdate = "UPDATE account SET act_balance="+ total +" WHERE account_Id = "+receiver+" ;";
                PreparedStatement stmt2 = conn.prepareStatement(sqlDepositUpdate);
                stmt2.execute();
                //line end




            }
            return deposit;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new Deposit();
    }


    @Override
    public boolean addDeposit(Deposit deposit) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO  Deposit  (deposit_Id, sender_id, sender_account, receiver_id, receiver_account, deposit_amount) VALUES (?,?,?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, deposit.getDeposit_Id());
            statement.setInt(++count, deposit.getSender_Id());
            statement.setInt(++count, deposit.getSender_Account());
            statement.setInt(++count, deposit.getReceiver_Id());
            statement.setInt(++count, deposit.getReceiver_Account());
            statement.setDouble(++count, deposit.getDeposit_Amount());

            //statement.setString(++count, deposit.getDeposit_Date()); // make it default current date
//line start

            int receiver=deposit.getReceiver_Account();
            double amt=deposit.getDeposit_Amount();
            String sqlDeposit = "SELECT * FROM  account WHERE account_id = "+receiver +" ;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlDeposit);
            double originalAmt=0;
            while (rs.next()) {
                originalAmt = rs.getDouble("act_balance");
            }
            double total=amt+originalAmt;

            String sqlDepositUpdate = "UPDATE account SET act_balance="+ total +" WHERE account_Id = "+receiver+" ;";
            PreparedStatement stmt2 = conn.prepareStatement(sqlDepositUpdate);
            stmt2.execute();
            //line end
            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
