package upes.techteam.dao;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import upes.techteam.models.Doctor;
import upes.techteam.models.Dropdown;
import upes.techteam.models.Expiry;
import upes.techteam.models.Patient;
import upes.techteam.models.Staff;
import upes.techteam.models.Stock;
import upes.techteam.models.studentReport;

public interface AppDao {

	public void insertPatient(HttpServletRequest request) throws ParseException;

	public List<Patient> getPatient();

	public List<Stock> getstock();

	public List<Doctor> doctable();

	public void insertDoctorMed(HttpServletRequest request);

	public List<Staff> getvalueForStaff();

	public void insertMedicine(List<String> medicine, List<Integer> stock, int sapid);

	public void addMedicine(List<String> medicine, List<Integer> stock, List<String> expiry);
	
	public List<Patient> pasthistory(HttpServletRequest request);
	
	public List<Expiry> getExpired();
	
	public List<studentReport> getstudentvalue();
	
	public List<Doctor> choices(String id);
	
	public List<Dropdown> getdrop();
	
	public List<String> getDoctor();
	
	
}
