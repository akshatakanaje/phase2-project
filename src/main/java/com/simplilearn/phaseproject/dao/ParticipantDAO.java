package com.simplilearn.phaseproject.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.phaseproject.model.Participant;
import com.simplilearn.phaseproject.utility.DB;

public class ParticipantDAO implements DAO<Participant>{
	
	DB db  = new DB();

	// get all participant table records
	public List<Participant> getAll() {
		List<Participant> participantList = new ArrayList<Participant>();
		db.init();
		try {
			String sql = "select * from participant";
			ResultSet res = db.executeQuery(sql);
			while(res.next()) {
				//set or map result set to object
				Participant participant = new Participant();
				participant.setBatchId(res.getInt("batchId"));
				participant.setUserName(res.getString("userName"));
				participant.setPhoneNumber(res.getString("phoneNumber"));
				participant.setEmail(res.getString("email"));
				participant.setGender(res.getString("gender"));
				
				participantList.add(participant);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong :: " + e.getMessage());
		} finally {
			db.destroy();
		}
		return participantList;
	}
		
		
	//get one participant  record
	public Participant getOne(long id) {
		Participant participant = new Participant();
		db.init();
		try {
			String sql = "select * from participant where partId="+id;
			ResultSet res = db.executeQuery(sql);
			while(res.next()) {
				participant.setPartId(res.getInt("partId"));
				participant.setBatchId(res.getInt("batchId"));
				participant.setUserName(res.getString("userName"));
				participant.setPhoneNumber(res.getString("phoneNumber"));
				participant.setEmail(res.getString("email"));
				participant.setGender(res.getString("gender"));
			}		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong :: " + e.getMessage());
		} finally {
			db.destroy();
		}
		return participant;
	}


	
	//save all participant table record
	public int save(Participant object) {
		db.init();
		int rowsAffected = 0;
		try {
			String sql = String.format(
					"insert into participant values(null, %d, '%s', '%s', '%s', '%s')",
					object.getBatchId(),
					object.getUserName(),
					object.getPhoneNumber(),
					object.getEmail(),
					object.getGender()
			);	
			rowsAffected = db.executeUpdate(sql);
			String message = ( rowsAffected> 0) ? "Participant saved successfully" : "Unable to save participant";
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong :: " + e.getMessage());
		} finally {
			db.destroy();
		}
		return rowsAffected;
	}
		
		
	//update participant table record
	public int update(Participant object)  {
		db.init();
		int rowsAffected = 0;
		try {
			String sql = String.format(
					"update participant set partId=%d, batchId=%d, userName='%s', phoneNumber='%s', email='%s', gender='%s' where partId=%d",		
					object.getPartId(),
					object.getBatchId(),
					object.getUserName(),
					object.getPhoneNumber(),
					object.getEmail(),
					object.getGender(),
					object.getPartId()
			);
			rowsAffected = db.executeUpdate(sql);
			String message = ( rowsAffected > 0) ? "participant upadted successfully" : "Unable to update participant";
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong :: " + e.getMessage());
		} finally {
			db.destroy();
		}
		return rowsAffected;
	}
		
		
	//delete participant table record
	public int delete(long id) {
		
		db.init();
		int rowsAffected = 0;
		try {
			String sql = "delete from participant where partId = " + id;
			rowsAffected = db.executeUpdate(sql);
			String message = (rowsAffected > 0) ? "Participant deleted successfully" : "Unable to delete participant";
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception is: " + e);
		}
		return rowsAffected;
	}
}
