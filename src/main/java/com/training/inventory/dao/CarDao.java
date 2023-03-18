package com.training.inventory.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.inventory.model.Car;

import com.training.inventory.util.DBConnectionUtil;

public class CarDao implements CList<Car> {
	
	
	
	
	private  static  CarDao carDao;

	private CarDao() {
		super();
	}

	public static CarDao getCarDao() {
		if (carDao == null) {
			synchronized (CarDao.class) {
				if (carDao == null) {
					carDao = new CarDao();
				}
			}
		}

		return carDao;
	}

	@Override
	public List<Car> findAll() throws SQLException {
          
		List<Car> carList = new ArrayList<>();
		final Connection connection = DBConnectionUtil.getConnection();
		final Statement selectAllCar = connection.createStatement();
		final ResultSet resultSet = selectAllCar
				.executeQuery("SELECT car_id,car_name, brand_name ,price, color, status  FROM Cars");
		while (resultSet.next()) {
			Car car = new Car(resultSet.getInt("car_id"),
					resultSet.getString("car_name"),
					resultSet.getString("brand_name"),
					resultSet.getDouble("Price"), 
					resultSet.getString("color"),
					resultSet.getString("status")
					);
			carList.add(car);
			
		}
			
		return 	carList;
	}

	@Override
	public Car findById(long id) throws SQLException {

		Car car = null;
		final Connection connection = DBConnectionUtil.getConnection();
		final String select = "SELECT car_id,car_name, brand_name ,price, color, status FROM Cars" + " where car_id = ?";
		final PreparedStatement preparedStatement = connection.prepareStatement(select);
		preparedStatement.setLong(1, id);

		final ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			car = new Car(resultSet.getInt("car_id"),
					resultSet.getString("car_name"),
					resultSet.getString("brand_name"),
					resultSet.getDouble("Price"), 
					resultSet.getString("color"),
					resultSet.getString("status")
					);

		}

		resultSet.close();
		preparedStatement.close();
		connection.close();
		return car;
	}

	@Override
	public Car create(Car car) throws SQLException {
		final Connection connection = DBConnectionUtil.getConnection();
		final String insertUpdate = "insert into Cars values(?,?,?,?,?,?)";
		final PreparedStatement preparedStatement = connection.prepareStatement(insertUpdate);
		preparedStatement.setInt(1, car.getCarId());
		preparedStatement.setString(2, car.getCarName());
		preparedStatement.setString(3, car.getCarBand());
		preparedStatement.setDouble(4, car.getPrice());
		preparedStatement.setString(5, car.getColor());
		preparedStatement.setString(6, car.getStatus());
		final int noOrRows = preparedStatement.executeUpdate();
		if (noOrRows > 0) {
			return car;
		}

		preparedStatement.close();
		connection.close();
		throw new SQLIntegrityConstraintViolationException("Duplicate Primary key");
	}

	@Override
	public boolean update(long id, Car car) throws SQLException {
		final Connection connection = DBConnectionUtil.getConnection();
		final String updateRecord = "update Cars set "
				+" price=?,"
				+" color=?"
				+" where car_id=?";
		final PreparedStatement preparedStatement = connection.prepareStatement(updateRecord);
		preparedStatement.setDouble(1, car.getPrice());
		preparedStatement.setString(2, car.getColor());
		preparedStatement.setInt(3, car.getCarId());
		if (preparedStatement.executeUpdate() > 0) {
			return true;
		}
		preparedStatement.close();
		connection.close();
		return false;
		
	}

	@Override
	public boolean delete(long id) throws SQLException {
		final Connection connection = DBConnectionUtil.getConnection();
		final String deleteRecord = "delete from Cars where Car_id=?";
		final PreparedStatement preparedStatement = connection.prepareStatement(deleteRecord);
		preparedStatement.setLong(1, id);
		if (preparedStatement.executeUpdate() > 0) {
			return true;
		}
		preparedStatement.close();
		connection.close();
		return false;
		
	}
}
