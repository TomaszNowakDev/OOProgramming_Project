package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Patient extends Person implements Serializable {

	private ArrayList<Visit> visits;
	private String illness;
	private SeverityOptions severity;

	public Patient(Name name, String id, String phone, ArrayList<Visit> v, String i, SeverityOptions sev) {
		super(name, id, phone);
		this.visits = new ArrayList<Visit>();
		this.illness = i;
		this.severity = sev;
	}

	public ArrayList<Visit> getVisits() {
		return visits;
	}

	public void setVisits(ArrayList<Visit> visits) {
		this.visits = visits;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}
	public String getPatientName() {
		return super.getName().getFullName();
	}

	public void add(Visit v) {
		this.visits.add(v);
	}
	
}
