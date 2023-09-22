package com.example.hospital.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.bean.AppointmentRequestBean;
import com.example.hospital.service.AppointmenentService;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {

	@Autowired
	private AppointmenentService appointmenentService;
	
	@PostMapping("/add")
    public ResponseEntity<AppointmentRequestBean> addAppointment(@RequestBody AppointmentRequestBean bean) {
		appointmenentService.addAppointment(bean);
		return ResponseEntity.ok().body(bean);
    }
	
	@GetMapping("/getAll")
	public ResponseEntity<List<AppointmentRequestBean>> getAllAppointments(){
		return ResponseEntity.ok(appointmenentService.getAllAppointment());
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateAppointment(@PathParam(value = "id") int id,@RequestBody AppointmentRequestBean bean){
		appointmenentService.updateAppointment(id,bean);
		return new ResponseEntity<>("Appointment Updated successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> DeleteAppointment(@PathParam(value = "id") int id){
		appointmenentService.deleteAppointment(id);
		return new ResponseEntity<>("Appointment Deleted successfully", HttpStatus.OK);
	}
}
