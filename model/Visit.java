package model;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Visit implements Serializable{
	private LocalDate date;
	String notes;

	public Visit(LocalDate date, String notes) {
		this.date = date;
		this.notes = notes;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String toString() {
		String str = "Date: " + this.getDate() + " Notes: " + this.getNotes();
		return str;
	}

}
