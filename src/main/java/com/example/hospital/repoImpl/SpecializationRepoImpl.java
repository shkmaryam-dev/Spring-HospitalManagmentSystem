package com.example.hospital.repoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.hospital.repo.SpecializationRepository;

@Repository
public class SpecializationRepoImpl implements SpecializationRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void insertSpecialization(String degree) {
		String query = "INSERT INTO specialization(degree) VALUES(?)";
		jdbcTemplate.update(query, degree);
	}

	@Override
	public List getAllSpecialization() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT * FROM specialization");
		return jdbcTemplate.queryForList(query.toString());
	}

	@Override
	public void updateSpecialization(String newDegree , String oldDegree) {
		String query = "UPDATE specialization SET degree = ? WHERE  degree = ?";
		jdbcTemplate.update(query,newDegree,oldDegree);
	}

	@Override
	public void deleteSpecialization(int id) {
		String query = "DELETE FROM specialization WHERE spId = ?";
		jdbcTemplate.update(query,id);
	}
}
