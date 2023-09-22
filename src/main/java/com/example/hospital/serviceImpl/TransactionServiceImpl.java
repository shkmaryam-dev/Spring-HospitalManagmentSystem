package com.example.hospital.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.bean.TransactionRequestBean;
import com.example.hospital.repo.TransactionReository;
import com.example.hospital.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionReository reository;

	@Override
	public void addTransaction(TransactionRequestBean bean) {
		// TODO Auto-generated method stub
		reository.addTransaction(bean);
	}

	@Override
	public List getAllTransaction() {
		// TODO Auto-generated method stub
		return reository.getAllTransaction();
	}

	@Override
	public void updateTransaction(int id, TransactionRequestBean bean) {
		// TODO Auto-generated method stub
		reository.updateTransaction(id, bean);
	}

	@Override
	public void deleteTrasaction(int id) {
		// TODO Auto-generated method stub
		reository.deleteTrasaction(id);
	}
	
}
