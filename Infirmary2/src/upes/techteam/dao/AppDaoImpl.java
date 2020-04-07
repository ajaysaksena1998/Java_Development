package upes.techteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import upes.techteam.models.Doctor;
import upes.techteam.models.Dropdown;
import upes.techteam.models.Expiry;
import upes.techteam.models.Patient;
import upes.techteam.models.Staff;
import upes.techteam.models.Stock;
import upes.techteam.models.studentReport;

public class AppDaoImpl implements AppDao {

	private DataSource dataSource;

	public AppDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insertPatient(HttpServletRequest request) throws ParseException {
		String sql = "INSERT INTO patient(date,name,contact,age,gender,sapid,doctor,course,temp,bp,weight,chronic_ailment,allergies,travel,HostelAddr) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String doc = "INSERT INTO doctor(date,doctor,temp,bp,weight,chronic_ailment,allergies,sapid) value(?,?,?,?,?,?,?,?)";
		String d= request.getParameter("doctor");
		String[] arr = d.split("-", 2);
		String s=null;
		int count=0;
		for(String a:arr) {
			if(count==0) {
				s=a;
				count=1;
			}
		}
		Connection conn = null;
		Connection object = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, request.getParameter("date"));
			ps.setString(2, request.getParameter("name"));
			ps.setString(3, request.getParameter("contact"));
			ps.setInt(4, Integer.parseInt(request.getParameter("age")));
			ps.setString(5, request.getParameter("gender"));
			ps.setInt(6, Integer.parseInt(request.getParameter("sapid")));
			ps.setString(7, s);
			ps.setString(8, request.getParameter("course"));
			ps.setString(9, request.getParameter("temp"));
			ps.setString(10, request.getParameter("bp"));
			ps.setString(11, request.getParameter("weight"));
			ps.setString(12, request.getParameter("chronic_ailment"));
			ps.setString(13, request.getParameter("allergies"));
			ps.setString(14, request.getParameter("travel"));
			ps.setString(15, request.getParameter("address"));
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("connection failed");
				}
			}
			try {
				object = dataSource.getConnection();
				PreparedStatement prepare = object.prepareStatement(doc);
				prepare.setString(1, request.getParameter("date"));
				prepare.setString(2, s);
				prepare.setString(3, request.getParameter("temp"));
				prepare.setString(4, request.getParameter("bp"));
				prepare.setString(5, request.getParameter("weight"));
				prepare.setString(6, request.getParameter("chronic_ailment"));
				prepare.setString(7, request.getParameter("allergies"));
				prepare.setInt(8, Integer.parseInt(request.getParameter("sapid")));
				prepare.executeUpdate();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						System.out.println("connection failed");
					}
				}
			}
		}
	}

	@Override
	public List<Patient> getPatient() {
		String SQL = "Select * from patient";
		List<Patient> listUsers = new ArrayList<Patient>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Patient temp = new Patient(rs.getInt("Stuid"), rs.getString("date"), rs.getString("name"),
						rs.getString("contact"), rs.getInt("age"), rs.getString("gender"), rs.getInt("sapid"),
						rs.getString("doctor"), rs.getString("course"), rs.getString("medicine"), rs.getString("Diagnosis"),
						rs.getString("temp"), rs.getString("bp"), rs.getString("weight"),
						rs.getString("chronic_ailment"), rs.getString("allergies"), rs.getString("travel"),
						rs.getString("HostelAddr"));
				listUsers.add(temp);
			}
			rs.close();
			ps.close();
			return listUsers;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Stock> getstock() {
		String SQL = "Select * from stock";
		List<Stock> liststock = new ArrayList<Stock>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Stock temp = new Stock(rs.getString("Medicine"), rs.getInt("Stock"));
				liststock.add(temp);
			}
			rs.close();
			ps.close();
			return liststock;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Doctor> doctable() {
		String SQL = "Select * from doctor";
		List<Doctor> listpatient = new ArrayList<Doctor>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Doctor temp = new Doctor(rs.getInt("stuid"), rs.getString("doctor"),rs.getString("date"), rs.getString("temp"),
						rs.getString("bp"), rs.getString("weight"), rs.getString("chronic_ailment"),
						rs.getString("allergies"), rs.getInt("sapid"));
				listpatient.add(temp);
			}
			rs.close();
			ps.close();
			return listpatient;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void insertDoctorMed(HttpServletRequest request) {
		String date = "";
		int stuid = 0;
		String first = "select stuid,date from patient where sapid=?";
		String sql = "UPDATE patient SET medicine =?, Diagnosis=? WHERE sapid=? AND medicine='default'";
		String obj = "DELETE FROM doctor WHERE sapid=?";
		Connection conn = null;
		Connection onn = null;
		Connection insert = null;
		Connection stu = null;
		try {
			onn = dataSource.getConnection();
			PreparedStatement a = onn.prepareStatement(first);
			a.setString(1, request.getParameter("sapid"));
			ResultSet r = a.executeQuery();
			while (r.next()) {
				stuid = r.getInt("stuid");
				date = r.getString("date");
			}
			r.close();
			a.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (onn != null) {
					onn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String query = "insert into staff(stuid,date,sapid,medicine) values(?,?,?,?)";
		String q1= "insert into studentreport(stuid,date,sapid) values(?,?,?)";
		try {
			insert = dataSource.getConnection();
			stu = dataSource.getConnection();
			PreparedStatement in = insert.prepareStatement(query);
			PreparedStatement i = stu.prepareStatement(q1);
			in.setInt(1, stuid);
			in.setString(2, date);
			in.setString(3, request.getParameter("sapid"));
			in.setString(4, request.getParameter("medicine"));
			i.setInt(1, stuid);
			i.setString(2, date);
			i.setString(3, request.getParameter("sapid"));
			i.executeUpdate();
			in.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (insert != null) {
				try {
					insert.close();
				} catch (SQLException e) {
					System.out.println("Connection failed");
				}
				if(stu!=null) {
					try {
						stu.close();
					}catch(SQLException e) {
						System.out.println("Connection Failed");
					}
				}

				try {
					conn = dataSource.getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, request.getParameter("medicine"));
					ps.setString(2, request.getParameter("diagnosis"));
					ps.setString(3, request.getParameter("sapid"));
					ps.executeUpdate();
					PreparedStatement as = conn.prepareStatement(obj);
					as.setString(1, request.getParameter("sapid"));
					as.executeUpdate();

				} catch (SQLException e) {
					throw new RuntimeException(e);
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							System.out.println("connection failed");
						}
					}
				}
			}
		}
	}

	@Override
	public List<Staff> getvalueForStaff() {
		String SQL = "Select * from staff";
		List<Staff> staff = new ArrayList<Staff>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Staff temp = new Staff(rs.getInt("stuid"), rs.getString("date"), rs.getInt("sapid"),
						rs.getString("medicine"));
				staff.add(temp);
			}
			rs.close();
			ps.close();
			return staff;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void insertMedicine(List<String> medicine, List<Integer> stock, int sapid) {

		Connection conn = null;
		Connection demo = null;
		Connection up = null;
		Connection d = null;
		String del = "delete from staff where sapid=?";
		try {
			d = dataSource.getConnection();
			PreparedStatement ab = d.prepareStatement(del);
			ab.setInt(1, sapid);
			ab.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (d != null) {
					d.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < medicine.size(); i++) {
			for (int j = 0; j < stock.size(); j++) {
				if (i == j) {
					String sql = "select * from stock where Medicine=?";

					try {
						demo = dataSource.getConnection();
						conn = dataSource.getConnection();
						PreparedStatement p = demo.prepareStatement(sql);

						p.setString(1, medicine.get(i).toUpperCase());
						ResultSet r = p.executeQuery();
						if (r.next()) {
							try {
								String value = "update stock set Stock=Stock-? where Medicine=?";
								up = dataSource.getConnection();
								PreparedStatement a = conn.prepareStatement(value);
								a.setInt(1, stock.get(j));
								a.setString(2, medicine.get(i).toUpperCase());
								a.executeUpdate();
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								try {
									if (up != null) {
										up.close();
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}

						} else {

						}

					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		try {
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addMedicine(List<String> medicine, List<Integer> stock, List<String> expiry) {

		Connection demo = null;
		Connection conn = null;
		Connection up = null;
		for (int i = 0; i < medicine.size(); i++) {
			for (int j = 0,k=0; j < stock.size(); j++,k++) {
				if (i == j) {
					String sql = "select * from stock where Medicine=?";
					String doc = "INSERT INTO stock(Medicine,Stock,Expiry) value(?,?,?)";

					try {
						demo = dataSource.getConnection();
						conn = dataSource.getConnection();
						PreparedStatement p = demo.prepareStatement(sql);
						PreparedStatement ps = conn.prepareStatement(doc);

						p.setString(1, medicine.get(i).toUpperCase());
						ResultSet r = p.executeQuery();
						if (r.next()) {
							try {
								String value = "update stock set Stock=Stock+? where Medicine=?";
								up = dataSource.getConnection();
								PreparedStatement a = conn.prepareStatement(value);
								a.setInt(1, stock.get(j));
								a.setString(2, medicine.get(i).toUpperCase());
								a.executeUpdate();
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								try {
									if (up != null) {
										up.close();
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}

						} else {
							ps.setString(1, medicine.get(i).toUpperCase());
							ps.setInt(2, stock.get(j));
							ps.setString(3, expiry.get(k));
							ps.executeUpdate();
						}

					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		try {
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Patient> pasthistory(HttpServletRequest request) {
		String SQL = "Select * from patient where sapid=?";
		List<Patient> listUsers = new ArrayList<Patient>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, request.getParameter("sapid"));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Patient temp = new Patient(rs.getInt("Stuid"), rs.getString("date"), rs.getString("name"),
						rs.getString("Contact"), rs.getInt("age"), rs.getString("gender"), rs.getInt("sapid"),
						rs.getString("doctor"), rs.getString("course"), rs.getString("medicine"), rs.getString("Diagnosis"),
						rs.getString("temp"), rs.getString("bp"), rs.getString("weight"),
						rs.getString("chronic_ailment"), rs.getString("allergies"), rs.getString("travel"),
						rs.getString("HostelAddr"));
				listUsers.add(temp);
			}
			rs.close();
			ps.close();
			return listUsers;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Expiry> getExpired() {
		String SQL = "SELECT * FROM stock WHERE MONTH(Expiry) = MONTH(CURRENT_DATE()) AND YEAR(Expiry) = YEAR(CURRENT_DATE())";
		List<Expiry> expired = new ArrayList<Expiry>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expiry temp = new Expiry(rs.getString("Medicine"), rs.getInt("Stock"), rs.getString("Expiry"));
				expired.add(temp);
			}
			rs.close();
			ps.close();
			return expired;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

@Override
public List<studentReport> getstudentvalue() {
	String SQL = "Select * from studentreport";
	List<studentReport> student = new ArrayList<studentReport>();
	Connection conn = null;
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			studentReport temp = new studentReport(rs.getInt("stuid"), rs.getString("date"), rs.getInt("sapid"));
			student.add(temp);
		}
		rs.close();
		ps.close();
		return student;

	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

public List<Doctor> choices(String id) {
	String SQL = "Select * from doctor where doctor=? ";
	List<Doctor> listpatient = new ArrayList<Doctor>();
	Connection conn = null;
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(SQL);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Doctor temp = new Doctor(rs.getInt("stuid"), rs.getString("doctor"),rs.getString("date"), rs.getString("temp"),
					rs.getString("bp"), rs.getString("weight"), rs.getString("chronic_ailment"),
					rs.getString("allergies"), rs.getInt("sapid"));
			listpatient.add(temp);
		}
		rs.close();
		ps.close();
		return listpatient;

	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

public List<Dropdown> getdrop() {
	String SQL = "Select Medicine from stock order by Medicine asc";
	List<Dropdown> med = new ArrayList<Dropdown>();
	Connection conn = null;
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Dropdown temp = new Dropdown(rs.getString("Medicine"));
			med.add(temp);
		}
		rs.close();
		ps.close();
		return med;

	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

@Override
public List<String> getDoctor() {
	String SQL = "Select docName,department,timings from doclist";
	List<String> med = new ArrayList<String>();
	Connection conn = null;
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String name= rs.getString("docName");
			String dept= rs.getString("department");
			String time= rs.getString("timings");
			String res= name+"-"+dept+"-"+time;
			med.add(res);
		}
		rs.close();
		ps.close();
		return med;

	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
}


