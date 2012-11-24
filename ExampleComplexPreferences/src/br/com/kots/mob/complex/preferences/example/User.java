package br.com.kots.mob.complex.preferences.example;

public class User {
	
	private String name;
	private int age;
	private boolean active;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", active=" + active
				+ "]";
	}
}
