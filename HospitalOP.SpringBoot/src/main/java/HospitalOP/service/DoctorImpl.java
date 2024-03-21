package HospitalOP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HospitalOP.model.Doctor;
import HospitalOP.repo.DoctorRepo;

@Service
public class DoctorImpl implements DoctorService {
@Autowired
private DoctorRepo doctorRepo;
	@Override
	public Doctor addDoctor(Doctor d) {
		return doctorRepo.save(d) ;
	}

	@Override
	public String loginDoctor(Doctor d) {
List<Doctor>list=doctorRepo.findByDemailAndDpass(d.getDemail(), d.getDpass());
		if(!list.isEmpty()) {
			return "Log In Success!!";
		}else {
			return "Login Failed!!";
		}
	}

	@Override
	public List<Doctor> viewAll() {
		return doctorRepo.findAll();
	}

}
