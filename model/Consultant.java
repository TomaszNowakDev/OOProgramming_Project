package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Consultant extends Person implements Serializable {
	private ArrayList<Patient> patients;
	private String expertise;

	public Consultant(Name name, String id, String phone, ArrayList<Patient> patients, String expertise) {
		super(name, id, phone);
		this.patients = new ArrayList<Patient>();
		this.expertise = expertise;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public String getConsultantName() {
		return super.getName().getFullName();
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String toString() {
		String str = super.getName().getFullName() + " Expertise: " + this.expertise + ", Patients:" + this.patients;
		return str;
	}

}
