package upes.techteam.dao;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import upes.techteam.models.Doctor;
import upes.techteam.models.Patient;
import upes.techteam.models.Staff;
import upes.techteam.models.Stock;

public interface AppDao {

	public void insertPatient(HttpServletRequest request) throws ParseException;

	public List<Patient> getPatient();

	public List<Stock> getstock();

	public List<Doctor> doctable();

	public void insertDoctorMed(HttpServletRequest request);

	public List<Staff> getvalueForStaff();

	public void insertMedicine(List<String> medicine, List<Integer> stock, int sapid);

	public void addMedicine(List<String> medicine, List<Integer> stock);
}
