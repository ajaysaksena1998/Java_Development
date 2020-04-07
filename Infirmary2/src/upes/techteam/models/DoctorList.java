package upes.techteam.models;

public class DoctorList {

	int docId;
	String docName;
	String department;
	String timings;
	@Override
	public String toString() {
		return "DoctorList [docId=" + docId + ", docName=" + docName + ", department=" + department + ", timings="
				+ timings + "]";
	}
	public DoctorList(int docId, String docName, String department, String timings) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.department = department;
		this.timings = timings;
	}
	public DoctorList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	
}
