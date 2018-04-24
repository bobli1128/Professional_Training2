package com.zrgj.POJO;

public class MeetingRoom {
private int MR_ID;
private String MR_ADDRESS;
private String MR_NAME;
private int MR_MANAGER;
private int MR_COUNT;
private int MR_MONTH;
private String MR_DESC;
private String MR_STATUS;
public int getMR_ID() {
	return MR_ID;
}
public void setMR_ID(int mR_ID) {
	MR_ID = mR_ID;
}
public String getMR_ADDRESS() {
	return MR_ADDRESS;
}
public void setMR_ADDRESS(String mR_ADDRESS) {
	MR_ADDRESS = mR_ADDRESS;
}
public String getMR_NAME() {
	return MR_NAME;
}
public void setMR_NAME(String mR_NAME) {
	MR_NAME= mR_NAME;
}
public int getMR_MANAGER() {
	return MR_MANAGER;
}
public void setMR_MANAGER(int mR_MANAGER) {
	MR_MANAGER = mR_MANAGER;
}
public int getMR_COUNT() {
	return MR_COUNT;
}
public void setMR_COUNT(int mR_COUNT) {
	MR_COUNT = mR_COUNT;
}
public int getMR_MONTH() {
	return MR_MONTH;
}
public void setMR_MONTH(int mR_MONTH) {
	MR_MONTH = mR_MONTH;
}
public String getMR_DESC() {
	return MR_DESC;
}
public void setMR_DESC(String mR_DESC) {
	MR_DESC = mR_DESC;
}
public String getMR_STATUS() {
	return MR_STATUS;
}
public void setMR_STATUS(String mR_STATUS) {
	MR_STATUS = mR_STATUS;
}
@Override
public String toString() {
	return "MeetingRoom [MR_ID=" + MR_ID + ", MR_ADDRESS=" + MR_ADDRESS + ", MR_NAME=" + MR_NAME + ", MR_MANAGER="
			+ MR_MANAGER + ", MR_COUNT=" + MR_COUNT + ", MR_MONTH=" + MR_MONTH + ", MR_DESC=" + MR_DESC + ", MR_STATUS="
			+ MR_STATUS + "]";
}

}
