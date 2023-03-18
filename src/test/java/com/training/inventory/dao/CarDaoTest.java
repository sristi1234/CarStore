package com.training.inventory.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.training.inventory.model.Car;

public class CarDaoTest {

	private CarDao carDao;
	private Car dummyCar;

	@Before
	public void beforeEach() {

		carDao = CarDao.getCarDao();
		dummyCar = new Car(1,"BMW X5", "BMW", 1000, "Black", "Available");
	}

	@Test
	public void testCarDaoIsNotNull() {

		assertNotNull(carDao);
	}

	@Test
	public void testCarListIsNotNull() throws SQLException {

		List<Car> carList = carDao.findAll();
		assertNotNull(carList);
	}

	@Test
	public void testCarListIsNotEmpty() throws SQLException {

		List<Car> carList = carDao.findAll();
		assertNotEquals(0, carList.size());
	}

	@Test
	public void testRecordNotMismatched() throws SQLException {

		List<Car> carList = carDao.findAll();
		System.out.println(carList.size());
		assertEquals(5, carList.size());
	}

	@Test
	public void testFindAll() throws SQLException {

		assertNotNull(carDao.findAll());
	}

	@Test
	public void testFindById() {

		try {
			assertEquals(dummyCar, carDao.findById(1));
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	
	
	
	
	//Verify that its a product value from data 
		@Test
		public void testProductMatch() {
			try {
				assertEquals(dummyCar, carDao.findById(1));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// it should return null/exception for duplicate record
		@Ignore
		@Test(expected = SQLIntegrityConstraintViolationException.class)
		public void testInsertDuplicateRecord() {
			try {
//				assertNull(productDao.create(dummyCar));
				carDao.create(dummyCar);
			} catch (Exception e) {
				System.out.println(e.getMessage());
//				e.printStackTrace();
			}
		}

		@Test(expected = NullPointerException.class)
		public void testNullPointerException() {
			String name = null;
			name.length();
		}

		// it should insert a new record
		@Test
		public void testNewUniqueRecord() {
			try {
				dummyCar.setCarId(99);;
				assertNotNull(carDao.create(dummyCar));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//update must return true 
		@Test
		public void testUpdateTrue() {
			try {
				dummyCar.setColor("Red");
				assertTrue(carDao.update(1, dummyCar));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//delete must return true 
		@Test
		public void testDeleteTrue() {
			try {
					assertTrue(carDao.delete(99));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		

}
