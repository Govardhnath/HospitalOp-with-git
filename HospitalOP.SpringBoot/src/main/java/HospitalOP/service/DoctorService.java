package HospitalOP.service;

import java.util.List;

import HospitalOP.model.Doctor;

public interface DoctorService {

	Doctor addDoctor(Doctor d);

	String loginDoctor(Doctor d);

	List<Doctor> viewAll();

}
