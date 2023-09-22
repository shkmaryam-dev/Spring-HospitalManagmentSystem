package com.example.hospital.repoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.hospital.bean.NurseRequestBean;
import com.example.hospital.repo.NurseReository;

@Repository
public class NurseRepoImpl implements NurseReository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void addNurse(NurseRequestBean nurse) {
		String query = "INSERT INTO nurse(nurseName, doctorId, age, gender, phoneNumber, emailId, address, position, isActive, experiance, description)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query,nurse.getNurseName(),nurse.getDoctorId(),nurse.getAge(),nurse.getGender(),nurse.getPhoneNumber(),nurse.getEmailId(),nurse.getAddress(),nurse.getPosition(),nurse.getIsActive(),nurse.getExperiance(),nurse.getDescription());	
	}

	@Override
	public List getAllNurse() {
		StringBuilder query = new  StringBuilder();
		query.append("SELECT * FROM nurse");
		return jdbcTemplate.queryForList(query.toString());
	}

	@Override
	public void updateNurse(int id, NurseRequestBean nurse) {
		String query = "UPDATE nurse SET nurseName=?, doctorId=?, age=?, gender=?, phoneNumber=?, emailId=?, address=?, position=?, isActive=?, experiance=?, description=? WHERE nurseId=?";
		jdbcTemplate.update(query,nurse.getNurseName(),nurse.getDoctorId(),nurse.getAge(),nurse.getGender(),nurse.getPhoneNumber(),nurse.getEmailId(),nurse.getAddress(),nurse.getPosition(),nurse.getIsActive(),nurse.getExperiance(),nurse.getDescription(),id);		
	}

	@Override
	public void deleteNurse(int id) {
		String query = "DELETE FROM nurse WHERE nurseId=?";
		jdbcTemplate.update(query,id);
	}

}
