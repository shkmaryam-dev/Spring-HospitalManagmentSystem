package com.example.hospital.repo;

import java.util.List;

import com.example.hospital.bean.TransactionRequestBean;

public interface TransactionReository {

	public void addTransaction(TransactionRequestBean bean);
	
	public List getAllTransaction();
	
	public void updateTransaction(int id , TransactionRequestBean bean);
	
	public void deleteTrasaction(int id);
}
