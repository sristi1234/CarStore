package com.training.inventory.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

public class DBConnectionUtilTest {
	
	
	
	@Test
	public void  connectionIsNotNull() throws SQLException {
		
		
		assertNotNull(DBConnectionUtil.getConnection());
		
	}
	
	
	@Test
	public void testConnectionISNotClosed() throws SQLException {
		
		assertFalse(DBConnectionUtil.getConnection().isClosed());
	}

}
