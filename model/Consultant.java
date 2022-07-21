package model;

import java.io.Serializable;
import java.util.ArrayList;
import controller.AppController;

@SuppressWarnings({ "serial", "unused" })
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

	public boolean add(Patient p) {
		if (this.searchPatient(p.getName().getFullName()) == null) {
			this.patients.add(p);
			return true;
		}
		System.out.println("This patient is already on the records.");
		return false;
	}

	public Patient searchPatient(String name) {
		Patient obj = null;

		for (Patient p : this.patients) {
			if (p.getName().getFullName().toUpperCase().equals(name.toUpperCase())) {
				obj = p;
			}
		}
		return obj;
	}
	public boolean removePatient(String name) {
		Patient remove = this.searchPatient(name);
		if (remove != null) {
			this.patients.remove(remove);
			return true;
		}
		return false;
	}

	public void addVisit(Patient p, Visit v) {
		p.add(v);
	}

	public void showPatients() {
		for (int i = 0; i < patients.size(); i++) {
			System.out.println(i + 1 + ". " + patients.get(i).getName().getLastName() + ", "
					+ patients.get(i).getName().getFirstName());
		}
	}

	public void showPatientsAndVisits() {
		for (int i = 0; i < patients.size(); i++) {
			System.out.println(i + 1 + ". " + patients.get(i).getName().getLastName() + ", "
					+ patients.get(i).getName().getFirstName() + " Visits: " + patients.get(i).getVisits());
		}
	}

	public String toString() {
		String str = super.getName().getFullName() + " Expertise: " + this.expertise + ", Patients:" + this.patients;
		return str;
	}

}
