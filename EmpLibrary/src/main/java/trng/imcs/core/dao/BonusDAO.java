package trng.imcs.core.dao;

import java.sql.SQLException;
import java.util.List;

import imcs.core.model.Bonus;

public interface BonusDAO {

	public void add(List<Bonus> bonusList) throws SQLException;

	public List<Bonus> getBonus() throws SQLException;
}
