package com.example.hospital.service;

import java.util.List;
import java.util.Map;

public interface SpecializationService {
	
	public void insertSpecialization(String degree);
	public List getAllSpecialization();
	public void updateSpecialization(String newDegree , String oldDegree); 
	public void deleteSpecialization(int id);
}
