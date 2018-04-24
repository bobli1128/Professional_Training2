package com.zrgj.POJO;

import java.sql.Timestamp;

public class MRApplyInfo {
	private int MI_ID;
	private String MI_TITLE;
	private int MI_DEGREE;
	private String MI_CONTENT;
	private Timestamp MI_START_TIME;
	private Timestamp MI_END_TIME;	
	private Timestamp MI_BOOK_TIME;
	private int MI_COUNT;
	private String MI_ORDER;
	private String MI_ROOM;
	private String MI_STATUS;
	private String MI_DEPA;
	private int MI_USER_ID;
	private int MI_MEETROOM_ID;
	public int getMI_ID() {
		return MI_ID;
	}
	public void setMI_ID(int mI_ID) {
		this.MI_ID = mI_ID;
	}
	public String getMI_TITLE() {
		return MI_TITLE;
	}
	public void setMI_TITLE(String mI_TITLE) {
		this.MI_TITLE = mI_TITLE;
	}
	public int getMI_DEGREE() {
		return MI_DEGREE;
	}
	public void setMI_DEGREE(int mI_DEGREE) {
		this.MI_DEGREE = mI_DEGREE;
	}
	public String getMI_CONTENT() {
		return MI_CONTENT;
	}
	public void setMI_CONTENT(String mI_CONTENT) {
		this.MI_CONTENT = mI_CONTENT;
	}
	public Timestamp getMI_START_TIME() {
		return MI_START_TIME;
	}
	public void setMI_START_TIME(Timestamp mI_START_TIME) {
		this.MI_START_TIME = mI_START_TIME;
	}
	public Timestamp getMI_END_TIME() {
		return MI_END_TIME;
	}
	public void setMI_END_TIME(Timestamp mI_END_TIME) {
		this.MI_END_TIME = mI_END_TIME;
	}
	public Timestamp getMI_BOOK_TIME() {
		return MI_BOOK_TIME;
	}
	public void setMI_BOOK_TIME(Timestamp mI_BOOK_TIME) {
		this.MI_BOOK_TIME = mI_BOOK_TIME;
	}
	public int getMI_COUNT() {
		return MI_COUNT;
	}
	public void setMI_COUNT(int mI_COUNT) {
		this.MI_COUNT = mI_COUNT;
	}
	public String getMI_ORDER() {
		return MI_ORDER;
	}
	public void setMI_ORDER(String mI_ORDER) {
		this.MI_ORDER = mI_ORDER;
	}
	public String getMI_ROOM() {
		return MI_ROOM;
	}
	public void setMI_ROOM(String mI_ROOM) {
		this.MI_ROOM = mI_ROOM;
	}
	public String getMI_STATUS() {
		return MI_STATUS;
	}
	public void setMI_STATUS(String mI_STATUS) {
		this.MI_STATUS = mI_STATUS;
	}
	public int getMI_MEETROOM_ID() {
		return MI_MEETROOM_ID;
	}
	public void setMI_MEETROOM_ID(int mI_MEETROOM_ID) {
		this.MI_MEETROOM_ID = mI_MEETROOM_ID;
	}
	public int getMI_USER_ID() {
		return MI_USER_ID;
	}
	public void setMI_USER_ID(int mI_USER_ID) {
		this.MI_USER_ID = mI_USER_ID;
	}
	
	public String getMI_DEPA() {
		return MI_DEPA;
	}
	public void setMI_DEPA(String mI_DEPA) {
		this.MI_DEPA = mI_DEPA;
	}
	@Override
	public String toString() {
		return "MRApplyInfo [MI_ID=" + MI_ID + ", MI_TITLE=" + MI_TITLE + ", MI_DEGREE=" + MI_DEGREE + ", MI_CONTENT="
				+ MI_CONTENT + ", MI_START_TIME=" + MI_START_TIME + ", MI_END_TIME=" + MI_END_TIME + ", MI_BOOK_TIME="
				+ MI_BOOK_TIME + ", MI_COUNT=" + MI_COUNT + ", MI_ORDER=" + MI_ORDER + ", MI_ROOM=" + MI_ROOM
				+ ", MI_STATUS=" + MI_STATUS + ", MI_DEPA=" + MI_DEPA + ", MI_USER_ID=" + MI_USER_ID
				+ ", MI_MEETROOM_ID=" + MI_MEETROOM_ID + "]";
	}
	
}
