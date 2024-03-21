package HospitalOP.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HospitalOP.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {
public List<Patient>findByPemailAndPpass(String pemail, String ppass);
public List<Patient>findByOpno(int opno);
}
