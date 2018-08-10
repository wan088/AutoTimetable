package kr.or.connect.mvcexam.dto;

public class gang {
	String year;
	String type;
	String number;
	String name;
	String pointTotal;
	String pointLee;
	String pointSil;
	String times;
	String location;
	String professor;
	String inSeoul;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPointTotal() {
		return pointTotal;
	}
	public void setPointTotal(String pointTotal) {
		this.pointTotal = pointTotal;
	}
	public String getPointLee() {
		return pointLee;
	}
	public void setPointLee(String pointLee) {
		this.pointLee = pointLee;
	}
	public String getPointSil() {
		return pointSil;
	}
	public void setPointSil(String pointSil) {
		this.pointSil = pointSil;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getInSeoul() {
		return inSeoul;
	}
	public void setInSeoul(String inSeoul) {
		this.inSeoul = inSeoul;
	}
	@Override
	public String toString() {
		return "gang [year=" + year + ", type=" + type + ", number=" + number + ", name=" + name + ", pointTotal="
				+ pointTotal + ", pointLee=" + pointLee + ", pointSil=" + pointSil + ", times=" + times + ", location="
				+ location + ", professor=" + professor + ", inSeoul=" + inSeoul + "]";
	}
	
}
