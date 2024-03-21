package HospitalOP.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HospitalOP.model.Admin;
import HospitalOP.model.Doctor;
import HospitalOP.model.Patient;
import HospitalOP.service.AdminService;
import HospitalOP.service.DoctorService;
import HospitalOP.service.PatientService;

@RestController
@RequestMapping("/doctor")
public class HospitalController {
	@Autowired
	private PatientService patientService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private DoctorService doctorService;

	@PostMapping("/adda")
	public List<String> addAdmin(@RequestBody Admin a) {
		try {
			List<String> list = new ArrayList<String>();
			list.add(adminService.addAdmin(a).toString());
			return list;
		} catch (Exception e) {
			String errorMessage = e.getLocalizedMessage().toString();
			Map<String, Integer> counts = countInterpolatedMessages(errorMessage);
			List<String> list = new ArrayList<String>();
			for (Map.Entry<String, Integer> entry : counts.entrySet()) {
				list.add(entry.getKey());
			}
			return list;
		}
	}

	public static Map<String, Integer> countInterpolatedMessages(String input) {
		Pattern pattern = Pattern.compile("interpolatedMessage='(.*?)'");
		Matcher matcher = pattern.matcher(input);
		Map<String, Integer> messageCounts = new HashMap<>();
		while (matcher.find()) {
			String message = matcher.group(1);
			messageCounts.put(message, messageCounts.getOrDefault(message, 0) + 1);
		}
		return messageCounts;
	}


	@GetMapping("/alogin")
	public String loginAdmin(@RequestBody Admin a) {
		return adminService.loginAdmin(a);
	}

	@GetMapping("/aview")
	public List<Admin> viewAdmin(@RequestBody Admin a) {
		return adminService.viewAll();
	}

	@PostMapping("/addd")
	public Doctor addDoctor(@RequestBody Doctor d) {
		return doctorService.addDoctor(d);
	}

	@GetMapping("/dlogin")
	public String loginDoctor(@RequestBody Doctor d) {
		return doctorService.loginDoctor(d);
	}

	@GetMapping("/dview")
	public List<Doctor> viewDoctor(@RequestBody Doctor d) {
		return doctorService.viewAll();
	}
	@PostMapping("/addp")
	public List<String> addPatient(@RequestBody Patient p) {
		try {
			List<String> list = new ArrayList<String>();
			list.add(patientService.addPatient(p).toString());
			return list;
		} catch (Exception e) {
			String errorMessage = e.getLocalizedMessage().toString();
			Map<String, Integer> counts = countInterpolatedMessages(errorMessage);
			List<String> list = new ArrayList<String>();
			for (Map.Entry<String, Integer> entry : counts.entrySet()) {
				list.add(entry.getKey());
			}
			return list;
		}
	}

	public static Map<String, Integer> countInterpolatedMessagesp(String input) {
		Pattern pattern = Pattern.compile("interpolatedMessage='(.*?)'");
		Matcher matcher = pattern.matcher(input);
		Map<String, Integer> messageCounts = new HashMap<>();
		while (matcher.find()) {
			String message = matcher.group(1);
			messageCounts.put(message, messageCounts.getOrDefault(message, 0) + 1);
		}
		return messageCounts;
	}


	@GetMapping("/plogin")
	public String loginPatient(@RequestBody Patient p) {
		return patientService.loginPatient(p);
	}

	@GetMapping("/pview")
	public List<Patient> viewPatient(@RequestBody Patient p) {
		return patientService.viewAll();
	}

	@PutMapping("/diagnosis")
	public Patient diagnosis(@RequestBody Patient p) {
		return patientService.updatePatient(p);
	}

	@GetMapping("/opview/{opno}")
	public List<Patient> findPatient(@PathVariable int opno) {
		return patientService.findPatient(opno);
	}

	@DeleteMapping("/delp/{id}")
	public Patient deletePatient(@PathVariable(value = "id") int id) {
		return patientService.deletePatient(id);
	}
}
