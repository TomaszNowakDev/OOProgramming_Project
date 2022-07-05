package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice implements Serializable {
	private ArrayList<Consultant> ConsultantList = new ArrayList<Consultant>();

	public void add(Consultant con) {
		this.ConsultantList.add(con);
	}

	public ArrayList<Consultant> getConsultants() {
		return ConsultantList;

	}

	public void showConsultants() {
		for (int i = 0; i < ConsultantList.size(); i++) {
			System.out.println(i + 1 + ". " + ConsultantList.get(i).getName().getLastName() + ", "
					+ ConsultantList.get(i).getName().getFirstName() + "\t" + ConsultantList.get(i).getExpertise());
		}
	}

	public Consultant searchByName(String name) {
		Consultant found = null;
		for (Consultant c : this.ConsultantList) {
			if (c.getName().getLastName().equals(name))
				found = c;
		}
		return found;
	}

	public Consultant find() {
		this.showConsultants();
		int consultantchoice = 0;
		boolean inputValidation = false;
		while (!inputValidation) {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			try {
				consultantchoice = scanner.nextInt();
				if (consultantchoice < 1 || consultantchoice > this.getConsultants().size()) {
					throw new InputMismatchException();
				}
				inputValidation = true;
			} catch (InputMismatchException ex) {
				System.out.println("Please enter correct number of consultant.");
			}
			scanner.nextLine();
		}
		
		return this.ConsultantList.get(consultantchoice - 1);
	}

	public void showDetails() {
		for (Consultant c : ConsultantList) {
			System.out.println(
					c.getName().getLastName() + ", " + c.getName().getFirstName() + " Expertise: " + c.getExpertise());
			c.showPatientsAndVisits();
		}
	}

	public void setConsultantList(ArrayList<Consultant> consultantList) {
		ConsultantList = consultantList;
	}
}
