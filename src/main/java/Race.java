import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Race {
  public String name;
  public int id;
  public int strength;
  public int stamina;
  public int charisma;
  public int intelligence;

  public static final int MAX_STRENGTH = 10;
  public static final int MAX_STAMINA = 10;
  public static final int MAX_CHARISMA = 10;
  public static final int MAX_INTELLIGENCE = 10;
  public static final int MIN_STRENGTH = 1;
  public static final int MIN_STAMINA = 1;
  public static final int MIN_CHARISMA = 1;
  public static final int MIN_INTELLIGENCE = 1;

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

  public int intelligence(){
    return intelligence;
  }


  

}
