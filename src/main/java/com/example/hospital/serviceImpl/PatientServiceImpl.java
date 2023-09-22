package com.example.hospital.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.bean.PatientRequestBean;
import com.example.hospital.repo.PatientRepository;
import com.example.hospital.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired 
	private PatientRepository patientRepository;

	@Override
	public void addPatient(PatientRequestBean bean) {
		// TODO Auto-generated method stub
		patientRepository.addPatient(bean);
	}

	@Override
	public List getAllPatient() {
		// TODO Auto-generated method stub
		return patientRepository.getAllPatient();
	}

	@Override
	public void updatePatient(int id, PatientRequestBean bean) {
		// TODO Auto-generated method stub
		patientRepository.updatePatient(id, bean);
	}

	@Override
	public void deletePatient(int id) {
		// TODO Auto-generated method stub
		patientRepository.deletePatient(id);
	}

}
