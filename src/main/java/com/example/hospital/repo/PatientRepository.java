package com.example.hospital.repo;

import java.util.List;

import com.example.hospital.bean.PatientRequestBean;

public interface PatientRepository {

	public void addPatient(PatientRequestBean bean);
	
	public List getAllPatient();
	
	public void updatePatient(int id, PatientRequestBean bean);
	
	public void deletePatient(int id);
}
