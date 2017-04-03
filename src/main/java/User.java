import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public abstract class User {
  public int id;
  public String name;
  
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
