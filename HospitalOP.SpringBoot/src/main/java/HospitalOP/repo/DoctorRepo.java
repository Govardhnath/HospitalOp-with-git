package HospitalOP.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HospitalOP.model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
public List<Doctor>findByDemailAndDpass(String Demail, String Dpass);
}
