import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Cook extends Job {

  public static final String DATABASE_TYPE = "cook";

  public Cook(String name, int salary, int hours) {
    this.name = name;
    this.salary = salary;
    this.hours = hours;
    this.started = new Timestamp(new Date().getTime());
    this.type = DATABASE_TYPE;
  }

  public static Cook find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM jobs where id=:id";
      Cook constructor = con.createQuery(sql)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(Cook.class);
    return constructor;
    }
  }

  public static List<Cook> all() {
    String sql = "SELECT * FROM jobs WHERE type='cook';";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(Cook.class);
    }
  }


}
