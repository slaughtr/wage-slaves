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

public class ConstructorTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void test_if_instantiates(){
    Constructor creature = new Constructor("GosuHwang", 10, 20);
    assertTrue(creature instanceof Constructor);
  }

  @Test
  public void Constructor_instantiatesWithName_String() {
    Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
    assertEquals("GosuHwang", testConstructor.getName());
  }

  @Test
  public void Constructor_instantiatesWithSalary_int() {
    Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
    assertEquals(10, testConstructor.getSalary());
  }

  @Test
  public void Constructor_instantiatesWithHours_int() {
    Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
    assertEquals(20, testConstructor.getHours());
  }

  @Test
  public void Constructor_setsDifficultyCorrectly_true() {
    Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
    testConstructor.setDifficulty("easy");
    assertTrue(testConstructor.getDifficulty().equals("easy"));
  }

  @Test
  public void Constructor_instantiatesWithStartedTimeCorrectly_true() {
    Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
    testConstructor.save();
    Timestamp testConstructorStarted = Constructor.find(testConstructor.getId()).getTimeStarted();
    Timestamp rightNow = new Timestamp(new Date().getTime());
    assertEquals(rightNow.getDay(), testConstructorStarted.getDay());
  }


  @Test
  public void equals_returnsTrueIfNameAndPersonIdAreSame_true() {
    Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
    Constructor anotherConstructor = new Constructor("GosuHwang", 10, 20);
    assertTrue(testConstructor.equals(anotherConstructor));
  }

  @Test
  public void save_successfullyAddsConstructorToDatabase_List() {
    Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
    testConstructor.save();
    assertTrue(Constructor.all().get(0).equals(testConstructor));
  }

  @Test
  public void Constructor_savesTypeIntoDatabaseCorrectly_true() {
    Constructor testConstructor = new Constructor ("GosuHwang", 10, 20);
    testConstructor.save();
    assertTrue(testConstructor.getType().equals("constructor"));
  }

  @Test
  public void save_assignsIdToConstructor() {
    Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
    testConstructor.save();
    Constructor savedConstructor = Constructor.all().get(0);
    assertEquals(savedConstructor.getId(), testConstructor.getId());
  }

  @Test
  public void all_returnsAllInstancesOfConstructor_true() {
    Constructor firstConstructor = new Constructor("GosuHwang", 10, 20);
    firstConstructor.save();
    Constructor secondConstructor = new Constructor("Spud", 3, 14);
    secondConstructor.save();
    assertEquals(true, Constructor.all().get(0).equals(firstConstructor));
    assertEquals(true, Constructor.all().get(1).equals(secondConstructor));
  }

  @Test
  public void find_returnsConstructorWithSameId_secondConstructor() {
    Constructor firstConstructor = new Constructor("GosuHwang", 10, 20);
    firstConstructor.save();
    Constructor secondConstructor = new Constructor("Spud", 3, 14);
    secondConstructor.save();
    assertEquals(Constructor.find(secondConstructor.getId()), secondConstructor);
  }

}
