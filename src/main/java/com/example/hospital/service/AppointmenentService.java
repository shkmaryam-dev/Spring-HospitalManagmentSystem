package com.example.hospital.service;

import java.util.List;

import com.example.hospital.bean.AppointmentRequestBean;

public interface AppointmenentService {

	public void addAppointment(AppointmentRequestBean appointment);
	
	public List getAllAppointment();
	
	public void updateAppointment(int id, AppointmentRequestBean bean);
	
	public void deleteAppointment(int id);
}
