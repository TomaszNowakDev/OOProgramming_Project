package model;

import java.io.Serializable;

public class Person implements Serializable {
	private Name name;
	protected String PersonID;
	private String phone;

	public Person(Name name, String id, String phone) {
		this.name = name;
		this.PersonID = id;
		this.phone = phone;
	}

	public String getID() {
		return PersonID;
	}

	public Name getName() {
		return name;
	}

	public void setId(String id) {
		this.PersonID = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		String str = this.getName().getLastName() + ", " + this.getName().getFirstName() + " ID:" + this.PersonID
				+ ", phone:" + this.phone;
		return str;
	}

}
