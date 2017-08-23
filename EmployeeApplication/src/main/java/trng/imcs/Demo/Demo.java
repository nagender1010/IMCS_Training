package trng.imcs.Demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;

import imcs.core.model.Bonus;
import imcs.core.service.BonusService;
import imcs.core.service.EmployeeService;
import imcs.core.serviceImpl.BonusServiceImpl;
import imcs.core.serviceImpl.EmployeeServiceImpl;
import trng.imcs.core.dao.BonusDAO;
import trng.imcs.core.dao.EmployeeDAO;
import trng.imcs.core.dao.impl.BonusDAOImpl;
import trng.imcs.core.dao.impl.EmployeeDAOImpl;

public class Demo {
	final static Logger logger = Logger.getLogger(Demo.class);

	public static void main(String[] args) {
		logger.info("main started");
		BonusDAO bDAO = new BonusDAOImpl();
		BonusService bs = new BonusServiceImpl();
		EmployeeService es = new EmployeeServiceImpl();
		EmployeeDAO eDao = new EmployeeDAOImpl();
		List<Bonus> bonusList = null;

		try {
			logger.info("Calling loadFromFile method to load data from local source");
			bonusList = bs.loadFromFile();
			System.out.println(bonusList);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			//logger.error(e1.getMessage());
		} catch (IOException e1) {
			e1.getMessage();
			//logger.error(e1.getMessage());
		} catch (ParseException e1) {
			e1.getMessage();

			//logger.error(e1.getMessage());
		}
		try {
			logger.info("calling add method of to add bonus data to database");
			bDAO.add(bonusList);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			logger.info(
					"calling add method and load from file method to load employee data from source and to load it to database");
			eDao.add(es.loadFromFile());
		} catch (SQLException | IOException | ParseException e1) {
			e1.getMessage();

			logger.error(e1.getMessage());
		}

		try {
			bs.allocateBonus();
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		
		logger.info("main ended");
		

	}
}
