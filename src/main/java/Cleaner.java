import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Cleaner extends Job {
  public static final String DATABASE_TYPE = "cleaner";

  public Cleaner(String name, int salary, int hours) {
    this.name = name;
    this.salary = salary;
    this.hours = hours;
    this.started = new Timestamp(new Date().getTime());
    this.type = DATABASE_TYPE;
  }

  public static Cleaner find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM jobs where id=:id";
      Cleaner cleaner = con.createQuery(sql)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(Cleaner.class);
    return cleaner;
    }
}

public static List<Cleaner> all() {
  String sql = "SELECT * FROM jobs WHERE type='cleaner';";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Cleaner.class);
  }
}

}
