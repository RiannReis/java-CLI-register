package co.riannreis.entities;

import java.util.Objects;

public class InterestedPerson {
	private String name;
	private String email;
	private byte age;
	private float heigth;

	public InterestedPerson() {

	}

	public InterestedPerson(String name, String email, byte age, float heigth) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.heigth = heigth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public float getHeigth() {
		return heigth;
	}

	public void setHeigth(float heigth) {
		this.heigth = heigth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InterestedPerson other = (InterestedPerson) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "InterestedPerson [name=" + name + ", email=" + email + ", age=" + age + ", heigth=" + heigth + "]";
	}

}
