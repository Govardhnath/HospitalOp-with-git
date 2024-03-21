package HospitalOP.service;

import java.util.List;

import HospitalOP.model.Admin;

public interface AdminService {

	public String addAdmin(Admin a);

	public String loginAdmin(Admin a);

	public List<Admin> viewAll();

}
