import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Human extends Race {

  public Human(String name) {
    this.name = name;
    this.strength = 5;
    this.stamina = 5;
    this.charisma = 5;
    this.intelligence = 5;
  }



}
