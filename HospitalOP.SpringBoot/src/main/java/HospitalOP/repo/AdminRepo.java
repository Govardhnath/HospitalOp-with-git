package HospitalOP.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HospitalOP.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	public List<Admin> findByAemailAndApass(String aemail, String apass);

}
