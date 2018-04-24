package com.zrgj.POJO;

public class Facility_type {
private int FT_ID;
private String FT_NAME;
public int getFT_ID() {
	return FT_ID;
}
public void setFT_ID(int fT_ID) {
	FT_ID = fT_ID;
}
public String getFT_NAME() {
	return FT_NAME;
}
public void setFT_NAME(String fT_NAME) {
	FT_NAME = fT_NAME;
}
@Override
public String toString() {
	return "Facility_type [FT_ID=" + FT_ID + ", FT_NAME=" + FT_NAME + "]";
}

}

