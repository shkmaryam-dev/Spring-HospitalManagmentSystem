package com.example.hospital.service;

import java.util.List;

import com.example.hospital.bean.DoctorRequestBean;

public interface DoctorService {

	public void addDoctor(DoctorRequestBean doctor);
	
	public List getAllDoctor();
	
	public void updateDoctor(DoctorRequestBean doctor, int id);
	
	public void deleteDoctor(int id);
}
