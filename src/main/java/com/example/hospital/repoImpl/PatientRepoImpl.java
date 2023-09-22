package com.example.hospital.repoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.hospital.bean.PatientRequestBean;
import com.example.hospital.repo.PatientRepository;

@Repository
public class PatientRepoImpl implements PatientRepository{
	
	@Autowired(required =  true)
	JdbcTemplate jdbcTemplate;

	@Override
	public void addPatient(PatientRequestBean bean) {
		String query = "INSERT INTO patient(doctorId,name,age,gender,phoneNumber,address,description,deases,aadharCardNumber,mailId) VALUES(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query,bean.getDoctorId(), bean.getName(), bean.getAge(), bean.getGender(), bean.getPhoneNumber(),bean.getAddress(),bean.getDescription(), bean.getDeases(), bean.getAadharCardNumber(), bean.getMailId());
	}

	@Override
	public List getAllPatient() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT * FROM patient");
		return jdbcTemplate.queryForList(query.toString());
	}

	@Override
	public void updatePatient(int id, PatientRequestBean bean) {
		String query = "UPDATE patient SET doctorId=?,name=?,age=?,gender=?,phoneNumber=?,address=?,description=?,deases=?,aadharCardNumber=?,mailId=? WHERE patientId=?";
		jdbcTemplate.update(query,bean.getDoctorId(), bean.getName(), bean.getAge(), bean.getGender(), bean.getPhoneNumber(),bean.getAddress(),bean.getDescription(), bean.getDeases(), bean.getAadharCardNumber(), bean.getMailId(),id);
	}

	@Override
	public void deletePatient(int id) {
		String query = "DELETE FROM patient WHERE patientId=?";
		jdbcTemplate.update(query, id);
	}

}
