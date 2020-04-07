package upes.techteam.models;

public class Expiry {

	String medicine;
	int amount;
	String expiry;
	
	public Expiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public Expiry(String medicine, int amount, String expiry) {
		super();
		this.medicine = medicine;
		this.amount = amount;
		this.expiry = expiry;
	}
	@Override
	public String toString() {
		return "Expiry [medicine=" + medicine + ", amount=" + amount + ", expiry=" + expiry + "]";
	}
	
}
