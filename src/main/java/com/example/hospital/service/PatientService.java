package com.example.hospital.service;

import java.util.List;

import com.example.hospital.bean.PatientRequestBean;

public interface PatientService {

	public void addPatient(PatientRequestBean bean);

	public List getAllPatient();

	public void updatePatient(int id, PatientRequestBean bean);

	public void deletePatient(int id);
}
