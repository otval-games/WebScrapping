package org.example.Modules;

public class Weather {
    private final int day;
    private final String month;
    private final String min;
    private final String max;

    public Weather(int day, String month, String min, String max){
        this.day = day;
        this.month = month;
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "Дата: "+day+" "+month+" 2024; мин. темп.: "+min+"; макс. темп.: "+max;
    }
}
