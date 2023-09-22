package com.example.hospital.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.bean.AppointmentRequestBean;
import com.example.hospital.repo.AppointmentRepository;
import com.example.hospital.service.AppointmenentService;

@Service
public class AppointmentSerivceImpl  implements AppointmenentService{

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public void addAppointment(AppointmentRequestBean appointment) {
		// TODO Auto-generated method stub
		appointmentRepository.addAppointment(appointment);
	}

	@Override
	public List getAllAppointment() {
		// TODO Auto-generated method stub
		return appointmentRepository.getAllAppointment();
	}

	@Override
	public void updateAppointment(int id, AppointmentRequestBean bean) {
		// TODO Auto-generated method stub
		appointmentRepository.updateAppointment(id, bean);
	}

	@Override
	public void deleteAppointment(int id) {
		// TODO Auto-generated method stub
		appointmentRepository.deleteAppointment(id);
	}
}
