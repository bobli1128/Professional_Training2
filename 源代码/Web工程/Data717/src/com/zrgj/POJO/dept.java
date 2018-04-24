package com.zrgj.POJO;

public class dept {
   private int departmentid;
   private String departmentname;
   public int getDepartmentid() {
	return departmentid;
}
public void setDepartmentid(int departmentid) {
	this.departmentid = departmentid;
}
public String getDepartmentname() {
	return departmentname;
}
public void setDepartmentname(String departmentname) {
	this.departmentname = departmentname;
}
@Override
public String toString() {
	return "dept [departmentid=" + departmentid + ", departmentname=" + departmentname + "]";
}

   
}
