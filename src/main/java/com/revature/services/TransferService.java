package com.revature.services;

import com.revature.models.Transfer;
import com.revature.repos.TransferDAO;
import com.revature.repos.TransferDAOImpl;

import java.util.List;

public class TransferService {
    private TransferDAO transferDAO = new TransferDAOImpl();
    public List<Transfer> findAllTransfer(){
        return transferDAO.findAllTransfer(); }

    public Transfer findTransferById(int id){

        return transferDAO.findTransferById(id);
    }
    public boolean addTransfer(Transfer transfer){

        return transferDAO.addTransfer(transfer);
    }

}
