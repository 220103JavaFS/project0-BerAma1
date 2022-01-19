package com.revature.repos;

import com.revature.models.Transfer;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransferDAOImpl implements TransferDAO{

    @Override
    public List<Transfer> findAllTransfer() {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  transfer;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Transfer> list=new ArrayList<>();
            while(result.next()){
                Transfer transfer = new Transfer();
                transfer.setTransfer_Id(result.getInt("transfer_Id"));
                transfer.setSender_Id(result.getInt("sender_Id"));
                transfer.setSender_Account(result.getInt("sender_account"));

                transfer.setReceiver_Id(result.getInt("receiver_Id"));
                transfer.setReceiver_Account(result.getInt("receiver_account"));
                transfer.setTransfer_Amount(result.getDouble("transfer_Amount"));
                transfer.setTransfer_date(result.getString("transfer_Date"));
                list.add(transfer);
            }
            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Transfer findTransferById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  transfer WHERE transfer_Id = "+id+" ;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Transfer transfer = new Transfer();

            while(result.next()){
                transfer.setTransfer_Id(result.getInt("transfer_Id"));
                transfer.setSender_Id(result.getInt("sender_Id"));
                transfer.setSender_Account(result.getInt("sender_account"));
                transfer.setReceiver_Id(result.getInt("receiver_Id"));
                transfer.setReceiver_Account(result.getInt("receiver_account"));
                transfer.setTransfer_Amount(result.getDouble("transfer_Amount"));
                transfer.setTransfer_date(result.getString("transfer_Date"));

            }
            return transfer;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new Transfer();
    }


    @Override
    public boolean addTransfer(Transfer transfer) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO  transfer  (transfer_Id, sender_id, sender_account, receiver_id, receiver_account, transfer_amount) VALUES (?,?,?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, transfer.getTransfer_Id());
            statement.setInt(++count, transfer.getSender_Id());
            statement.setInt(++count, transfer.getSender_Account());
            statement.setInt(++count, transfer.getReceiver_Id());
            statement.setInt(++count, transfer.getReceiver_Account());
            statement.setDouble(++count, transfer.getTransfer_Amount());

            //statement.setString(++count, transfer.getTransfer_Date()); // make it default current date
//line start

            int receiver=transfer.getReceiver_Account();
            int sender=transfer.getSender_Account();
            double amt=transfer.getTransfer_Amount();

            String sqlDeposit = "SELECT * FROM  account WHERE account_id = "+receiver +" ;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlDeposit);
            double originalAmt=0;
            while (rs.next()) {
                originalAmt = rs.getDouble("act_balance");
               // statusReceiver=rs.getString("act_status");
            }


            String sqlTransfer = "SELECT * FROM  account WHERE account_id = "+sender +" ;";
            Statement st = conn.createStatement();
            ResultSet r = st.executeQuery(sqlTransfer);
            double originalAmtSender=0;
            while (r.next()) {
                originalAmtSender = r.getDouble("act_balance");
                //statusSender=r.getString("act_status");
            }

            double total=amt+originalAmt;
            double totalRemain=originalAmtSender-amt;
  if(totalRemain<0)
  {
      return false;
  }
    else {
      String sqlDepositUpdate = "UPDATE account SET act_balance=" + total + " WHERE account_Id = " + receiver + " ;";
      PreparedStatement stmt2 = conn.prepareStatement(sqlDepositUpdate);
      stmt2.execute();

      String sqlTransferUpdate = "UPDATE account SET act_balance=" + totalRemain + " WHERE account_Id = " + sender + " ;";
      PreparedStatement st2 = conn.prepareStatement(sqlTransferUpdate);
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
