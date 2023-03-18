package com.training.inventory;

import java.sql.SQLException;
import java.util.Comparator;


import com.training.inventory.controller.CarController;
import com.training.inventory.dao.CarDao;
import com.training.inventory.model.Car;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	CarController carController=CarController.getController();
		Comparator<Car> comparator=(p1,p2)->((int)(p1.getPrice()-p2.getPrice()));
	
			try {
				System.out.println("Show all Car");
				carController.findAll().stream().forEach(p->System.out.println(p));
				System.out.println("Display Car details for id=1");
				Car car=carController.findOneById(1);
				System.out.println("Original Car: \n"+car);
				System.out.println("update Car Price to 3500 for Car id 1");
				car.setPrice(3500);
				if(carController.update(1, car)) {
					System.out.println("Updated Car: \n"+car);
				}else {
					System.out.println("No Car found for update");
				}
				System.out.println("Delete Car where id  99");
				if(carController.delete(999)) {
					System.out.println("Deleted Car with id=99");
				}else {
					System.out.println("No Car found for delete");
				}
				System.out.println("Create new Car ");
				car.setCarId(999);
				car.setCarName("Nimbuz");
				car.setCarBand("Bmw");
				car.setPrice(3300);
				car.setColor("Blue");
				car.setStatus("Availble");
				System.out.println("Created new Car:");
				System.out.println(carController.create(car));
				System.out.println("Show all Car");
				
				carController.findAll().stream().sorted(comparator).forEach(p->System.out.println(p));
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		 
    
}
    
}
