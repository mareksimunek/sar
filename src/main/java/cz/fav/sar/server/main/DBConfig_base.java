package cz.fav.sar.server.main;

public class DBConfig_base {
	
	public static final String SCHEMA = "ccag";
	public static final String URL = "jdbc:postgresql://<ip>:<port>/iszadb?currentSchema=" + SCHEMA;
	public static final String USERNAME = "<db username>";
	public static final String PASSWORD = "<db password>";
	
	
	public static final String JWT_SECRET = "<secret for JWT tokens>";
	
}
