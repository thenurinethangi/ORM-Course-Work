package com.example.ormcoursework.dao.custom;

import com.example.ormcoursework.dao.CrudDAO;
import com.example.ormcoursework.entity.Patient;
import org.hibernate.Session;

import java.util.List;

public interface PatientDAO extends CrudDAO<Patient> {

    Patient getPatientByPhoneNo(String phoneNo);

    boolean updateEnrolledTherapyProgramCount(Patient patient, Session session,String action);
}
