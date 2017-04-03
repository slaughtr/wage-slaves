import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Constructor extends Job {
  public static final String DATABASE_TYPE = "constructor";

  public Constructor(String name, int salary, int hours) {
    this.name = name;
    this.salary = salary;
    this.hours = hours;
    this.started = new Timestamp(new Date().getTime());
    this.type = DATABASE_TYPE;
  }


  public static Constructor find(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM jobs where id=:id";
    Constructor constructor = con.createQuery(sql)
      .addParameter("id", id)
      .throwOnMappingFailure(false)
      .executeAndFetchFirst(Constructor.class);
  return constructor;
  }
}

public static List<Constructor> all() {
  String sql = "SELECT * FROM jobs WHERE type='constructor';";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql)
    .throwOnMappingFailure(false)
    .executeAndFetch(Constructor.class);
  }
}

}
