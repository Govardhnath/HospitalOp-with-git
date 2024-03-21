package HospitalOP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HospitalOP.model.Admin;
import HospitalOP.repo.AdminRepo;

@Service
public class AdminImpl implements AdminService {
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public String addAdmin(Admin a) {
		return adminRepo.save(a).toString();
	}

	@Override
	public String loginAdmin(Admin a) {
		List<Admin>list=adminRepo.findByAemailAndApass(a.getAemail(), a.getApass());
		if (!list.isEmpty()) {
			return "Log In Success!!";	
		}else {
			return "Login Failed!!";
		}
	}

	@Override
	public List<Admin> viewAll() {
		return adminRepo.findAll();
	}

}
