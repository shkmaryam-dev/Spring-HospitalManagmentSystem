package com.example.hospital.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.bean.DoctorRequestBean;
import com.example.hospital.repo.DoctorRepository;
import com.example.hospital.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired(required = true)
	private DoctorRepository doctorRepository;
	
	@Override
	public void addDoctor(DoctorRequestBean doctor) {
		System.out.println(doctor);
		doctorRepository.addDoctor(doctor);
	}

	@Override
	public List getAllDoctor() {
		return doctorRepository.getAllDoctor();
	}

	@Override
	public void updateDoctor(DoctorRequestBean doctor, int id) {
		// TODO Auto-generated method stub
		doctorRepository.updateDoctor(doctor, id);
	}

	@Override
	public void deleteDoctor(int id) {
		// TODO Auto-generated method stub
		doctorRepository.DeleteDoctor(id);
		
	}

}
