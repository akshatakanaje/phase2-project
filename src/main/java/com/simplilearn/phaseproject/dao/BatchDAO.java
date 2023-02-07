package com.simplilearn.phaseproject.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.phaseproject.model.Batch;
import com.simplilearn.phaseproject.utility.DB;

public class BatchDAO implements DAO<Batch>{
	
	DB db  = new DB();

	// get all batch table records
	public List<Batch> getAll() {
		List<Batch> batchList = new ArrayList<Batch>();
		db.init();
		try {
			String sql = "select * from batch";
			ResultSet res = db.executeQuery(sql);
			while(res.next()) {
				Batch batch = new Batch();
				batch.setBatchName(res.getString("batchName"));
			
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				batch.setStartDate(format.parse(res.getString("startDate")));
				batch.setEndDate(format.parse(res.getString("endDate")));
				
				batchList.add(batch);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong :: " + e.getMessage());
		} finally {
			db.destroy();
		}
		return batchList;
	}

	
	//get one batch table record
	public Batch getOne(long id) {
		Batch batch = new Batch();
		db.init();
		try {
			String sql = "select * from batch where batchId="+id;
			ResultSet res = db.executeQuery(sql);
			while(res.next()) {
				batch.setBatchId(res.getInt("batchId"));
				batch.setBatchName(res.getString("batchName"));
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				batch.setStartDate(format.parse(res.getString("startDate")));
				batch.setEndDate(format.parse(res.getString("endDate")));
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong :: " + e.getMessage());
		} finally {
			db.destroy();
		}
		return batch;
	}

	
	//save all batch table record
	public int save(Batch object) {
		db.init();
		int rowsAffected = 0;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startDate = format.format(object.getStartDate());
			String endDate = format.format(object.getEndDate());
			
			String sql = String.format(
					"insert into batch values(null, '%s', '%s', '%s')",
					object.getBatchName(),
					startDate,
					endDate
			);
			rowsAffected = db.executeUpdate(sql);
			String message = ( rowsAffected> 0) ? "Batch saved successfully" : "Unable to save batch";
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong :: " + e.getMessage());
		} finally {
			db.destroy();
		}
		return rowsAffected;
	}
		
		

	//update batch table record
	public int update(Batch object) {
		db.init();
		int rowsAffected = 0;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startDate = format.format(object.getStartDate());
			String endDate = format.format(object.getEndDate());
			
			String sql = String.format(
					"update batch set batchName='%s', where batchId=%d",
					object.getBatchName(),
					startDate,
					endDate
			);
			rowsAffected = db.executeUpdate(sql);
			String message = ( rowsAffected > 0) ? "Batch upadted successfully" : "Unable to update batch";
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong :: " + e.getMessage());
		} finally {
			db.destroy();
		}
		return rowsAffected;
	}
		
		

	//delete batch table record
	public int delete(long id) {
		
		db.init();
		int rowsAffected = 0;
		try {
			String sql = "delete from batch where batchId = " + id;
			rowsAffected = db.executeUpdate(sql);
			String message = (rowsAffected > 0) ? "Batch deleted successfully" : "Unable to delete batch";
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception is: " + e);
		}
		return rowsAffected;
	}
}
