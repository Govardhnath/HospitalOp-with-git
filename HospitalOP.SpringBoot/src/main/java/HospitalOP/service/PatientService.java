package HospitalOP.service;

import java.util.List;

import HospitalOP.model.Patient;

public interface PatientService {

	public String addPatient(Patient p);

	String loginPatient(Patient p);

	List<Patient> viewAll();

	Patient updatePatient(Patient p);

	List<Patient> findPatient(int opno);

	Patient deletePatient(int id);

}
