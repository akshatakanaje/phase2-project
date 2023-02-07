package com.simplilearn.phaseproject.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.simplilearn.phaseproject.dao.ParticipantDAO;
import com.simplilearn.phaseproject.model.Response;
import com.simplilearn.phaseproject.model.Batch;
import com.simplilearn.phaseproject.model.Participant;

@WebServlet("/participant")
public class ParticipantCrudController extends HttpServlet{
	
	ParticipantDAO participantDAO = new ParticipantDAO();
	Response responseDto = new Response();
	
	/**
	 * Get All OR get One participant
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		List<Participant> participantList = new ArrayList<Participant>();
		
		if(id != null) {
			Participant participant = participantDAO.getOne(Long.parseLong(id));
			participantList.add(participant);
		} else {
			participantList = participantDAO.getAll();
		}
		String jsonResponse = new Gson().toJson(participantList);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
	
	
	/**
	 * Create a participant
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Participant participant = new Participant();
			participant.setBatchId(Integer.parseInt(request.getParameter("batchId")));
			participant.setUserName(request.getParameter("userName"));
			participant.setPhoneNumber(request.getParameter("phoneNumber"));
			participant.setEmail(request.getParameter("email"));
			participant.setGender(request.getParameter("gender"));
			
			participantDAO.save(participant);
			responseDto.setStatus("Success");
			responseDto.setMessage("Participant is created successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			responseDto.setMessage("Failed create participant data");
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
	 * Update a participant
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Participant participant = new Participant();
			participant.setPartId(Integer.parseInt(request.getParameter("partId")));
			participant.setBatchId(Integer.parseInt(request.getParameter("batchId")));
			participant.setUserName(request.getParameter("userName"));
			participant.setPhoneNumber(request.getParameter("phoneNumber"));
			participant.setEmail(request.getParameter("email"));
			participant.setGender(request.getParameter("gender"));
			
			participantDAO.update(participant);
			responseDto.setStatus("Success");
			responseDto.setMessage("Participant is updated successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			responseDto.setMessage("Failed update participant data");
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
	 * Delete a participant
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		try {
			int rowAffected = participantDAO.delete(Integer.parseInt(id));
			if(rowAffected > 0) {
				responseDto.setStatus("Success");
				responseDto.setMessage("Participant is deleted successfully");
			}			
		}  catch (Exception e) {
			responseDto.setStatus("Failed");
			responseDto.setMessage("Failed deletion of a participant");
		}
		String jsonResponse = new Gson().toJson(responseDto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
}
