package com.revature.repos;

import com.revature.models.Withdraw;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WithdrawDAOImpl implements WithdrawDAO{
    @Override
    public List<Withdraw> findAllWithdraw() {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  withdraw;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Withdraw> list=new ArrayList<>();
            while(result.next()){
                Withdraw withdraw = new Withdraw();
                withdraw.setWithdraw_Id(result.getInt("withdraw_Id"));
                withdraw.setWithdraw_Id(result.getInt("withdrawer_Id"));
                withdraw.setWithdrawer_Account(result.getInt("withdrawer_account"));
                withdraw.setWithdraw_Amount(result.getDouble("Withdraw_Amount"));
                withdraw.setWithdraw_date(result.getString("withdraw_Date"));
                list.add(withdraw);
            }
            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Withdraw findWithdrawById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  withdraw WHERE withdraw_Id = "+id+" ;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Withdraw withdraw = new Withdraw();

            while(result.next()){
                withdraw.setWithdraw_Id(result.getInt("withdraw_Id"));
                withdraw.setWithdraw_Id(result.getInt("withdrawer_Id"));
                withdraw.setWithdrawer_Account(result.getInt("withdrawer_account"));
                withdraw.setWithdraw_Amount(result.getDouble("Withdraw_Amount"));
                withdraw.setWithdraw_date(result.getString("withdraw_Date"));
            }
            return withdraw;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new Withdraw();
    }


    @Override
    public boolean addWithdraw(Withdraw withdraw) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO  withdraw  (withdraw_Id, withdrawer_id, withdrawer_account, withdrawer_account, withdraw_amount) VALUES (?,?,?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, withdraw.getWithdraw_Id());
            statement.setInt(++count, withdraw.getWithdrawer_Id());
            statement.setInt(++count, withdraw.getWithdrawer_Account());
            statement.setInt(++count, withdraw.getWithdrawer_Account());
            statement.setDouble(++count, withdraw.getWithdraw_Amount());

            //statement.setString(++count, withdraw.getWithdraw_Date()); // make it default current date
//line start

            int withdrawer=withdraw.getWithdrawer_Account();

            double amt=withdraw.getWithdraw_Amount();




            String sqlWithdraw = "SELECT * FROM  account WHERE account_id = "+ withdraw+" ;";
            Statement st = conn.createStatement();
            ResultSet r = st.executeQuery(sqlWithdraw);
            double originalAmtSender=0;
            while (r.next()) {
                originalAmtSender = r.getDouble("act_balance");
                //statusSender=r.getString("act_status");
            }

            double totalRemain=originalAmtSender-amt;
            if(totalRemain<0)
            {
                return false;
            }
            else {
                String sqlWithdrawUpdate = "UPDATE account SET act_balance=" + totalRemain + " WHERE account_Id = " + withdraw + " ;";
                PreparedStatement st2 = conn.prepareStatement(sqlWithdrawUpdate);
                st2.execute();
            }
            //line end
            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
