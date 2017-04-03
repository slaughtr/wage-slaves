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

public class CleanerTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void test_if_instantiates(){
    Cleaner cleaner = new Cleaner("Bonsai", 50, 70);
    assertTrue(cleaner instanceof Cleaner);
  }

  @Test
  public void Cleaner_instantiatesWithName_String() {
    Cleaner testCleaner = new Cleaner("GosuHwang", 10, 20);
    assertEquals("GosuHwang", testCleaner.getName());
  }

  @Test
  public void Cleaner_instantiatesWithSalary_int() {
    Cleaner testCleaner = new Cleaner("GosuHwang", 10, 20);
    assertEquals(10, testCleaner.getSalary());
  }

  @Test
  public void Cleaner_instantiatesWithHours_int() {
    Cleaner testCleaner = new Cleaner("GosuHwang", 10, 20);
    assertEquals(20, testCleaner.getHours());
  }

  @Test
  public void Cleaner_setsDifficultyCorrectly_true() {
    Cleaner testCleaner = new Cleaner("GosuHwang", 10, 20);
    testCleaner.setDifficulty("easy");
    assertTrue(testCleaner.getDifficulty().equals("easy"));
  }

  @Test
  public void Cleaner_instantiatesWithStartedTimeCorrectly_true() {
    Cleaner testCleaner = new Cleaner("GosuHwang", 10, 20);
    testCleaner.save();
    Timestamp testCleanerStarted = Cleaner.find(testCleaner.getId()).getTimeStarted();
    Timestamp rightNow = new Timestamp(new Date().getTime());
    assertEquals(rightNow.getDay(), testCleanerStarted.getDay());
  }


  @Test
  public void equals_returnsTrueIfNameAndPersonIdAreSame_true() {
    Cleaner testCleaner = new Cleaner("GosuHwang", 10, 20);
    Cleaner anotherCleaner = new Cleaner("GosuHwang", 10, 20);
    assertTrue(testCleaner.equals(anotherCleaner));
  }

  @Test
  public void save_successfullyAddsCleanerToDatabase_List() {
    Cleaner testCleaner = new Cleaner("GosuHwang", 10, 20);
    testCleaner.save();
    assertTrue(Cleaner.all().get(0).equals(testCleaner));
  }

  @Test
  public void Cleaner_savesTypeIntoDatabaseCorrectly_true() {
    Cleaner testCleaner = new Cleaner ("GosuHwang", 10, 20);
    testCleaner.save();
    assertTrue(testCleaner.getType().equals("cleaner"));
  }

  @Test
  public void save_assignsIdToCleaner() {
    Cleaner testCleaner = new Cleaner("GosuHwang", 10, 20);
    testCleaner.save();
    Cleaner savedCleaner = Cleaner.all().get(0);
    assertEquals(savedCleaner.getId(), testCleaner.getId());
  }

  @Test
  public void all_returnsAllInstancesOfCleaner_true() {
    Cleaner firstCleaner = new Cleaner("GosuHwang", 10, 20);
    firstCleaner.save();
    Cleaner secondCleaner = new Cleaner("Spud", 3, 14);
    secondCleaner.save();
    assertEquals(true, Cleaner.all().get(0).equals(firstCleaner));
    assertEquals(true, Cleaner.all().get(1).equals(secondCleaner));
  }

  @Test
  public void find_returnsCleanerWithSameId_secondCleaner() {
    Cleaner firstCleaner = new Cleaner("GosuHwang", 10, 20);
    firstCleaner.save();
    Cleaner secondCleaner = new Cleaner("Spud", 3, 14);
    secondCleaner.save();
    assertEquals(Cleaner.find(secondCleaner.getId()), secondCleaner);
  }


}
