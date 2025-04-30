package com.example.ormcoursework.dao.custom;

import com.example.ormcoursework.dao.CrudDAO;
import com.example.ormcoursework.entity.TherapistProgramAssignment;
import com.example.ormcoursework.entity.TherapistProgramAssignmentFK;

import java.util.List;

public interface TherapistProgramAssignmentDAO extends CrudDAO<TherapistProgramAssignment> {

    List<TherapistProgramAssignment> getSelectedTherapistAssignedProgramList(String therapistId);

    boolean delete(TherapistProgramAssignmentFK therapistProgramAssignmentFK);

    boolean changeStatus(TherapistProgramAssignmentFK therapistProgramAssignmentFK,TherapistProgramAssignment therapistProgramAssignment);
}
