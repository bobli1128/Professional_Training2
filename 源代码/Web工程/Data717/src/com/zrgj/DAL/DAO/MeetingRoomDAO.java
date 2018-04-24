package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.MeetingRoom;

public interface MeetingRoomDAO {
public List<MeetingRoom> read() throws Exception;
public MeetingRoom readByid(int id) throws Exception;
public void insert(MeetingRoom m) throws Exception;
public void delete(int id) throws Exception;
public void update(MeetingRoom m) throws Exception;
}
