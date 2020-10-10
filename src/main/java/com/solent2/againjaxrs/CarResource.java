package com.solent2.againjaxrs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.solent2.againjaxrs.dao.CarDao;
import com.solent2.againjaxrs.model.Car;

@Path("car")
public class CarResource {
	
	private Logger logger = LogManager.getLogger(CarResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCars() {
		
		logger.fatal("THIS IS FROM FATAL");
		logger.error("THIS IS FROM ERROR");
		logger.warn("THIS IS FROM WARN");
		logger.info("THIS IS FROM INFO");
		logger.debug("THIS IS FROM DEBUG");
		logger.trace("THIS IS FROM TRACE");
		
		CarDao carDao = new CarDao();
		List<Car> cars = carDao.getAll();
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(cars);
		return jsonString;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCarById(@PathParam("id") int id) {
		CarDao carDao = new CarDao();
		Car car = carDao.getCarById(id);
		Gson gson = new Gson();
		
		if(car != null) {
			String jsonString = gson.toJson(car);
			return jsonString;
		} else {
			Map<String, String> errorMsg = new HashMap<String, String>();
			errorMsg.put("ERROR", "Invalid Car ID");
			String jsonString = gson.toJson(errorMsg);
			return jsonString;
		}
	}
	
	@POST
	public int addCar() {
		System.out.println("Car added.....");
		return 1;
	}
	
	@PUT
	public int updateCar() {
		System.out.println("Car updated.....");
		return 1;
	}
	
	@DELETE
	public int deleteCar() {
		System.out.println("Car deleted.....");
		return 1;
	}
	
	
}
