package org.example;

public class AthleteEvent {
    private String id;
    private String name;
    private String sex;
    private String age;
    private String height;
    private String weight;
    private String team;
    private String noc;
    private String games;
    private String year;
    private String season;
    private String city;
    private String sport;
    private String event;
    private String medal;

    public int getId() {
        return Integer.parseInt(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex.charAt(0);
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return Integer.parseInt(age);
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getHeight() {
        return Integer.parseInt(height);
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return Integer.parseInt(weight);
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNoc() {
        return noc;
    }

    public void setNoc(String noc) {
        this.noc = noc;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public int getYear() {
        return Integer.parseInt(year);
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getSeason() {
        return Integer.parseInt(season);
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMedal() {
        return medal;
    }

    public void setMedal(String medal) {
        this.medal = medal;
    }

    @Override
    public String toString() {
        return "AthleteEvent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", event='" + event + '\'' +
                ", medal='" + medal + '\'' +
                '}';
    }
}
