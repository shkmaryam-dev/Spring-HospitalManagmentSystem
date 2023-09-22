package com.example.hospital.repoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.hospital.bean.DoctorRequestBean;
import com.example.hospital.repo.DoctorRepository;

@Repository
public class DoctorRepoImpl implements DoctorRepository{
	
	@Autowired(required = true)
	JdbcTemplate jdbcTemplate;

	@Override
	public void addDoctor(DoctorRequestBean doctor) {
		String query = "INSERT INTO doctor(doctorName,age,emailId,phoneNumber,specializationId,description) VALUES(?,?,?,?,?,?)";
		jdbcTemplate.update(query, doctor.getDoctorName(), doctor.getAge(), doctor.getEmail(), doctor.getPhoneNumber(),doctor.getSpecializationId(),doctor.getDescription());
	}

	@Override
	public List getAllDoctor() {
		StringBuilder  query= new StringBuilder();
		query.append("SELECT * FROM doctor");
		return jdbcTemplate.queryForList(query.toString());
		
	}

	@Override
	public void updateDoctor(DoctorRequestBean doctor, int id) {
		// TODO Auto-generated method stub
				String query = "UPDATE doctor SET doctorName = ?, age=?,emailId=?, phoneNumber=?, specializationId=?, description=? where doctorId=?";
				jdbcTemplate.update(query, doctor.getDoctorName(), doctor.getAge(), doctor.getEmail(), doctor.getPhoneNumber(),doctor.getSpecializationId(),doctor.getDescription(),id);
	}

	@Override
	public void DeleteDoctor(int id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM doctor WHERE doctorId=?";
		jdbcTemplate.update(query, id);
		
	}
}
