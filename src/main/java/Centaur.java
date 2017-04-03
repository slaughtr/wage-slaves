import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Centaur extends Race {

  public Centaur(String name) {
    this.name = name;
    this.strength = 7;
    this.stamina = 9;
    this.charisma = 2;
    this.intelligence = 2;
  }

}
