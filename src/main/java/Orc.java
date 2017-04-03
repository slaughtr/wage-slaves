import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Orc extends Race {

  public Orc(String name) {
    this.name = name;
    this.strength = 9;
    this.stamina = 9;
    this.charisma = 1;
    this.intelligence = 1;
  }

}
