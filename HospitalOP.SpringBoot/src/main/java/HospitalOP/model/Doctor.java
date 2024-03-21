package HospitalOP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int did;
	private String dname;
	private String demail;
	private String dpass;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDemail() {
		return demail;
	}
	public void setDemail(String demail) {
		this.demail = demail;
	}
	public String getDpass() {
		return dpass;
	}
	public void setDpass(String dpass) {
		this.dpass = dpass;
	}
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", demail=" + demail + ", dpass=" + dpass + "]";
	}
	
}
