import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EntertainerTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void test_if_instantiates(){
    Entertainer cook = new Entertainer("Bonsai", 50, 70);
    assertTrue(cook instanceof Entertainer);
  }

  @Test
  public void Entertainer_instantiatesWithName_String() {
    Entertainer testEntertainer = new Entertainer("GosuHwang", 10, 20);
    assertEquals("GosuHwang", testEntertainer.getName());
  }

  @Test
  public void Entertainer_instantiatesWithSalary_int() {
    Entertainer testEntertainer = new Entertainer("GosuHwang", 10, 20);
    assertEquals(10, testEntertainer.getSalary());
  }

  @Test
  public void Entertainer_instantiatesWithHours_int() {
    Entertainer testEntertainer = new Entertainer("GosuHwang", 10, 20);
    assertEquals(20, testEntertainer.getHours());
  }

  @Test
  public void Entertainer_setsDifficultyCorrectly_true() {
    Entertainer testEntertainer = new Entertainer("GosuHwang", 10, 20);
    testEntertainer.setDifficulty("easy");
    assertTrue(testEntertainer.getDifficulty().equals("easy"));
  }

  @Test
  public void Entertainer_instantiatesWithStartedTimeCorrectly_true() {
    Entertainer testEntertainer = new Entertainer("GosuHwang", 10, 20);
    testEntertainer.save();
    Timestamp testEntertainerStarted = Entertainer.find(testEntertainer.getId()).getTimeStarted();
    Timestamp rightNow = new Timestamp(new Date().getTime());
    assertEquals(rightNow.getDay(), testEntertainerStarted.getDay());
  }


  @Test
  public void equals_returnsTrueIfNameAndPersonIdAreSame_true() {
    Entertainer testEntertainer = new Entertainer("GosuHwang", 10, 20);
    Entertainer anotherEntertainer = new Entertainer("GosuHwang", 10, 20);
    assertTrue(testEntertainer.equals(anotherEntertainer));
  }

  @Test
  public void save_successfullyAddsEntertainerToDatabase_List() {
    Entertainer testEntertainer = new Entertainer("GosuHwang", 10, 20);
    testEntertainer.save();
    assertTrue(Entertainer.all().get(0).equals(testEntertainer));
  }

}
