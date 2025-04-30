package com.example.ormcoursework.bo.custom;

import com.example.ormcoursework.bo.SuperBO;
import com.example.ormcoursework.dto.MedicalHistoryDTO;
import com.example.ormcoursework.dto.PatientDTO;

import java.util.List;

public interface MedicalHistoryBO extends SuperBO {

    String generateNewId();

    List<MedicalHistoryDTO> getAll();

    List<PatientDTO> getAllPatient();

    PatientDTO getPatientDetailsById(String id);

    boolean add(MedicalHistoryDTO medicalHistoryDTO);

    boolean delete(MedicalHistoryDTO medicalHistoryDTO);

    boolean update(MedicalHistoryDTO medicalHistoryDTO);
}
