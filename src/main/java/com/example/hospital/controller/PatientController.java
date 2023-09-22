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

import com.example.hospital.bean.DoctorRequestBean;
import com.example.hospital.bean.PatientRequestBean;
import com.example.hospital.service.PatientService;

@RestController
@RequestMapping("/Patient")
public class PatientController {

	@Autowired
	private PatientService  patientService;
	
	@PostMapping("/add")
    public ResponseEntity<PatientRequestBean> addPatient(@RequestBody PatientRequestBean bean) {
		patientService.addPatient(bean);
		return ResponseEntity.ok().body(bean);
    }
	
	@GetMapping("/getAll")
	public ResponseEntity<List> getAllPatient(){
		return ResponseEntity.ok(patientService.getAllPatient());
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updatePatient(@PathParam(value = "id") int id,@RequestBody PatientRequestBean bean){
		patientService.updatePatient(id,bean);
		return new ResponseEntity<>("Patient Updated successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> DeletePatient(@PathParam(value = "id") int id){
		patientService.deletePatient(id);
		return new ResponseEntity<>("Patient Deleted successfully", HttpStatus.OK);
	}
}
