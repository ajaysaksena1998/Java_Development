package upes.techteam.models;

public class studentReport {

	private int stuid;
	private String date;
	private int sapid;
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
	@Override
	public String toString() {
		return "studentReport [stuid=" + stuid + ", date=" + date + ", sapid=" + sapid + "]";
	}
	public studentReport(int stuid, String date, int sapid) {
		super();
		this.stuid = stuid;
		this.date = date;
		this.sapid = sapid;
	}
	public studentReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
