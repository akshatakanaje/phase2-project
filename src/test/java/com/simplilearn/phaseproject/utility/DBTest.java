package com.simplilearn.phaseproject.utility;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.ResultSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DBTest {
	
	DB db;

	@BeforeEach
	public  void setUp() {
		db = new DB();
	}

	@AfterEach
	public  void cleanUp() {
		db.destroy();
	}

	@Test
	@DisplayName("DB Connection Test")
	public void testConnection1() {
		db.init();
		assertNotNull(db.getConnection());
	}

	@Test
	@DisplayName("Close DB Connection Test")
	public void testConnection2() {
		assertNull(db.getConnection());
	}

}
