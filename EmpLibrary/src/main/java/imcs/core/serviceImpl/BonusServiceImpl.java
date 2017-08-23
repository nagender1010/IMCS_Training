package imcs.core.serviceImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import imcs.core.model.Bonus;
import imcs.core.model.Employee;
import imcs.core.model.EmployeeBonus;
import imcs.core.service.BonusService;
import trng.imcs.core.dao.EmployeeDAO;
import trng.imcs.core.dao.impl.BonusDAOImpl;
import trng.imcs.core.dao.impl.EmployeeDAOImpl;

public class BonusServiceImpl implements BonusService {
	final Logger logger = Logger.getLogger(BonusServiceImpl.class);

	public List<Bonus> loadFromFile() {
		logger.info("Load Bonus data from source path");
		List<Bonus> bonusList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("..\\EmpLibrary\\sourceFiles\\bonusData.txt"))) {
			String line;
			String[] d = null;
			while ((line = br.readLine()) != null) {
				d = line.split(",");
				Bonus e = new Bonus(Integer.parseInt(d[0]), Float.parseFloat(d[1]), Float.parseFloat(d[2]));
				bonusList.add(e);
			}
		} catch (FileNotFoundException e1) {
			logger.error(e1.getMessage());
		} catch (IOException e1) {
			logger.error(e1.getMessage());
		}
		return bonusList;

	}

	public void allocateBonus() {
		final EmployeeServiceImpl es = new EmployeeServiceImpl();
		BonusDAOImpl bDAO = new BonusDAOImpl();
		List<Bonus> bonusList = new ArrayList<>();
		EmployeeBonus eb = new EmployeeBonus();
		long time = new Date().getTime();
		try {
			bonusList = bDAO.getBonus();
			ExecutorService executorService = Executors.newFixedThreadPool(4);
			for (final Bonus b : bonusList) {
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						List<Employee> empListWithDeptID = null;
						try {
							empListWithDeptID = es.getAllEmployeeDetails(b.getDeptNo());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						for (Employee e : empListWithDeptID) {
							allocatingBonus(b, e);
						}
					}
				});
				thread.join();
				executorService.execute(thread);
			}

			System.out.println("calculating time" + (new Date().getTime() - time));
			executorService.shutdown();

		} catch (SQLException e) {
			logger.error(e.getMessage());
		} /*
			 * catch (InterruptedException e1) { e1.printStackTrace(); }
			 */ catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void allocatingBonus(Bonus b, Employee e) {
		logger.info("allocating bonus to employees department wise " + e.getDeptId());
		EmployeeDAO dao = new EmployeeDAOImpl();
		EmployeeBonus eb = new EmployeeBonus();
		int salaryGrade = e.getSalaryGrade();
		int deptId = e.getDeptId();
		int empId = e.getId();
		float totalAmount = b.getAmount();
		float remainingAmount = b.getRemainingAmount();
		float bonusAmount = 0;
		if (remainingAmount == 0) {
			eb.setEmpId(empId);
			eb.setAmount(0);
			eb.setStatus("INC");
			try {
				dao.addEmployeeBonus(eb);
			} catch (SQLException e1) {
				logger.error(e1.getMessage());
			}
		} else {
			if (remainingAmount < 0.1 * totalAmount) {
				b.setRemainingAmount(0);
				eb.setEmpId(empId);
				eb.setAmount(remainingAmount);
				java.util.Date d = new java.util.Date();
				eb.setDateAllocated(new java.sql.Date(d.getYear(), d.getMonth(), d.getDate()));
				eb.setStatus("PAR");
				try {
					dao.addEmployeeBonus(eb);
					dao.updateBonusInfo(deptId, b);
				} catch (SQLException e1) {
					logger.error(e1.getMessage());
				}

			} else {
				switch (salaryGrade) {
				case 1:
					bonusAmount = (float) (0.1 * totalAmount);
					if (bonusAmount <= remainingAmount) {
						eb.setStatus("COM");
						b.setRemainingAmount(remainingAmount - bonusAmount);
						eb.setAmount(bonusAmount);
					} else {
						eb.setStatus("PAR");
						eb.setAmount(remainingAmount);
						b.setRemainingAmount(0);
					}

					break;
				case 2:
					bonusAmount = (float) (0.15 * totalAmount);
					if (bonusAmount <= remainingAmount) {
						eb.setStatus("COM");
						b.setRemainingAmount(remainingAmount - bonusAmount);
						eb.setAmount(bonusAmount);

					} else {
						eb.setStatus("PAR");
						eb.setAmount(remainingAmount);
						b.setRemainingAmount(0);

					}

					break;
				case 3:
					bonusAmount = (float) (0.2 * totalAmount);
					if (bonusAmount <= remainingAmount) {
						eb.setStatus("COM");
						b.setRemainingAmount(remainingAmount - bonusAmount);
						eb.setAmount(bonusAmount);

					} else {
						eb.setStatus("PAR");
						eb.setAmount(remainingAmount);
						b.setRemainingAmount(0);

					}

					break;
				case 4:
					bonusAmount = (float) (0.25 * totalAmount);
					if (bonusAmount <= remainingAmount) {
						eb.setStatus("COM");
						b.setRemainingAmount(remainingAmount - bonusAmount);
						eb.setAmount(bonusAmount);

					} else {
						eb.setStatus("PAR");
						eb.setAmount(remainingAmount);
						b.setRemainingAmount(0);

					}
					break;

				default:
					break;
				}

				java.util.Date d = new java.util.Date();
				eb.setDateAllocated(new java.sql.Date(d.getYear(), d.getMonth(), d.getDate()));
				eb.setEmpId(empId);

				try {
					dao.addEmployeeBonus(eb);
					dao.updateBonusInfo(deptId, b);
				} catch (SQLException e1) {
					logger.error(e1.getMessage());
				}

			}
		}

	}

}
