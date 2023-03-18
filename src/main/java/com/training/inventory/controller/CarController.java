package com.training.inventory.controller;

import java.util.List;

import com.training.inventory.dao.CarDao;
import com.training.inventory.model.Car;


public class CarController implements IController<Car> {
	
	private static CarController controller;
	private CarDao carDao ;

	private CarController() {
		super();
		carDao = CarDao.getCarDao();
	}

	public static CarController getController() {
		if (controller == null) {
			synchronized (CarController.class) {
				if (controller == null) {
					controller = new CarController();
				}
			}
		}
		return controller;
	}

	@Override
	public List<Car> findAll() throws Exception {

		return carDao.findAll();
	}

	@Override
	public Car findOneById(long id) throws Exception {

		return carDao.findById(id);
	}

	@Override
	public Car create(Car Car) throws Exception {

		return carDao.create(Car);
	}

	@Override
	public boolean update(long id, Car t) throws Exception {

		return carDao.update(id, t);
	}

	@Override
	public boolean delete(long id) throws Exception {
		return carDao.delete(id);
	}

	

}
