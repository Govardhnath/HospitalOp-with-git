package HospitalOP.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Table
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	@Email(message = "Email format is incorrect!!")
	private String aemail;
	@Length(min = 4, message = "Password should be more than 8 characters!!")
	@Length(max = 8, message = "Passage should have less than 8 characters")
	private String apass;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aemail) {
		this.aemail = aemail;
	}

	public String getApass() {
		return apass;
	}

	public void setApass(String apass) {
		this.apass = apass;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aemail=" + aemail + "]";
	}

}
