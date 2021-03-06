package com.mooovi.scraping.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapingDetailImages {

    public static void main(String[] args){
        try {
            List<String> links = collectPageLink();
            for(String link : links){
                scraping(link);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> collectPageLink() throws IOException {
        List<String> links = new ArrayList<>();
        Document document = Jsoup.connect("http://review-movie.herokuapp.com").get();
        Elements elements = document.select(".entry-title a");
        for(Element element : elements) {
        		links.add(element.attr("href"));
        }
        return links;
    }

    public static void scraping(String link) throws IOException {
        Document document = Jsoup.connect("http://review-movie.herokuapp.com" + link).get();
        Elements elements = document.select(".entry-content img");
        Element element = elements.first();
        	System.out.println(element.attr("src"));
        
    }

}
