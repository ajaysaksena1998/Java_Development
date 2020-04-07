package upes.techteam.models;

public class Staff {

	private int stuid;
	private String date;
	private int sapid;
	private String medicine;

	@Override
	public String toString() {
		return "Staff [stuid=" + stuid + ", date=" + date + ", sapid=" + sapid + ", medicine=" + medicine + "]";
	}

	public Staff(int stuid, String date, int sapid, String medicine) {
		super();
		this.stuid = stuid;
		this.date = date;
		this.sapid = sapid;
		this.medicine = medicine;
	}

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
}
