package trng.imcs.core.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import connection.ConnectionManager;
import imcs.core.model.Bonus;
import trng.imcs.core.dao.BonusDAO;

public class BonusDAOImpl implements BonusDAO{

	final Logger logger = Logger.getLogger(BonusDAOImpl.class);

	public void add(List<Bonus> bonusList) {

		logger.info("adding bonus");

		final String sql = "insert into bonus (deptNo, amount, remainingAmount) values (?, ?, ?)";
		try (Connection con = ConnectionManager.getConnection();
				Statement st = con.createStatement();
				PreparedStatement preparedStatement = con.prepareStatement(sql)) {

			con.setAutoCommit(false);
			st.execute("truncate employeebonus");
			st.execute("truncate bonus");
			int count = 1;
			boolean hasLeftOverBatchRecords = true;
			for (Bonus b : bonusList) {

				if (b == null)
					break;

				preparedStatement.setInt(1, b.getDeptNo());
				preparedStatement.setFloat(2, b.getAmount());
				preparedStatement.setFloat(3, b.getRemainingAmount());

				// Add it to the batch
				preparedStatement.addBatch();

				if (count++ % 3 == 0) {
					// Create an int[] to hold returned values
					int[] updateCount = preparedStatement.executeBatch();
					hasLeftOverBatchRecords = false;
				} else {
					hasLeftOverBatchRecords = true;
				}
			}

			if (hasLeftOverBatchRecords) {
				int[] updateCount = preparedStatement.executeBatch();
			}

			con.commit();
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

	}

	public List<Bonus> getBonus() throws SQLException {
		logger.info("getting Bonus from DB");
		List<Bonus> bonusList = new ArrayList<Bonus>();
		ResultSet rs = null;
		String sql = "select deptNo, amount, remainingAmount from bonus";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			rs = st.executeQuery();
			while (rs.next()) {
				Bonus e = new Bonus();
				e.setDeptNo(rs.getInt(1));
				e.setAmount(rs.getFloat(2));
				e.setRemainingAmount(rs.getFloat(3));
				bonusList.add(e);
			}
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return bonusList;
	}

}
