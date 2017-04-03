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

  // @Test
  // public void Constructor_savesTypeIntoDatabaseCorrectly_true() {
  //   Constructor testConstructor = new Constructor ("GosuHwang", 10, 20);
  //   testConstructor.save();
  //   assertEquals
  // }

  // @Test
  // public void save_assignsIdToConstructor() {
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   testConstructor.save();
  //   Constructor savedConstructor = Constructor.all().get(0);
  //   assertEquals(savedConstructor.getId(), testConstructor.getId());
  // }
  //
  // @Test
  // public void all_returnsAllInstancesOfConstructor_true() {
  //   Constructor firstConstructor = new Constructor("GosuHwang", 10, 20);
  //   firstConstructor.save();
  //   Constructor secondConstructor = new Constructor("Spud", 3);
  //   secondConstructor.save();
  //   assertEquals(true, Constructor.all().get(0).equals(firstConstructor));
  //   assertEquals(true, Constructor.all().get(1).equals(secondConstructor));
  // }
  //
  // @Test
  // public void find_returnsConstructorWithSameId_secondConstructor() {
  //   Constructor firstConstructor = new Constructor("GosuHwang", 10, 20);
  //   firstConstructor.save();
  //   Constructor secondConstructor = new Constructor("Spud", 3);
  //   secondConstructor.save();
  //   assertEquals(Constructor.find(secondConstructor.getId()), secondConstructor);
  // }
  //
  // @Test
  // public void save_savesPersonIdIntoDB_true() {
  //   Person testPerson = new Person("Henry", "henry@henry.com");
  //   testPerson.save();
  //   Constructor testConstructor = new Constructor("GosuHwang", testPerson.getId());
  //   testConstructor.save();
  //   Constructor savedConstructor = Constructor.find(testConstructor.getId());
  //   assertEquals(savedConstructor.getPersonId(), testPerson.getId());
  // }
  //
  // @Test
  // public void fireMonster_instantiatesWithHalfFullPlayLevel(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   assertEquals(testConstructor.getPlayLevel(), (Constructor.MAX_PLAY_LEVEL / 2));
  // }
  //
  // @Test
  // public void fireMonster_instantiatesWithHalfFullSleepLevel(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   assertEquals(testConstructor.getSleepLevel(), (Constructor.MAX_SLEEP_LEVEL / 2));
  // }
  //
  // @Test
  // public void fireMonster_instantiatesWithHalfFullFoodLevel(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   assertEquals(testConstructor.getFoodLevel(), (Constructor.MAX_FOOD_LEVEL / 2));
  // }
  //
  // @Test
  // public void play_increasesPlayLevelValue_(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   assertEquals(testConstructor.getFoodLevel(), (Constructor.MAX_FOOD_LEVEL / 2));
  // }
  //
  // @Test
  // public void isAlive_confirmsConstructorIsAliveIfAllLevelsAboveMinimum_true(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   assertEquals(testConstructor.isAlive(), true);
  // }
  //
  // @Test
  // public void isAlive_recognizesConstructorIsDeadWhenLevelsReachMinimum_false(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   for(int i = Constructor.MIN_ALL_LEVELS; i <= Constructor.MAX_FOOD_LEVEL; i++){
  //     testConstructor.depleteLevels();
  //   }
  //   assertEquals(testConstructor.isAlive(), false);
  // }
  //
  // @Test
  // public void play_increasesConstructorPlayLevel(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   testConstructor.play();
  //   assertTrue(testConstructor.getPlayLevel() > (Constructor.MAX_PLAY_LEVEL / 2));
  // }
  //
  // @Test
  // public void sleep_increasesConstructorSleepLevel(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   testConstructor.sleep();
  //   assertTrue(testConstructor.getSleepLevel() > (Constructor.MAX_SLEEP_LEVEL / 2));
  // }
  //
  // @Test
  // public void feed_increasesConstructorFoodLevel(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   testConstructor.feed();
  //   assertTrue(testConstructor.getFoodLevel() > (Constructor.MAX_FOOD_LEVEL / 2));
  // }
  //
  // @Test
  // public void fireMonster_foodLevelCannotGoBeyondMaxValue(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   for(int i = Constructor.MIN_ALL_LEVELS; i <= (Constructor.MAX_FOOD_LEVEL); i++){
  //     try {
  //       testConstructor.feed();
  //     } catch (UnsupportedOperationException exception){ }
  //   }
  //   assertTrue(testConstructor.getFoodLevel() <= Constructor.MAX_FOOD_LEVEL);
  // }
  //
  // @Test(expected = UnsupportedOperationException.class)
  // public void feed_throwsExceptionIfFoodLevelIsAtMaxValue(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   for(int i = Constructor.MIN_ALL_LEVELS; i <= (Constructor.MAX_FOOD_LEVEL); i++){
  //     testConstructor.feed();
  //   }
  // }
  //
  // @Test(expected = UnsupportedOperationException.class)
  // public void play_throwsExceptionIfPlayLevelIsAtMaxValue(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   for(int i = Constructor.MIN_ALL_LEVELS; i <= (Constructor.MAX_PLAY_LEVEL); i++){
  //     testConstructor.play();
  //   }
  // }
  //
  // @Test
  // public void fireMonster_playLevelCannotGoBeyondMaxValue(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   for(int i = Constructor.MIN_ALL_LEVELS; i <= (Constructor.MAX_PLAY_LEVEL); i++){
  //     try {
  //       testConstructor.play();
  //     } catch (UnsupportedOperationException exception){ }
  //   }
  //   assertTrue(testConstructor.getPlayLevel() <= Constructor.MAX_PLAY_LEVEL);
  // }
  //
  // @Test(expected = UnsupportedOperationException.class)
  // public void sleep_throwsExceptionIfSleepLevelIsAtMaxValue(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   for(int i = Constructor.MIN_ALL_LEVELS; i <= (Constructor.MAX_SLEEP_LEVEL); i++){
  //     testConstructor.sleep();
  //   }
  // }
  //
  // @Test
  // public void save_assignsIdToObject() {
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   testConstructor.save();
  //   Constructor savedConstructor = Constructor.all().get(0);
  //   assertEquals(testConstructor.getId(), savedConstructor.getId());
  // }
  //
  // @Test
  // public void fireMonster_sleepLevelCannotGoBeyondMaxValue(){
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   for(int i = Constructor.MIN_ALL_LEVELS; i <= (Constructor.MAX_SLEEP_LEVEL); i++){
  //     try {
  //       testConstructor.sleep();
  //     } catch (UnsupportedOperationException exception){ }
  //   }
  //   assertTrue(testConstructor.getSleepLevel() <= Constructor.MAX_SLEEP_LEVEL);
  // }
  //
  // @Test
  // public void save_recordsTimeOfCreationInDatabase() {
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   testConstructor.save();
  //   Timestamp savedConstructorBirthday = Constructor.find(testConstructor.getId()).getBirthday();
  //   Timestamp rightNow = new Timestamp(new Date().getTime());
  //   assertEquals(rightNow.getDay(), savedConstructorBirthday.getDay());
  // }
  //
  // @Test
  // public void sleep_recordsTimeLastSleptInDatabase() {
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   testConstructor.save();
  //   testConstructor.sleep();
  //   Timestamp savedConstructorLastSlept = Constructor.find(testConstructor.getId()).getLastSlept();
  //   Timestamp rightNow = new Timestamp(new Date().getTime());
  //   assertEquals(DateFormat.getDateTimeInstance().format(rightNow), DateFormat.getDateTimeInstance().format(savedConstructorLastSlept));
  // }
  //
  // @Test
  // public void feed_recordsTimeLastAteInDatabase() {
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   testConstructor.save();
  //   testConstructor.feed();
  //   Timestamp savedConstructorLastAte = Constructor.find(testConstructor.getId()).getLastAte();
  //   Timestamp rightNow = new Timestamp(new Date().getTime());
  //   assertEquals(DateFormat.getDateTimeInstance().format(rightNow), DateFormat.getDateTimeInstance().format(savedConstructorLastAte));
  // }
  //
  // @Test
  // public void play_recordsTimeStartedInDatabase() {
  //   Constructor testConstructor = new Constructor("GosuHwang", 10, 20);
  //   testConstructor.save();
  //   testConstructor.play();
  //   Timestamp savedConstructorLastPlayed = Constructor.find(testConstructor.getId()).getLastPlayed();
  //   Timestamp rightNow = new Timestamp(new Date().getTime());
  //   assertEquals(DateFormat.getDateTimeInstance().format(rightNow), DateFormat.getDateTimeInstance().format(savedConstructorLastPlayed));
  // }
}
