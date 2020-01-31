package upes.techteam.models;

public class Stock {

	String medicine;
	int amount;

	public Stock() {
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public Stock(String medicine, int amount) {
		super();
		this.medicine = medicine;
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
