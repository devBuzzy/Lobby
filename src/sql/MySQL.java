package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import org.bukkit.Bukkit;

import me.NitroxMC.Lobby.Lobby;

public class MySQL
{
  public static String SQL_HOST = "5.135.103.160";
  public static String SQL_USER = "NiCraft_284";
  public static String SQL_PASS = "9570e96f31";
  public static String SQL_DATA = "NiCraft_284";
  public static String SQL_PORT = "25792";
  private static Connection con = null;
  public static Boolean firstconnect = Boolean.valueOf(false);
  private static int tries = 0;
  public static ReentrantLock lock = new ReentrantLock(true);
  
  public MySQL()
  {
    connect();
    if (!firstconnect.booleanValue()) {
      return;
    }
    query("CREATE TABLE IF NOT EXISTS `lobby_PLAYERS` (`ID` int(10) unsigned NOT NULL AUTO_INCREMENT, `NAME` varchar(16) NOT NULL, `PLAYED` int(10), `CASH` int(10), `TOKENS` int(10) PRIMARY KEY (`ID`)) ENGINE=MyISAM DEFAULT CHARSET=UTF8 AUTO_INCREMENT=1 ;");
    //query("CREATE TABLE IF NOT EXISTS `gadgets_PLAYERS` (`ID` int(10) unsigned NOT NULL AUTO_INCREMENT, `NAME` varchar(16) NOT NULL, `PLAYED` int(10), `CASH` int(10), `TOKENS` int(10) PRIMARY KEY (`ID`)) ENGINE=MyISAM DEFAULT CHARSET=UTF8 AUTO_INCREMENT=1 ;");
  }  
  public static void connect()
  {
    tries += 1;
    try
    {
      System.out.println("[Lobby] Connecting to MySQL database... (" + tries + ")");
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      String conn = "jdbc:mysql://" + SQL_HOST + ":" + SQL_PORT + "/" + SQL_DATA;
      con = DriverManager.getConnection(conn, SQL_USER, SQL_PASS);
      firstconnect = Boolean.valueOf(true);
    }
    catch (ClassNotFoundException ex)
    {
      System.err.println("[Lobby] No MySQL driver found!");
      Lobby.getInstance().getLogger().warning("Failed to connect to: \"jdbc:mysql://" + SQL_HOST + ":" + SQL_PORT + "/" + SQL_DATA + "\" - U: \"" + SQL_USER + "\"" + " P: \"" + toStars(SQL_PASS) + "\"");
      firstconnect = Boolean.valueOf(false);
    }
    catch (SQLException ex)
    {
      System.err.println("[Lobby] Error while fetching MySQL connection!");
      Lobby.getInstance().getLogger().warning("Failed to connect to: \"jdbc:mysql://" + SQL_HOST + ":" + SQL_PORT + "/" + SQL_DATA + "\" - U: \"" + SQL_USER + "\"" + " P: \"" + toStars(SQL_PASS) + "\"");
      firstconnect = Boolean.valueOf(false);
    }
    catch (Exception ex)
    {
      System.err.println("[Lobby] Unknown error while fetchting MySQL connection.");
      Lobby.getInstance().getLogger().warning("Failed to connect to: \"jdbc:mysql://" + SQL_HOST + ":" + SQL_PORT + "/" + SQL_DATA + "\" - U: \"" + SQL_USER + "\"" + " P: \"" + toStars(SQL_PASS) + "\"");
      firstconnect = Boolean.valueOf(false);
    }
    if (tries < 3)
    {
      connect();
      return;
    }
    if (!firstconnect.booleanValue())
    {
    	Lobby.getInstance().getLogger().warning("---------- FATAL ERROR ----------");
    	Lobby.getInstance().getLogger().warning("COULD NOT ESTABLISH MYSQL CONNECTION!");
    	Lobby.getInstance().getLogger().warning("Lobby will not work without a MySQL database.");
    	Lobby.getInstance().getLogger().warning("As a result Lobby is now shutting down.");
    	Lobby.getInstance().getLogger().warning("---------------------------------");
      Bukkit.getServer().getPluginManager().disablePlugin(Lobby.getInstance());
    }
  }
  
  private static String toStars(String pw)
  {
    String stars = "";
    for (int i = 0; i < pw.length(); i++) {
      stars = stars + "*";
    }
    return stars;
  }
  
  public static void query(String sql)
  {
    QueryDB bq = new QueryDB(sql, con);
    ExecutorService executor = Executors.newCachedThreadPool();
    executor.execute(bq);
    executor.shutdown();
  }
  
  public static void disconnect()
  {
    CloseDB end = new CloseDB(con);
    ExecutorService executor = Executors.newCachedThreadPool();
    executor.execute(end);
    executor.shutdown();
  }
  public static Integer getCash(String playername)
  {
    try
    {
      PreparedStatement stmt = con.prepareStatement("SELECT `CASH` FROM `lobby_PLAYERS` WHERE `NAME` = ?;");
      stmt.setString(1, playername);
      ResultSet r = stmt.executeQuery();
      r.last();
      if (r.getRow() == 0)
      {
        stmt.close();
        r.close();
        return null;
      }
      Integer points = Integer.valueOf(r.getInt("CASH"));
      stmt.close();
      r.close();
      return points;
    }
    catch (SQLException ex)
    {
      System.err.println("[Lobby] MySQL-Error: " + ex.getMessage());
      return null;
    }
    catch (NullPointerException ex)
    {
      System.err.println("[Lobby] Error while performing a query. (NullPointerException)");
    }
    return null;
  }
  public static Integer getTokens(String playername)
  {
    try
    {
      PreparedStatement stmt = con.prepareStatement("SELECT `TOKENS` FROM `lobby_PLAYERS` WHERE `NAME` = ?;");
      stmt.setString(1, playername);
      ResultSet r = stmt.executeQuery();
      r.last();
      if (r.getRow() == 0)
      {
        stmt.close();
        r.close();
        return null;
      }
      Integer points = Integer.valueOf(r.getInt("TOKENS"));
      stmt.close();
      r.close();
      return points;
    }
    catch (SQLException ex)
    {
      System.err.println("[Lobby] MySQL-Error: " + ex.getMessage());
      return null;
    }
    catch (NullPointerException ex)
    {
      System.err.println("[Lobby] Error while performing a query. (NullPointerException)");
    }
    return null;
  }
  
  public static Boolean playerPlayedBefore(String playername)
  {
    try
    {
      PreparedStatement stmt = con.prepareStatement("SELECT `ID`, `NAME` FROM `lobby_PLAYERS` WHERE `NAME` = ?;");
      stmt.setString(1, playername);
      ResultSet r = stmt.executeQuery();
      r.last();
      if (r.getRow() == 0)
      {
        stmt.close();
        r.close();
        return Boolean.valueOf(false);
      }
      stmt.close();
      r.close();
      return Boolean.valueOf(true);
    }
    catch (SQLException ex)
    {
      System.err.println("[Lobby] MySQL-Error: " + ex.getMessage());
      return Boolean.valueOf(false);
    }
    catch (NullPointerException ex)
    {
      System.err.println("[Lobby] Error while performing a query. (NullPointerException)");
    }
    return Boolean.valueOf(false);
  }
  
}