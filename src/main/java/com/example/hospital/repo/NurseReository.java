package com.example.hospital.repo;

import java.util.List;

import com.example.hospital.bean.NurseRequestBean;

public interface NurseReository {

	public void addNurse(NurseRequestBean nurse);
	
	public List getAllNurse();
	
	public void updateNurse(int id , NurseRequestBean nurse);
	
	public void deleteNurse(int id);
}
