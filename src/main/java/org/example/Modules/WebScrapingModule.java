package org.example.Modules;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class WebScrapingModule {
    public static void sendRequest() {
        String url = "https://ua.sinoptik.ua/";
        ArrayList<Weather> weatherList = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();

            Elements links = doc.select(".main");

            for (Element link : links) {
                Element day = link.select(".date").first();
                Element month = link.select(".month").first();

                Element temp = link.select(".temperature").first();
                Element min = Objects.requireNonNull(temp.select(".min").select("span").first());
                Element max = Objects.requireNonNull(temp.select(".max").select("span").first());

                weatherList.add(new Weather(Integer.parseInt(day.text()), month.text(), min.text(), max.text()));

            }
            weatherList.stream().forEach(x -> System.out.println(x.toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
