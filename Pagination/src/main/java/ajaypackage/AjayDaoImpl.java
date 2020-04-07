package ajaypackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AjayDaoImpl{

public Integer getPageCount() {
Connection conn = null;
PreparedStatement stmt = null;
ResultSet rs = null;
Integer finalCount = 0;
try
{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost/form_registration", "root", "root");

stmt = conn.prepareStatement("select count(1) from records");
rs = stmt.executeQuery();

while(rs.next())
finalCount = rs.getInt(1);
}catch(Exception e)
{
e.printStackTrace();
}
finally
{
try
{
if(conn != null)
conn.close();
if(stmt != null)
stmt.close();
if(rs != null)
rs.close();
}catch(Exception e)
{
e.printStackTrace();
}
}

return finalCount;
}

public List<Ajay> getTableData(Integer limit)
{
Connection conn = null;
PreparedStatement stmt = null;
ResultSet rs = null;
List<Ajay> finalCount = new ArrayList<Ajay>();
try
{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost/form_registration", "root", "root");

stmt = conn.prepareStatement("select username,password from records limit 5");
rs = stmt.executeQuery();

while(rs.next())
{
Ajay ajay = new Ajay();
ajay.setUsername(rs.getString(1));
ajay.setPassword(rs.getString(2));
finalCount.add(ajay);
}
}catch(Exception e)
{
e.printStackTrace();
}
finally
{
try
{
if(conn != null)
conn.close();
if(stmt != null)
stmt.close();
if(rs != null)
rs.close();
}catch(Exception e)
{
e.printStackTrace();
}
}

return finalCount;
}

public List<Ajay> getTableData2(Integer limit)
{
Connection conn = null;
PreparedStatement stmt = null;
ResultSet rs = null;
List<Ajay> finalCount = new ArrayList<Ajay>();
try
{
Integer internalLimit = limit * 5 - 5;
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost/form_registration", "root", "root");

stmt = conn.prepareStatement("select username,password from records limit ?,5");
stmt.setInt(1, internalLimit);
rs = stmt.executeQuery();

while(rs.next())
{
Ajay ajay = new Ajay();
ajay.setUsername(rs.getString(1));
ajay.setPassword(rs.getString(2));
finalCount.add(ajay);
}
}catch(Exception e)
{
e.printStackTrace();
}
finally
{
try
{
if(conn != null)
conn.close();
if(stmt != null)
stmt.close();
if(rs != null)
rs.close();
}catch(Exception e)
{
e.printStackTrace();
}
}

return finalCount;
}

}
