package model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
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

	public void showAllVisits() {
		for (Visit v : visits) {
			System.out.println(v.getDate() + " " + v.getNotes());
		}
	}

	public String toString() {
		String str = super.getName().getLastName() + ", " + super.getName().getFirstName() + " Illness: "
				+ this.getIllness() + ", Severity: " + this.getSeverity() + ", List of visits: " + this.visits;
		return str;
	}

	public SeverityOptions getSeverity() {
		return severity;
	}

	public void setSeverity(SeverityOptions severity) {
		this.severity = severity;
	}
}
