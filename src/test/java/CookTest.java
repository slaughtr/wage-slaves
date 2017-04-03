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

public class CookTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void test_if_instantiates(){
    Cook cook = new Cook("Bonsai", 50, 70);
    assertTrue(cook instanceof Cook);
  }

  @Test
  public void Cook_instantiatesWithName_String() {
    Cook testCook = new Cook("GosuHwang", 10, 20);
    assertEquals("GosuHwang", testCook.getName());
  }

  @Test
  public void Cook_instantiatesWithSalary_int() {
    Cook testCook = new Cook("GosuHwang", 10, 20);
    assertEquals(10, testCook.getSalary());
  }

  @Test
  public void Cook_instantiatesWithHours_int() {
    Cook testCook = new Cook("GosuHwang", 10, 20);
    assertEquals(20, testCook.getHours());
  }

  @Test
  public void Cook_setsDifficultyCorrectly_true() {
    Cook testCook = new Cook("GosuHwang", 10, 20);
    testCook.setDifficulty("easy");
    assertTrue(testCook.getDifficulty().equals("easy"));
  }

  @Test
  public void Cook_instantiatesWithStartedTimeCorrectly_true() {
    Cook testCook = new Cook("GosuHwang", 10, 20);
    testCook.save();
    Timestamp testCookStarted = Cook.find(testCook.getId()).getTimeStarted();
    Timestamp rightNow = new Timestamp(new Date().getTime());
    assertEquals(rightNow.getDay(), testCookStarted.getDay());
  }


  @Test
  public void equals_returnsTrueIfNameAndPersonIdAreSame_true() {
    Cook testCook = new Cook("GosuHwang", 10, 20);
    Cook anotherCook = new Cook("GosuHwang", 10, 20);
    assertTrue(testCook.equals(anotherCook));
  }

  @Test
  public void save_successfullyAddsCookToDatabase_List() {
    Cook testCook = new Cook("GosuHwang", 10, 20);
    testCook.save();
    assertTrue(Cook.all().get(0).equals(testCook));
  }
  @Test
  public void Cook_savesTypeIntoDatabaseCorrectly_true() {
    Cook testCook = new Cook ("GosuHwang", 10, 20);
    testCook.save();
    assertTrue(testCook.getType().equals("cook"));
  }

  @Test
  public void save_assignsIdToCook() {
    Cook testCook = new Cook("GosuHwang", 10, 20);
    testCook.save();
    Cook savedCook = Cook.all().get(0);
    assertEquals(savedCook.getId(), testCook.getId());
  }

  @Test
  public void all_returnsAllInstancesOfCook_true() {
    Cook firstCook = new Cook("GosuHwang", 10, 20);
    firstCook.save();
    Cook secondCook = new Cook("Spud", 3, 14);
    secondCook.save();
    assertEquals(true, Cook.all().get(0).equals(firstCook));
    assertEquals(true, Cook.all().get(1).equals(secondCook));
  }

  @Test
  public void find_returnsCookWithSameId_secondCook() {
    Cook firstCook = new Cook("GosuHwang", 10, 20);
    firstCook.save();
    Cook secondCook = new Cook("Spud", 3, 14);
    secondCook.save();
    assertEquals(Cook.find(secondCook.getId()), secondCook);
  }

}
