package com.example.hospital.service;

import java.util.List;

import com.example.hospital.bean.TransactionRequestBean;

public interface TransactionService {
	
	public void addTransaction(TransactionRequestBean bean);

	public List getAllTransaction();

	public void updateTransaction(int id, TransactionRequestBean bean);

	public void deleteTrasaction(int id);
}
