package com.example.hospital.service;

import java.util.List;

import com.example.hospital.bean.NurseRequestBean;

public interface NurseService {

	public void addNurse(NurseRequestBean nurse);

	public List getAllNurse();

	public void updateNurse(int id, NurseRequestBean nurse);

	public void deleteNurse(int id);
}
