package com.revature.repos;

import com.revature.models.Address;

import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl implements AddressDAO{

    @Override
    public List<Address> findAllAddress() {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  address;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Address> list=new ArrayList<>();
            while(result.next()){
                Address address = new Address();
                address.setAddress_Id(result.getInt("address_Id"));
                address.setStreet_Address(result.getString("street_Address"));
                address.setState(result.getString("state"));
                address.setCity(result.getString("city"));
                address.setZip_Code(result.getString("zip_Code"));
                list.add(address);
            }
            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Address findAddressById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM  address WHERE address_Id = "+id+" ;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
           Address address = new Address();

            while(result.next()){
                address.setAddress_Id(result.getInt("address_Id"));
                address.setStreet_Address(result.getString("street_Address"));
                address.setState(result.getString("state"));
                address.setCity(result.getString("city"));
                address.setZip_Code(result.getString("zip_Code"));
            }
            return address;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return new Address();
    }

    @Override
    public boolean updateAddress(Address address) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE address SET address_id = ?, street_address = ?, city = ?,   state = ?, zip_Code = ? " +
                    " WHERE address_id = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, address.getAddress_Id());
            statement.setString(++count, address.getStreet_Address());
            statement.setString(++count, address.getCity());
            statement.setString(++count, address.getState());
            statement.setString(++count, address.getZip_Code());
            statement.setInt(++count, address.getAddress_Id());

            statement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addAddress(Address address) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO address (address_id, address_street, city, state, zip_code) VALUES (?,?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            int count = 0;
            statement.setInt(++count, address.getAddress_Id());
            statement.setString(++count, address.getStreet_Address());
            statement.setString(++count, address.getCity());
            statement.setString(++count, address.getState());
            statement.setString(++count, address.getZip_Code());
            statement.execute();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAddress(int id) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "delete FROM  address WHERE address_Id = "+id+" ;";
            PreparedStatement statement = conn.prepareStatement(sql);
            Address address = new Address();

              // int count=0;
                //statement.setInt(++count, address.getAddress_Id());
                statement.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
