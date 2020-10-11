package com.solent2.againjaxrs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.jdbc.Driver;
import com.solent2.againjaxrs.CarResource;
import com.solent2.againjaxrs.config.DatabaseConfiguration;
import com.solent2.againjaxrs.model.CAR_TYPE;
import com.solent2.againjaxrs.model.Car;

public class CarDao {
	
	private Logger logger = LogManager.getLogger(CarDao.class);
	
	private List<Car> fakeData(){
		List<Car> carList = new ArrayList<Car>();
		
		carList.add(new Car(0, "Axio", "Toyota", 2020, CAR_TYPE.SEDAN));
		carList.add(new Car(1, "WagonR", "Suzuki", 2018, CAR_TYPE.WAGON));
		carList.add(new Car(2, "Prado", "Toyota", 2020, CAR_TYPE.SUV));
		
		return carList;
	}
	
	private List<Car> getDataFromDb() {
		
		logger.info("Car data fetched by user");
		
		try {
			
			Connection conn = DatabaseConfiguration.getInstance().getDbConnection();
			
			String sql = "SELECT * FROM `tbl_car`";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			List<Car> carList = new ArrayList<Car>();
				
			while(rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setModel(rs.getString("model"));
				car.setBrand(rs.getString("brand"));
				car.setYear(rs.getInt("year"));
				car.setType(CAR_TYPE.valueOf(rs.getString("type")));
				carList.add(car);
			}
			
			return carList;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Car> getAll(){
		//List<Car> carList = fakeData();
		List<Car> carList = getDataFromDb();
		return carList;
	}
	
	public Car getCarById(int id){
		List<Car> carList = getDataFromDb();
		Car car = null;
		
		for(Car obj : carList) {
			if(obj.getId() == id) {
				car = new Car();
				car.setId(obj.getId());
				car.setModel(obj.getModel());
				car.setBrand(obj.getBrand());
				car.setYear(obj.getYear());
				car.setType(obj.getType());
			}
		}
		
		return car;
	}
	
	public int addCar(Car car) {
		try {
				logger.info("Car data added by user");
				Connection conn = DatabaseConfiguration.getInstance().getDbConnection();
				if(conn != null) {
				String sql = "INSERT INTO `tbl_car` (`model`, `brand`) VALUES (?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, car.getModel());
				stmt.setString(2, car.getBrand());
				
				int rows = stmt.executeUpdate();
				
				return rows;
			} else {
				logger.error("Database connection is null");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("ERROR "+e.getMessage());
		}
		
		return -1;
	}
	
	public int updatCar(Car car) {
		try {
			logger.info("Car data updated by user");
			Connection conn = DatabaseConfiguration.getInstance().getDbConnection();
			if(conn != null) {
				
				String sql = "UPDATE `tbl_car` SET `model`=?, `brand`=? WHERE `id`=?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, car.getModel());
				stmt.setString(2, car.getBrand());
				stmt.setInt(3, car.getId());
				
				int rows = stmt.executeUpdate();
				
				return rows;
				
			}else {
				logger.error("Database connection is null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("ERROR "+e.getMessage());
		}
		
		return -1;
	}

}
