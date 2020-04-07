package upes.techteam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import upes.techteam.dao.AppDaoImpl;
import upes.techteam.configuration.AppConfig;
import upes.techteam.models.Credentials;
import upes.techteam.models.Doctor;
import upes.techteam.models.Dropdown;
import upes.techteam.models.Expiry;
import upes.techteam.models.Patient;
import upes.techteam.models.Staff;
import upes.techteam.models.Stock;
import upes.techteam.models.studentReport;

@Controller
public class MainController {
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("home");
		Credentials credential = new Credentials();
		model.addObject("credential", credential);
		return model;
	}

	@PostMapping("/uservalues")
	public ModelAndView display(@ModelAttribute("credential") @Valid Credentials credential, BindingResult br) {
		if (br.hasErrors()) {
			ModelAndView model = new ModelAndView("home");
			model.addObject("credential", credential);
			return model;
		} else {
			ModelAndView model = new ModelAndView("coverpage");
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
			List<String> list= dao.getDoctor();
			model.addObject("list",list);
			model.addObject("credential", credential);
			return model;
		}

		/*
		 * if (credential.getEmail().equals("sksingh@ddn.upes.ac.in") &&
		 * credential.getPassword().equals("upes@12345hashtag")) { ModelAndView model =
		 * new ModelAndView("display"); model.addObject("credential", credential);
		 * return model; } else { ModelAndView model = new ModelAndView("home");
		 * model.addObject("credential", credential); return model; }
		 */
	}

	@PostMapping("/patient")
	public ModelAndView finall(HttpServletRequest request) throws ParseException {
		ModelAndView model = new ModelAndView("coverpage");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		dao.insertPatient(request);
		List<String> list= dao.getDoctor();
		model.addObject("list",list);
		context.close();
		return model;
	}

	@PostMapping("/doctorMed")
	public ModelAndView doctorMed(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("doc");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		dao.insertDoctorMed(request);
		context.close();
		return model;
	}
	
	@PostMapping("/simplepage")
	public ModelAndView simplepage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("pasthistory");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		List<Patient> patient= dao.pasthistory(request);
		model.addObject("patient",patient);
		context.close();
		return model;
	}

	@GetMapping("/addmed")
	public ModelAndView addmed(@RequestParam("medicine[]") List<String> medicine,
			@RequestParam("stock[]") List<Integer> stock, @RequestParam("sapid") int sapid) {

		ModelAndView model = new ModelAndView("staff");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		dao.insertMedicine(medicine, stock, sapid);
		context.close();
		return model;
	}

	@GetMapping("/addingMedicines")
	public ModelAndView addmed(@RequestParam("medicine[]") List<String> medicine,
			@RequestParam("stock[]") List<Integer> stock, @RequestParam("expiry[]") List<String> expiry) {

		ModelAndView model = new ModelAndView("addingmedicines");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		dao.addMedicine(medicine, stock, expiry);
		context.close();
		return model;
	}
	
	@GetMapping("/getExpired")
	public ModelAndView expired(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("expiry");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		List<Expiry> expiry = dao.getExpired();
		System.out.println(expiry);
		model.addObject("expired", expiry);
		context.close();
		return model;
	}

	@GetMapping("/staffUpdation")
	public ModelAndView staffUpdation(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("staffVal");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		List<Staff> staff = dao.getvalueForStaff();
		List<Dropdown> list= dao.getdrop();
		model.addObject("list", list);
		model.addObject("staff", staff);
		context.close();
		return model;
	}

	@GetMapping("/doctab")
	public ModelAndView doc() {
		ModelAndView model = new ModelAndView("doctorList");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		List<Doctor> list = dao.doctable();
		model.addObject("list", list);
		context.close();
		return model;
	}

	@GetMapping("/redirecting")
	public ModelAndView go() {
		ModelAndView model = new ModelAndView("coverpage");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		List<String> list= dao.getDoctor();
		model.addObject("list",list);
		return model;
	}

	@GetMapping("/getpatient")
	public ModelAndView getPatient() {
		ModelAndView model = new ModelAndView("StudentList");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		List<Patient> patient = dao.getPatient();
		model.addObject("patient", patient);
		context.close();
		return model;
	}

	@GetMapping("/getstock")
	public ModelAndView getstock() {
		ModelAndView model = new ModelAndView("stockList");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		List<Stock> stock = dao.getstock();
		model.addObject("stock", stock);
		context.close();
		return model;
	}

	@GetMapping("/formmeth")
	public ModelAndView storeMed(HttpServletRequest request) {
		List<String> list = new ArrayList<String>();
		list.add(request.getParameter("prof1"));
		for (int i = 2; i < 20; i++) {
			String temp = "field" + i;
			list.add(request.getParameter(temp));
		}
		while (list.remove(null)) {
		}
		System.out.println(list);
		return null;
	}
	
	@GetMapping("/HelloWorld")
	public ModelAndView Hello(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("studentreport");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		List<studentReport> student = dao.getstudentvalue();
		model.addObject("student", student);
		context.close();
		return model;
	}
	
	@GetMapping("/createpdf")
	public ModelAndView create(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("createpdf");
		return model;
	}
	
	@GetMapping("/act")
	public ModelAndView act(@RequestParam("id") String id) {
		ModelAndView model = new ModelAndView("doctorList");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl dao = context.getBean("DaoBean", AppDaoImpl.class);
		List<Doctor> list = dao.choices(id);
		model.addObject("list", list);
		context.close();
		return model;
	}
}
	
	

