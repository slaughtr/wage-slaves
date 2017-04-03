import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Worker {
  private String name;
  private int id;
  private int strength;
  private int stamina;
  private int charisma;
  private int intelligence;
  private String race;

  public Worker(String name, String race) {
    this.name = name;
    this.race = race;
    if (race.equals("human")) {
      this.strength = 5;
      this.stamina = 5;
      this.charisma = 5;
      this.intelligence = 5;
    } else if (race.equals("orc")) {
      this.strength = 9;
      this.stamina = 9;
      this.charisma = 1;
      this.intelligence = 1;
    } else if (race.equals("centaur")) {
      this.strength = 7;
      this.stamina = 9;
      this.charisma = 2;
      this.intelligence = 2;
    } else if (race.equals("gnome")) {
      this.strength = 2;
      this.stamina = 4;
      this.charisma = 6;
      this.intelligence = 8;
    }

  }

    public int getId(){
      return id;
    }

    public int getStrength(){
      return strength;
    }

    public int getStamina(){
      return stamina;
    }

    public int getCharisma(){
      return charisma;
    }

    public int getIntelligence(){
      return intelligence;
    }

    public String getRace() {
      return race;
    }

    public void save() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO workers (name, race) VALUES (:name, :race)";
        this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("race", this.race)
        .executeUpdate()
        .getKey();
      }
    }

    public static Worker find(int id) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "SELECT * FROM workers where id=:id";
        Worker entertainer = con.createQuery(sql)
          .addParameter("id", id)
          .throwOnMappingFailure(false)
          .executeAndFetchFirst(Worker.class);
      return entertainer;
      }
  }

  public static List<Worker> all() {
    String sql = "SELECT * FROM jobs";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Worker.class);
    }
  }


    @Override
    public boolean equals(Object otherJob){
      if (!(otherJob instanceof Job)) {
        return false;
      } else {
        Job newJob = (Job) otherJob;
        return this.getName().equals(newJob.getName());
      }
    }


}
