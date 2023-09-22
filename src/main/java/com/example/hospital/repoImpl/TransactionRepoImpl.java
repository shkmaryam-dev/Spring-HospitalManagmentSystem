package com.example.hospital.repoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.hospital.bean.TransactionRequestBean;
import com.example.hospital.repo.TransactionReository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TransactionRepoImpl implements TransactionReository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addTransaction(TransactionRequestBean bean) {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append(" INSERT INTO transaction(patientId, appointmentId, amount) ");
        sqlQuery.append(" VALUES ( '");
        sqlQuery.append(bean.getPatientId()).append("','");
        sqlQuery.append(bean.getAppointmentId()).append("','");
        sqlQuery.append(bean.getAmount()).append("'");
        sqlQuery.append(" ) ");
        System.out.println("Add Transaction Query::"+sqlQuery.toString());
        jdbcTemplate.update(sqlQuery.toString());
    }

    @Override
    public List getAllTransaction() {
        String query = "SELECT * FROM transaction";
        return jdbcTemplate.queryForList(query);
    }

    @Override
    public void updateTransaction(int id, TransactionRequestBean bean) {
        String query = "UPDATE transaction SET patientId=?, amount=? WHERE transactionId=?";
        jdbcTemplate.update(query, bean.getPatientId(), bean.getAmount(), id);

    }

    @Override
    public void deleteTrasaction(int id) {
        // TODO Auto-generated method stub
        String query = "DELETE FROM transaction WHERE transactionId=?";
        jdbcTemplate.update(query, id);
    }

}
