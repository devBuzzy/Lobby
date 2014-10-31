package sql;

import java.sql.Connection;
import java.sql.SQLException;

public class CloseDB
  extends Thread
{
  private Connection con;
  
  public CloseDB(Connection con)
  {
    setDaemon(false);
    this.con = con;
  }
  
  public void run()
  {
    MySQL.lock.lock();
    try
    {
      System.out.println("[SG] Disconnecting from MySQL database...");
      this.con.close();
    }
    catch (SQLException ex)
    {
      System.err.println("[SG] Error while closing the connection...");
    }
    catch (NullPointerException ex)
    {
      System.err.println("[SG] Error while closing the connection...");
    }
    MySQL.lock.unlock();
  }
}
