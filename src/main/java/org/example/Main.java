package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static final int ID = 0;
    private static final int NAME = 1;
    private static final int SEX = 2;
    private static final int AGE = 3;
    private static final int HEIGHT = 4;
    private static final int WEIGHT = 5;
    private static final int TEAM = 6;
    private static final int NOC = 7;
    private static final int GAMES = 8;
    private static final int YEAR = 9;
    private static final int SEASON = 10;
    private static final int CITY = 11;
    private static final int SPORT = 12;
    private static final int EVENT = 13;
    private static final int MEDAL = 14;

    public static void main(String[] args) {
        List<AthleteEvent> athleteEvents = getAthleteEvents();

        Map<Integer,Map<String, Integer>> result1 = findNumberOfGoldMedalsWonByEachPlayerEachYear(athleteEvents);
        System.out.println(result1);
        List<String> result2 = findAthletesWhoWonGoldMedalIn1980AndAgeIsLessThan30Years(athleteEvents);
        System.out.println(result2);
        Map<String, Map<String, Integer>> result3 = findEventWiseNumberOfGoldSilverBronzeMedalsInYear1980(athleteEvents);
        System.out.println(result3);
        Map<Integer, String[]> result4 = findGoldWinnerOfFootballOfEveryOlympic(athleteEvents);
        System.out.println(result4);
        Map<Integer, String> result5 = findFemaleAthleteWonMaximumNumberOfGoldAllOlympics(athleteEvents);
        System.out.println(result5);
        List<String> result6 = findTheNameOfAthleteParticipatedInMoreThanThreeOlympics(athleteEvents);
        System.out.println(result6);
    }

    public static List<String> findTheNameOfAthleteParticipatedInMoreThanThreeOlympics(List<AthleteEvent> athleteEvents) {
        List<String> result = new ArrayList<>();
        try {
            Map<String, Set<Integer>> athleteParticipatedInTheOlympics = new TreeMap<>();
            for (AthleteEvent athleteEvent : athleteEvents) {
                Set<Integer> years = athleteParticipatedInTheOlympics.getOrDefault(athleteEvent.getName(), new HashSet<>());
                years.add(athleteEvent.getYear());
                athleteParticipatedInTheOlympics.put(athleteEvent.getName(), years);
            }
            int i = 0;
            for (Map.Entry<String, Set<Integer>> entry : athleteParticipatedInTheOlympics.entrySet()) {
                if (entry.getValue().size() > 3) {
                    result.add(entry.getKey());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<Integer, String> findFemaleAthleteWonMaximumNumberOfGoldAllOlympics(List<AthleteEvent> athleteEvents) {
        Map<Integer, String> result = new TreeMap<>(Collections.reverseOrder());
        try {
            Map<Integer, Map<String, Integer>> femaleAthleteWonNumberOfGoldEachYear = new TreeMap<>(Collections.reverseOrder());
            for (AthleteEvent athleteEvent : athleteEvents) {
                Map<String, Integer> femaleAthleteWonNumberOfGold = femaleAthleteWonNumberOfGoldEachYear.getOrDefault(athleteEvent.getYear(), new HashMap<>());
                if (athleteEvent.getSex() == 'F' && athleteEvent.getMedal().equals("Gold")) {
                    femaleAthleteWonNumberOfGold.put(athleteEvent.getName(), femaleAthleteWonNumberOfGold.getOrDefault(athleteEvent.getName(), 0) + 1);
                }
                femaleAthleteWonNumberOfGoldEachYear.put(athleteEvent.getYear(), femaleAthleteWonNumberOfGold);
            }
            for (Map.Entry<Integer, Map<String, Integer>> entry : femaleAthleteWonNumberOfGoldEachYear.entrySet()) {
                List<Map.Entry<String, Integer>> femaleAthleteWonNumberOfGold = new LinkedList<>(entry.getValue().entrySet());
                femaleAthleteWonNumberOfGold.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
                for (Map.Entry<String, Integer> entry2 : femaleAthleteWonNumberOfGold) {
                    result.put(entry.getKey(), entry2.getKey());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<Integer, String[]> findGoldWinnerOfFootballOfEveryOlympic(List<AthleteEvent> athleteEvents) {
        Map<Integer, String[]> result = new TreeMap<>(Collections.reverseOrder());
        try {
            Map<Integer, Set<String>> goldWinnerOfFootballOfEveryOlympic = new TreeMap<>(Collections.reverseOrder());
            for (AthleteEvent athleteEvent : athleteEvents) {
                if (athleteEvent.getMedal().equals("Gold") && athleteEvent.getSport().equals("Football")) {
                    Set<String> goldWinners = goldWinnerOfFootballOfEveryOlympic.getOrDefault(athleteEvent.getYear(), new HashSet<>());
                    goldWinners.add(athleteEvent.getTeam());
                    goldWinnerOfFootballOfEveryOlympic.put(athleteEvent.getYear(), goldWinners);
                }
            }
            for (Map.Entry<Integer, Set<String>> entry : goldWinnerOfFootballOfEveryOlympic.entrySet()) {
                String[] teams = new String[entry.getValue().size()];
                int i = 0;
                for (String goldWinner : entry.getValue()) {
                    teams[i] = goldWinner;
                    i++;
                }
                result.put(entry.getKey(), teams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String, Map<String, Integer>> findEventWiseNumberOfGoldSilverBronzeMedalsInYear1980(List<AthleteEvent> athleteEvents) {
        Map<String, Map<String, Integer>> eventWiseNumberOfEachTypeOfMedals = null;
        try {
            eventWiseNumberOfEachTypeOfMedals = new TreeMap<>();
            for (AthleteEvent athleteEvent : athleteEvents) {
                if (athleteEvent.getYear() == 1980) {
                    Map<String, Integer> numberOfEachTypeOfMedals = eventWiseNumberOfEachTypeOfMedals.getOrDefault(athleteEvent.getEvent(), new TreeMap<>());
                    if (athleteEvent.getMedal().equals("NA")) continue;
                    numberOfEachTypeOfMedals.put(athleteEvent.getMedal(), numberOfEachTypeOfMedals.getOrDefault(athleteEvent.getMedal(), 0) + 1);
                    eventWiseNumberOfEachTypeOfMedals.put(athleteEvent.getEvent(), numberOfEachTypeOfMedals);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventWiseNumberOfEachTypeOfMedals;
    }

    public static List<String> findAthletesWhoWonGoldMedalIn1980AndAgeIsLessThan30Years(List<AthleteEvent> athleteEvents) {
        List<String> result = null;
        try {
            Set<String> athletes = new TreeSet<>();
            for (AthleteEvent athleteEvent : athleteEvents) {
                if (athleteEvent.getYear() == 1980 && athleteEvent.getMedal().equals("Gold") && athleteEvent.getAge() < 30) {
                    athletes.add(athleteEvent.getName());
                }
            }
            result = new ArrayList<>();

            for (String athlete : athletes) {
                result.add(athlete);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<Integer,Map<String, Integer>> findNumberOfGoldMedalsWonByEachPlayerEachYear(List<AthleteEvent> athleteEvents) {
        Map<Integer, Map<String, Integer>> goldMedalsWonByEachPlayerEachYear = null;
        try {
            goldMedalsWonByEachPlayerEachYear = new TreeMap<>();
            for (AthleteEvent athleteEvent : athleteEvents) {
                if (!athleteEvent.getMedal().equals("Gold")) continue;
                Map<String, Integer> goldMedalsWonByEachPlayer = goldMedalsWonByEachPlayerEachYear.getOrDefault(athleteEvent.getYear(), new TreeMap<>());
                goldMedalsWonByEachPlayer.put(athleteEvent.getName(), goldMedalsWonByEachPlayer.getOrDefault(athleteEvent.getName(), 0) + 1);
                goldMedalsWonByEachPlayerEachYear.put(athleteEvent.getYear(), goldMedalsWonByEachPlayer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goldMedalsWonByEachPlayerEachYear;
    }

    public static List<AthleteEvent> getAthleteEvents() {
        List<AthleteEvent> athleteEvents = new ArrayList<>();

        File file = new File("data/athlete_events.csv");
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] athleteEventData = row.substring(1).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                for (int j = 0; j < athleteEventData.length; j++) {
                    if (j == 0)
                        athleteEventData[j] = athleteEventData[j].substring(0, athleteEventData[j].length() - 1);
                    if (athleteEventData[j].startsWith("\"") && athleteEventData[j].endsWith("\"")) {
                        athleteEventData[j] = athleteEventData[j].substring(1, athleteEventData[j].length() - 1);
                    }
                }
                AthleteEvent athleteEvent = new AthleteEvent();
                athleteEvent.setId(athleteEventData[ID]);
                athleteEvent.setName(athleteEventData[NAME]);
                athleteEvent.setSex(athleteEventData[SEX]);
                athleteEvent.setAge(athleteEventData[AGE]);
                athleteEvent.setHeight(athleteEventData[HEIGHT]);
                athleteEvent.setWeight(athleteEventData[WEIGHT]);
                athleteEvent.setTeam(athleteEventData[TEAM]);
                athleteEvent.setNoc(athleteEventData[NOC]);
                athleteEvent.setGames(athleteEventData[GAMES]);
                athleteEvent.setYear(athleteEventData[YEAR]);
                athleteEvent.setSeason(athleteEventData[SEASON]);
                athleteEvent.setCity(athleteEventData[CITY]);
                athleteEvent.setSport(athleteEventData[SPORT]);
                athleteEvent.setEvent(athleteEventData[EVENT]);
                athleteEvent.setMedal(athleteEventData[MEDAL]);
                athleteEvents.add(athleteEvent);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return athleteEvents;
    }
}