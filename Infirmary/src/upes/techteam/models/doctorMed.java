package upes.techteam.models;

public class doctorMed {

	private String medicine;

	public doctorMed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public doctorMed(String medicine) {
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
		return "doctorMed [medicine=" + medicine + "]";
	}

}
