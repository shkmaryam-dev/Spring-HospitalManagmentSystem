package com.example.hospital.repoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.hospital.bean.AppointmentRequestBean;
import com.example.hospital.repo.AppointmentRepository;

@Repository
public class AppointmentRepoImpl implements AppointmentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addAppointment(AppointmentRequestBean appointment) {
        String query = "INSERT INTO appointment(doctorId, patientId,timing,isPaid)VALUES(?,?,?,?)";
        jdbcTemplate.update(query, appointment.getDoctorId(), appointment.getPatientId(), appointment.getTiming(), appointment.getIsPaid());
    }

    @Override
    public List getAllAppointment() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT appointmentId,doctorid,patientId,timing FROM appointment");
        System.out.println("data" + jdbcTemplate.queryForList(query.toString()));
        return jdbcTemplate.queryForList(query.toString());
    }

    @Override
    public void updateAppointment(int id, AppointmentRequestBean bean) {
        String query = "UPDATE appointment SET doctorId=?, patientId=?,timing=?,isPaid=? WHERE appointmentId=?";
        jdbcTemplate.update(query, bean.getDoctorId(), bean.getPatientId(), bean.getTiming(), bean.getIsPaid(), id);
    }

    @Override
    public void deleteAppointment(int id) {
        String query = "DELETE FROM appointment WHERE appointmentId = ?";
        jdbcTemplate.update(query, id);
    }

}
