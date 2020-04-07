package upes.techteam.models;

public class Patient {

	int stuid;
	String date;
	String name;
	String contact;
	int age;
	String gender;
	int sapid;
	String doctor;
	String course;
	String medicine;
	String diagnosis;
	String temp;
	String bp;
	String weight;
	String chronic_ailment;
	String allergies;
	String travel;
	String address;

	public Patient() {
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Patient(int stuid, String date, String name, String contact, int age, String gender, int sapid,
			String doctor, String course, String medicine, String diagnosis, String temp, String bp, String weight,
			String chronic_ailment, String allergies, String travel, String address) {
		super();
		this.stuid = stuid;
		this.date = date;
		this.name = name;
		this.contact = contact;
		this.age = age;
		this.gender = gender;
		this.sapid = sapid;
		this.doctor = doctor;
		this.course = course;
		this.medicine = medicine;
		this.diagnosis = diagnosis;
		this.temp = temp;
		this.bp = bp;
		this.weight = weight;
		this.chronic_ailment = chronic_ailment;
		this.allergies = allergies;
		this.travel = travel;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [stuid=" + stuid + ", date=" + date + ", name=" + name + ", contact=" + contact + ", age=" + age
				+ ", gender=" + gender + ", sapid=" + sapid + ", doctor=" + doctor + ", course=" + course
				+ ", medicine=" + medicine + ", diagnosis=" + diagnosis + ", temp=" + temp + ", bp=" + bp + ", weight="
				+ weight + ", chronic_ailment=" + chronic_ailment + ", allergies=" + allergies + ", travel=" + travel
				+ ", address=" + address + "]";
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSapid() {
		return sapid;
	}

	public void setSapid(int sapid) {
		this.sapid = sapid;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getChronic_ailment() {
		return chronic_ailment;
	}

	public void setChronic_ailment(String chronic_ailment) {
		this.chronic_ailment = chronic_ailment;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getTravel() {
		return travel;
	}

	public void setTravel(String travel) {
		this.travel = travel;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

}
