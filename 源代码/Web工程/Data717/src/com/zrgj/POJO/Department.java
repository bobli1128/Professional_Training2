package com.zrgj.POJO;

public class Department {
private int DE_ID;
private String DE_NAME;
public int getDE_ID() {
	return DE_ID;
}
public void setDE_ID(int dE_ID) {
	DE_ID = dE_ID;
}
public String getDE_NAME() {
	return DE_NAME;
}
public void setDE_NAME(String dE_NAME) {
	DE_NAME = dE_NAME;
}
@Override
public String toString() {
	return "Department [DE_ID=" + DE_ID + ", DE_NAME=" + DE_NAME + "]";
}

}
