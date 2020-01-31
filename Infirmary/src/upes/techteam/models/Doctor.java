package upes.techteam.models;

public class Doctor {

	private int stuid;
	private String date;
	private String temp;
	private String bp;
	private String weight;
	private String chronic_ailment;
	private String allergies;
	private int sapid;

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

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Doctor [stuid=" + stuid + ", date=" + date + ", temp=" + temp + ", bp=" + bp + ", weight=" + weight
				+ ", chronic_ailment=" + chronic_ailment + ", allergies=" + allergies + ", sapid=" + sapid + "]";
	}

	public String getChronic_ailment() {
		return chronic_ailment;
	}

	public void setChronic_ailment(String chronic_ailment) {
		this.chronic_ailment = chronic_ailment;
	}

	public Doctor(int stuid, String date, String temp, String bp, String weight, String chronic_ailment,
			String allergies, int sapid) {
		this.stuid = stuid;
		this.date = date;
		this.temp = temp;
		this.bp = bp;
		this.weight = weight;
		this.chronic_ailment = chronic_ailment;
		this.allergies = allergies;
		this.sapid = sapid;
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

	public int getSapid() {
		return sapid;
	}

	public void setSapid(int sapid) {
		this.sapid = sapid;
	}
}
