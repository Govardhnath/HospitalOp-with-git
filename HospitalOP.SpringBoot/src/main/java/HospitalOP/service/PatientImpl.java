package HospitalOP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HospitalOP.model.Patient;
import HospitalOP.repo.PatientRepo;

@Service
public class PatientImpl implements PatientService {
@Autowired
private PatientRepo patientRepo;
	@Override
	public String addPatient(Patient p) {
		p.setPsymptoms("Not yet diagnoised");
		p.setPdiagnosis("Not yet diagnoised");
		return patientRepo.save(p).toString();
	}

	@Override
	public String loginPatient(Patient p) {
		List<Patient>list=patientRepo.findByPemailAndPpass(p.getPemail(), p.getPpass());
		if(!list.isEmpty()) {
			return "Log In Success";
		}else {
			return "Log In Failed!!";
		}
	}

	@Override
	public List<Patient> viewAll() {
		return patientRepo.findAll();
	}

	@Override
	public Patient updatePatient(Patient p) {
		Patient pt=patientRepo.findById(p.getOpno()).get();
		pt.setPsymptoms(p.getPsymptoms());
		pt.setPdiagnosis(p.getPdiagnosis());
		return patientRepo.save(pt);
	}

	@Override
	public List<Patient> findPatient(int opno) {
		return patientRepo.findByOpno(opno);
	}

	@Override
	public Patient deletePatient(int id) {
		Patient p=patientRepo.findById(id).get();
		patientRepo.deleteById(id);
		return p;
	}

}
