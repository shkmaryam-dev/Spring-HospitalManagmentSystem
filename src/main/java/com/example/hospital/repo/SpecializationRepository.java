package com.example.hospital.repo;

import java.util.List;
import java.util.Map;

public interface SpecializationRepository {
	public void insertSpecialization(String degree);
	
	public List getAllSpecialization();
	
	public void updateSpecialization(String oldDegree,String degree);
	
	public void deleteSpecialization(int id);
}
