package sql;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.locks.ReentrantLock;

public class QueryDB
  extends Thread
{
  private String sql;
  private Connection con;
  
  public QueryDB(String sql, Connection con)
  {
    setDaemon(false);
    
    this.sql = sql;
    this.con = con;
  }
  
  public void run()
  {
    MySQL.lock.lock();
    try
    {
      Statement stmt = this.con.createStatement();
      stmt.executeUpdate(this.sql);
      stmt.close();
    }
    catch (SQLException ex)
    {
      System.err.println("[SG] Error with following query: " + this.sql);
      System.err.println("[SG] MySQL-Error: " + ex.getMessage());
    }
    catch (NullPointerException ex)
    {
      System.err.println("[SG] Error with following query (NullPointerException): " + this.sql);
    }
    MySQL.lock.unlock();
  }
}
