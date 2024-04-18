package org.example;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {



    @Test
    void testFindTheNameOfAthleteParticipatedInMoreThanThreeOlympics() {
        List<String> expectedResult = List.of("Messi", "Ronaldo");

        List<String > actualResult = Main.findTheNameOfAthleteParticipatedInMoreThanThreeOlympics(getAthleteEventsData());
        assertLinesMatch(expectedResult, actualResult);
    }

    @Test
    void testFindFemaleAthleteWonMaximumNumberOfGoldAllOlympics() {
        Map<Integer, String> expectedResult = new TreeMap<>(Collections.reverseOrder());
        expectedResult.put(2016, "Sindhu");expectedResult.put(1980, "Mandhana");

        Map<Integer, String> actualResult = Main.findFemaleAthleteWonMaximumNumberOfGoldAllOlympics(getAthleteEventsData());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testFindGoldWinnerOfFootballOfEveryOlympic() {
        Map<Integer, String[]> expectedResult = new TreeMap<>(Collections.reverseOrder());
        expectedResult.put(2014, new String[]{"Argentine"});expectedResult.put(2016, new String[]{"Portuguese"});

        Map<Integer, String[]> actualResult = Main.findGoldWinnerOfFootballOfEveryOlympic(getAthleteEventsData());
        assertArrayEquals(expectedResult.get(2014), actualResult.get(2014));
        assertArrayEquals(expectedResult.get(2016), actualResult.get(2016));
    }

    @Test
    void testFindEventWiseNumberOfGoldSilverBronzeMedalsInYear1980() {
        Map<String, Map<String, Integer>> expectedResult = new TreeMap<>();
        Map<String, Integer> weightLiftingMedals = new TreeMap<>();
        weightLiftingMedals.put("Gold", 1);
        expectedResult.put("Women's Weight Lifting", weightLiftingMedals);

        Map<String, Integer> hockeyMedals = new TreeMap<>();
        hockeyMedals.put("Gold", 1);
        expectedResult.put("Hockey Men's Hockey", hockeyMedals);

        Map<String, Map<String, Integer>> actualResult = Main.findEventWiseNumberOfGoldSilverBronzeMedalsInYear1980(getAthleteEventsData());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testFindAthletesWhoWonGoldMedalIn1980AndAgeIsLessThan30Years() {
        List<String> expectedResult = List.of("Mandhana", "Shaukat Ali");

        List<String> actualResult = Main.findAthletesWhoWonGoldMedalIn1980AndAgeIsLessThan30Years(getAthleteEventsData());
        assertTrue(expectedResult.equals(actualResult));
    }

    @Test
    void testFindNumberOfGoldMedalsWonByEachPlayerEachYear() {
        Map<Integer,Map<String, Integer>> expectedResult = new TreeMap<>();
        Map<String, Integer> year1980 = new TreeMap<>();
        year1980.put("Mandhana", 1);
        year1980.put("Shaukat Ali", 1);
        expectedResult.put(1980, year1980);

        Map<String, Integer> year2014 = new TreeMap<>();
        year2014.put("Messi", 1);
        expectedResult.put(2014, year2014);

        Map<String, Integer> year2016 = new TreeMap<>();
        year2016.put("Ronaldo", 1);
        year2016.put("Sindhu", 1);
        expectedResult.put(2016, year2016);

        Map<Integer,Map<String, Integer>> actualResult = Main.findNumberOfGoldMedalsWonByEachPlayerEachYear(getAthleteEventsData());
        assertEquals(expectedResult, actualResult);
    }
    public static List<AthleteEvent> getAthleteEventsData(){
        List<AthleteEvent> athleteEvents = new ArrayList<>();
        AthleteEvent athleteEvent1 = new AthleteEvent();
        athleteEvent1.setName("Ronaldo");
        athleteEvent1.setYear("2016");
        athleteEvent1.setMedal("Gold");
        athleteEvent1.setAge("35");
        athleteEvent1.setSport("Football");
        athleteEvent1.setSex("M");
        athleteEvent1.setEvent("Football Men's Football");
        athleteEvent1.setTeam("Portuguese");
        athleteEvents.add(athleteEvent1);

        AthleteEvent athleteEvent2 = new AthleteEvent();
        athleteEvent2.setName("Ronaldo");
        athleteEvent2.setYear("2014");
        athleteEvent2.setMedal("Bronze");
        athleteEvent2.setAge("33");
        athleteEvent2.setSport("Football");
        athleteEvent2.setSex("M");
        athleteEvent2.setEvent("Football Men's Football");
        athleteEvent2.setTeam("Portuguese");
        athleteEvents.add(athleteEvent2);

        AthleteEvent athleteEvent3 = new AthleteEvent();
        athleteEvent3.setName("Ronaldo");
        athleteEvent3.setYear("2012");
        athleteEvent3.setMedal("Silver");
        athleteEvent3.setAge("31");
        athleteEvent3.setSport("Football");
        athleteEvent3.setSex("M");
        athleteEvent3.setEvent("Football Men's Football");
        athleteEvent3.setTeam("Portuguese");
        athleteEvents.add(athleteEvent3);

        AthleteEvent athleteEvent4 = new AthleteEvent();
        athleteEvent4.setName("Mandhana");
        athleteEvent4.setYear("1980");
        athleteEvent4.setMedal("Gold");
        athleteEvent4.setAge("29");
        athleteEvent4.setSport("Weight Lifting");
        athleteEvent4.setSex("F");
        athleteEvent4.setEvent("Women's Weight Lifting");
        athleteEvent4.setTeam("India");
        athleteEvents.add(athleteEvent4);

        AthleteEvent athleteEvent5 = new AthleteEvent();
        athleteEvent5.setName("Ronaldo");
        athleteEvent5.setYear("2010");
        athleteEvent5.setMedal("Bronze");
        athleteEvent5.setAge("29");
        athleteEvent5.setSport("Football");
        athleteEvent5.setSex("M");
        athleteEvent5.setEvent("Football Men's Football");
        athleteEvent5.setTeam("Portuguese");
        athleteEvents.add(athleteEvent5);

        AthleteEvent athleteEvent6 = new AthleteEvent();
        athleteEvent6.setName("Messi");
        athleteEvent6.setYear("2016");
        athleteEvent6.setMedal("Silver");
        athleteEvent6.setAge("34");
        athleteEvent6.setSport("Football");
        athleteEvent6.setSex("M");
        athleteEvent6.setEvent("Football Men's Football");
        athleteEvent6.setTeam("Argentine");
        athleteEvents.add(athleteEvent6);

        AthleteEvent athleteEvent7 = new AthleteEvent();
        athleteEvent7.setName("Messi");
        athleteEvent7.setYear("2014");
        athleteEvent7.setMedal("Gold");
        athleteEvent7.setAge("32");
        athleteEvent7.setSport("Football");
        athleteEvent7.setSex("M");
        athleteEvent7.setEvent("Football Men's Football");
        athleteEvent7.setTeam("Argentine");
        athleteEvents.add(athleteEvent7);

        AthleteEvent athleteEvent8 = new AthleteEvent();
        athleteEvent8.setName("Messi");
        athleteEvent8.setYear("2012");
        athleteEvent8.setMedal("Silver");
        athleteEvent8.setAge("30");
        athleteEvent8.setSport("Football");
        athleteEvent8.setSex("M");
        athleteEvent8.setEvent("Football Men's Football");
        athleteEvent8.setTeam("Argentine");
        athleteEvents.add(athleteEvent8);

        AthleteEvent athleteEvent9 = new AthleteEvent();
        athleteEvent9.setName("Messi");
        athleteEvent9.setYear("2010");
        athleteEvent9.setMedal("Bronze");
        athleteEvent9.setAge("28");
        athleteEvent9.setSport("Football");
        athleteEvent9.setSex("M");
        athleteEvent9.setEvent("Football Men's Football");
        athleteEvent9.setTeam("Argentine");
        athleteEvents.add(athleteEvent9);

        AthleteEvent athleteEvent10 = new AthleteEvent();
        athleteEvent10.setName("Sindhu");
        athleteEvent10.setYear("2016");
        athleteEvent10.setMedal("Gold");
        athleteEvent10.setAge("26");
        athleteEvent10.setSport("Badminton");
        athleteEvent10.setSex("F");
        athleteEvent10.setEvent("Women's Single Badminton");
        athleteEvent10.setTeam("India");
        athleteEvents.add(athleteEvent10);

        AthleteEvent athleteEvent11 = new AthleteEvent();
        athleteEvent11.setName("Shaukat Ali");
        athleteEvent11.setYear("1980");
        athleteEvent11.setMedal("Gold");
        athleteEvent11.setAge("29");
        athleteEvent11.setSport("Hockey");
        athleteEvent11.setSex("M");
        athleteEvent11.setEvent("Hockey Men's Hockey");
        athleteEvent11.setTeam("India");
        athleteEvents.add(athleteEvent11);
        return athleteEvents;
    }
}