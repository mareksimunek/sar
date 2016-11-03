package cz.fav.sar.server.utils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class IdGenerator {
	 private static JdbcTemplate jdbcTemplate;
	 

	 public static void init(DataSource dataSource)
	 {
		jdbcTemplate = new JdbcTemplate(dataSource);
	 }

	 @Transactional
	 public static long generateId(String tableName)
	 {
		 tableName = "\"" + tableName + "\"";
		 int year = Calendar.getInstance().get(Calendar.YEAR);
		 List<Map<String, Object>> res = jdbcTemplate.queryForList("SELECT \"POSLEDNI_CISLO\" FROM ccag." + tableName + " WHERE \"ROK\" = ?", year);
		 if(!res.isEmpty()){
			 long number = ((BigDecimal)res.get(0).get("POSLEDNI_CISLO")).longValue() + 1;
			 jdbcTemplate.update("UPDATE ccag." + tableName + " SET \"POSLEDNI_CISLO\" = ? WHERE \"ROK\" = ?", number, year);
			 return Long.valueOf(year+""+number); 
		 }else{
			 jdbcTemplate.update("INSERT INTO ccag." + tableName + " (\"ROK\", \"POSLEDNI_CISLO\") VALUES (?, ?)", year, 1);
			 return Long.valueOf(year+""+1); 
		 }
	 }
}
