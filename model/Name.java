package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Name implements Serializable {
	protected String firstName, lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		String fullName = this.firstName + " " + this.lastName;
		return fullName;
	}

	public String toString() {
		String fullName = "Firstname: " + this.firstName + ", Lastname: " + this.lastName;
		return fullName;
	}
	
	

	@Override
	public boolean equals(Object o) {
		if (this.firstName == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name = (Name) o;
		boolean result = this.firstName.toLowerCase().equals(name.firstName.toLowerCase())
				&& this.lastName.toLowerCase().equals(name.lastName.toLowerCase());
		return result;
	}
}
