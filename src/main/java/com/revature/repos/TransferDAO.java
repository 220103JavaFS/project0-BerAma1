package com.revature.repos;

import com.revature.models.Transfer;

import java.util.List;

public interface TransferDAO {
    List<Transfer> findAllTransfer();
    Transfer findTransferById(int id);
    boolean addTransfer(Transfer transfer);
    
}
