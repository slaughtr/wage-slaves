import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Job {
  public int id;
  public String name;
  public int salary;
  public String difficulty;
  public int hours;
  public Timestamp started;
  public String type;

  public static final int MAX_NUMBER_HOURS = 100;
  public static final int MIN_NUMBER_HOURS = 8;
  public static final int MIN_SALARY_IN_TOOTHS = 1;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getSalary() {
    return salary;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public int getHours() {
    return hours;
  }

  public Timestamp getTimeStarted() {
    return started;
  }

  public String getType() {
    return type;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }


  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO jobs (name, salary, difficulty, hours, started, type) VALUES (:name, :salary, :difficulty, :hours, now(), :type)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("salary", this.salary)
      .addParameter("difficulty", this.difficulty)
      .addParameter("hours", this.hours)
      .addParameter("type", this.type)
      .executeUpdate()
      .getKey();
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
