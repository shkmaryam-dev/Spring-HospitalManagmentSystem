package com.example.hospital.repo;

import java.util.List;

import com.example.hospital.bean.DoctorRequestBean;

public interface DoctorRepository {

	public void addDoctor(DoctorRequestBean doctor);
	
	public List getAllDoctor();
	
	public void updateDoctor(DoctorRequestBean doctor, int id);
	
	public void DeleteDoctor(int id);
}
