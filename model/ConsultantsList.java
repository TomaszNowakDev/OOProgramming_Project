package model;

import java.io.Serializable;
import java.util.ArrayList;

import controller.AppController;

@SuppressWarnings("serial")
public class ConsultantsList implements Serializable {
	private ArrayList<Consultant> consultants;
	private ArrayList<String> listOfAllPatients;
	private ArrayList<Patient> pracPatients;

	public ConsultantsList() {
		consultants = new ArrayList<Consultant>();
		listOfAllPatients = new ArrayList<String>();
		pracPatients = new ArrayList<Patient>();
	}

	// adding consultants, returns true if added successfully
	public boolean addConsultant(Consultant c) {
		if (this.searchConsultants(c.getName().getFullName()) == null) {
			this.consultants.add(c);
			return true;
		}
		return false;
	}

	// get consultants list
	public ArrayList<Consultant> getConsultantsList() {
		return this.consultants;
	}

	// remove consultant
	public boolean remove(String name) {
		Consultant remove = this.searchConsultants(name);
		if (remove != null) {
			this.consultants.remove(remove);
			return true;
		}
		return false;
	}

	// search Consultant
	public Consultant searchConsultants(String name) {
		Consultant obj = null;

		for (Consultant s : this.consultants) {
			if (s.getName().getFullName().toUpperCase().equals(name.toUpperCase())) {
				obj = s;
			}
		}
		return obj;
	}

	// list of consultants as a string
	public ArrayList<String> getConsultantData() {
		ArrayList<String> consultantData = new ArrayList<String>();
		for (Consultant s : this.consultants) {
			consultantData.add(s.getConsultantName());
		}
		return consultantData;
	}

	public ArrayList<String> getAllPacient() {
		this.listOfAllPatients = new ArrayList<String>();
		for (Consultant c : AppController.getInstance().getConsultantList().getConsultantsList()) {
			for (Patient p : c.getPatients())
				this.listOfAllPatients.add(p.getName().getFullName());
		}
		return listOfAllPatients;
	}

	public Patient searchPatient(String name) {
		Patient obj = null;
		for (Patient p : this.pracPatients) {
			if (p.getName().getFullName().toUpperCase().equals(name.toUpperCase())) {
				obj = p;
			}
		}
		return obj;
	}

	public boolean removePatient(String name) {
		for (Consultant c : this.consultants) {
			if (c.searchPatient(name) == null) {
				System.out.println("Not this consultant or not in the list");
			} else {
				c.removePatient(name);
				return true;
			}
		}
		return false;
	}

}
