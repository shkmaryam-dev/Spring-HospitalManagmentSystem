package com.example.hospital.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.repo.SpecializationRepository;
import com.example.hospital.service.SpecializationService;

@Service
public class SpecializationServiceImpl implements SpecializationService {

	@Autowired
	private SpecializationRepository repository;

	@Override
	public void insertSpecialization(String degree) {
		repository.insertSpecialization(degree);
	}

	@Override
	public List getAllSpecialization() {
		// TODO Auto-generated method stub
		return repository.getAllSpecialization();
	}

	@Override
	public void updateSpecialization(String newDegree , String oldDegree) {
		// TODO Auto-generated method stub
		repository.updateSpecialization(newDegree, oldDegree);
	}

	@Override
	public void deleteSpecialization(int id) {
		// TODO Auto-generated method stub
		repository.deleteSpecialization(id);
	}
}
