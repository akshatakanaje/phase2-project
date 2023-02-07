package com.simplilearn.phaseproject.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.simplilearn.phaseproject.dao.BatchDAO;
import com.simplilearn.phaseproject.model.Response;
import com.simplilearn.phaseproject.model.Batch;


@WebServlet("/batch")
public class BatchCrudController extends HttpServlet{
	
	BatchDAO batchDAO = new BatchDAO();
	Response responseDto = new Response();
	
	/**
	 * Get All OR get One batch.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		List<Batch> batchList = new ArrayList<Batch>();
		
		if(id != null) {
			Batch batch = batchDAO.getOne(Long.parseLong(id));
			batchList.add(batch);
		} else {
			batchList = batchDAO.getAll();
		}
		String jsonResponse = new Gson().toJson(batchList);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
	
	
	/**
	 * Create a batch.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Batch batch = new Batch();
			batch.setBatchName(request.getParameter("batchName"));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			batch.setStartDate(format.parse(request.getParameter("startDate")));
			batch.setEndDate(format.parse(request.getParameter("endDate")));
			
			batchDAO.save(batch);
			responseDto.setStatus("Success");
			responseDto.setMessage("Categrory is created successfully!");			
		} catch (Exception e) {
			e.printStackTrace();
			responseDto.setMessage("Failed create batch data");
			responseDto.setStatus("Failed");
		}
		String jsonResponse = new Gson().toJson(responseDto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
	
	
	/**
	 * Update a batch.
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Batch batch = new Batch();
			batch.setBatchName(request.getParameter("batchName"));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			batch.setStartDate(format.parse(request.getParameter("startDate")));
			batch.setEndDate(format.parse(request.getParameter("endDate")));
			
			batchDAO.update(batch);
			responseDto.setStatus("Success");
			responseDto.setMessage("Batch is created successfully!");			
		} catch (Exception e) {
			e.printStackTrace();
			responseDto.setMessage("Failed create batch data");
			responseDto.setStatus("Failed");
		}
		String jsonResponse = new Gson().toJson(responseDto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
	
	
	/**
	 * Delete a category
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		try {
			int rowAffected = batchDAO.delete(Integer.parseInt(id));
			if(rowAffected > 0) {
				responseDto.setStatus("Success");
				responseDto.setMessage("Batch is deleted successfully");
			}			
		}  catch (Exception e) {
			responseDto.setStatus("Failed");
			responseDto.setMessage("Failed deletion of a batch");
		}
		String jsonResponse = new Gson().toJson(responseDto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
}
