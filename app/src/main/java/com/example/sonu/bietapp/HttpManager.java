package com.example.sonu.bietapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpManager {


    public static String getData(String uri) {
        try {
            Document doc = Jsoup.connect(uri).get();
            Element element = doc.getElementById("p7VSCb_2");
            Elements input_element = element.getElementsByTag("a");

            StringBuilder sb = new StringBuilder();

            for (Element i_ele: input_element) {
                String key = i_ele.text();
                sb.append(key + "\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
