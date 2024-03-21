package HospitalOP.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Table
@Entity

public class Patient {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int opno;
	@Size(min = 4, max = 15, message = "Name should be between 4 and 15 characters")
	private String pname;
	@Min(message = "should be greater than 18", value = 18) // 12
	@Max(message = "should be less than 120", value = 120)
	private int page;
	private String pplace;
	private String psymptoms;
	private int did;
	private String pdiagnosis;
	@Email
	private String pemail;
	@Length(min = 4, message = "Password should atleast have 4 characters")
	@Length(max = 12, message = "Password should have less than 12 characters")
	private String ppass;
	public int getOpno() {
		return opno;
	}
	public void setOpno(int opno) {
		this.opno = opno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getPplace() {
		return pplace;
	}
	public void setPplace(String pplace) {
		this.pplace = pplace;
	}
	public String getPsymptoms() {
		return psymptoms;
	}
	public void setPsymptoms(String psymptoms) {
		this.psymptoms = psymptoms;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getPdiagnosis() {
		return pdiagnosis;
	}
	public void setPdiagnosis(String pdiagnosis) {
		this.pdiagnosis = pdiagnosis;
	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public String getPpass() {
		return ppass;
	}
	public void setPpass(String ppass) {
		this.ppass = ppass;
	}
	@Override
	public String toString() {
		return "Patient [opno=" + opno + ", pname=" + pname + ", page=" + page + ", pplace=" + pplace + ", psymptoms="
				+ psymptoms + ", did=" + did + ", pdiagnosis=" + pdiagnosis + ", pemail=" + pemail + ", ppass=" + ppass
				+ "]";
	}
	
}
