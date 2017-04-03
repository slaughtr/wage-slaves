import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Gnome extends Race {

  public Gnome(String name) {
    this.name = name;
    this.strength = 2;
    this.stamina = 4;
    this.charisma = 6;
    this.intelligence = 8;
  }

}
