package com.example.hospital.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.bean.NurseRequestBean;
import com.example.hospital.repo.NurseReository;
import com.example.hospital.service.NurseService;

@Service
public class NurseServiceImpl implements NurseService{
	@Autowired
	private NurseReository nurseReository;

	@Override
	public void addNurse(NurseRequestBean nurse) {
		nurseReository.addNurse(nurse);
	}

	@Override
	public List getAllNurse() {
		return nurseReository.getAllNurse();
	}

	@Override
	public void updateNurse(int id, NurseRequestBean nurse) {
		nurseReository.updateNurse(id, nurse);
	}

	@Override
	public void deleteNurse(int id) {
		nurseReository.deleteNurse(id);
	}

}
