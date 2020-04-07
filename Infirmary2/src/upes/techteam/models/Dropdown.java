package upes.techteam.models;

public class Dropdown {

	private String medicine;

	public Dropdown() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dropdown(String medicine) {
		super();
		this.medicine = medicine;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	@Override
	public String toString() {
		return "Dropdown [medicine=" + medicine + "]";
	}
	
}
