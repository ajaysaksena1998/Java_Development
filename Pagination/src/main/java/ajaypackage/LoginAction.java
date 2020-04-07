package ajaypackage;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;



@Namespaces(value={@Namespace("/User"),@Namespace("/")})
public class LoginAction {

@Action(value = "login", results = {
@Result(name = "SUCCESS", location = "/welcome.jsp"),
@Result(name = "ERROR", location = "/error.jsp") })
public String test2() throws Exception {
AjayDaoImpl ajayDao = new AjayDaoImpl();
Integer totalCount = ajayDao.getPageCount();
totalCount = totalCount / 5;
List<Integer> pageList = new ArrayList<Integer>();
for(int i = 1; i <= totalCount ; i++)
{
pageList.add(i);
}
lastList = pageList;
return "SUCCESS";
}

@Action(value = "showData", results = {
@Result(name = "SUCCESS", location = "/welcome.jsp"),
@Result(name = "ERROR", location = "/error.jsp") })
public String test1()
{
AjayDaoImpl ajayDao = new AjayDaoImpl();
if(page == 1)
setAjay(ajayDao.getTableData(page));
else
setAjay(ajayDao.getTableData2(page));
Integer totalCount = ajayDao.getPageCount();
totalCount = totalCount / 5;
List<Integer> pageList = new ArrayList<Integer>();
for(int i = 1; i <= totalCount ; i++)
{
pageList.add(i);
}
lastList = pageList;
return "SUCCESS";
}

//Java Bean to hold the form parameters
private Integer page;
private String name;
private String pwd;
private List<Integer> lastList;
private List<Ajay> ajay;
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getPwd() {
return pwd;
}
public void setPwd(String pwd) {
this.pwd = pwd;
}
public List<Integer> getLastList() {
return lastList;
}
public void setLastList(List<Integer> lastList) {
this.lastList = lastList;
}

public Integer getPage() {
return page;
}

public void setPage(Integer page) {
this.page = page;
}

public List<Ajay> getAjay() {
return ajay;
}

public void setAjay(List<Ajay> ajay) {
this.ajay = ajay;
}
}
