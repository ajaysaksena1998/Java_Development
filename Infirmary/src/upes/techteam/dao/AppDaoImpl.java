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
import upes.techteam.models.Patient;
import upes.techteam.models.Staff;
import upes.techteam.models.Stock;

public class AppDaoImpl implements AppDao {

	private DataSource dataSource;

	public AppDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insertPatient(HttpServletRequest request) throws ParseException {
		String sql = "INSERT INTO Patient(date,name,age,gender,sapid,course,temp,bp,weight,chronic_ailment,allergies,travel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		String doc = "INSERT INTO doctor(date,temp,bp,weight,chronic_ailment,allergies,sapid) value(?,?,?,?,?,?,?)";
		Connection conn = null;
		Connection object = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, request.getParameter("date"));
			ps.setString(2, request.getParameter("name"));
			ps.setInt(3, Integer.parseInt(request.getParameter("age")));
			ps.setString(4, request.getParameter("gender"));
			ps.setInt(5, Integer.parseInt(request.getParameter("sapid")));
			ps.setString(6, request.getParameter("course"));
			ps.setString(7, request.getParameter("temp"));
			ps.setString(8, request.getParameter("bp"));
			ps.setString(9, request.getParameter("weight"));
			ps.setString(10, request.getParameter("chronic_ailment"));
			ps.setString(11, request.getParameter("allergies"));
			ps.setString(12, request.getParameter("travel"));
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
				prepare.setString(2, request.getParameter("temp"));
				prepare.setString(3, request.getParameter("bp"));
				prepare.setString(4, request.getParameter("weight"));
				prepare.setString(5, request.getParameter("chronic_ailment"));
				prepare.setString(6, request.getParameter("allergies"));
				prepare.setInt(7, Integer.parseInt(request.getParameter("sapid")));
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
		String SQL = "Select * from Patient";
		List<Patient> listUsers = new ArrayList<Patient>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Patient temp = new Patient(rs.getInt("Stuid"), rs.getString("date"), rs.getString("name"),
						rs.getInt("age"), rs.getString("gender"), rs.getInt("sapid"), rs.getString("course"),
						rs.getString("medicine"), rs.getString("temp"), rs.getString("bp"), rs.getString("weight"),
						rs.getString("chronic_ailment"), rs.getString("allergies"), rs.getString("travel"));
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
		String SQL = "Select * from Stock";
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
				Doctor temp = new Doctor(rs.getInt("stuid"), rs.getString("date"), rs.getString("temp"),
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
		String sql = "UPDATE patient SET medicine =? WHERE sapid=? AND medicine='default'";
		String obj = "DELETE FROM doctor WHERE sapid=?";
		Connection conn = null;
		Connection onn = null;
		Connection insert = null;
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
		try {
			insert = dataSource.getConnection();
			PreparedStatement in = insert.prepareStatement(query);
			in.setInt(1, stuid);
			in.setString(2, date);
			in.setString(3, request.getParameter("sapid"));
			in.setString(4, request.getParameter("medicine"));
			in.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (insert != null) {
				try {
					insert.close();
				} catch (SQLException e) {
					System.out.println("connection failed");
				}

				try {
					conn = dataSource.getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, request.getParameter("medicine"));
					ps.setString(2, request.getParameter("sapid"));
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

	public void addMedicine(List<String> medicine, List<Integer> stock) {

		Connection demo = null;
		Connection conn = null;
		Connection up = null;
		for (int i = 0; i < medicine.size(); i++) {
			for (int j = 0; j < stock.size(); j++) {
				if (i == j) {
					String sql = "select * from stock where Medicine=?";
					String doc = "INSERT INTO stock(Medicine,Stock) value(?,?)";

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

}
