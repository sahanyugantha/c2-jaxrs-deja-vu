package com.solent2.againjaxrs.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.solent2.againjaxrs.dao.CarDao;
import com.solent2.againjaxrs.model.Car;

public class CarTest {
	
	@Test
	public void sampleTest() {
		
		int expected = 3;
		
		CarDao carDao = new CarDao();
		List<Car> carList = carDao.fakeData();
		
		int actual = carList.size();
		
		assertEquals(expected, actual);
	}
	
	
//	@Test
//	public void testFetchAll() {
//		int expected = 13;
//		
//		CarDao carDao = new CarDao();
//		List<Car> carList = carDao.getAll();
//		
//		int actual = carList.size();
//		
//		assertEquals(expected, actual);		
//		
//	}
	
//	@Test
//	public void testaddCar() {
//		int expected = 1;
//		Car car = new Car();
//		car.setModel("Jaguar X");
//		car.setBrand("Jaguar");
//		
//		CarDao carDao = new CarDao();
//		int actual = carDao.addCar(car);
//		
//		assertEquals(expected, actual);
//		
//	}
	
//	@Test
//	public void testUpdateCar() {
//		int expected = 1;
//		Car car = new Car();
//		car.setId(14);
//		car.setModel("xyz");
//		car.setBrand("JAGUAR");
//		
//		CarDao carDao = new CarDao();
//		int actual = carDao.updatCar(car);
//		
//		assertEquals(expected, actual);
//	}

}
