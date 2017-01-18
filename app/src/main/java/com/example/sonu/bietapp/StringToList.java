package com.example.sonu.bietapp;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringToList {

    public static List<String> List(String content){

        List<String> noticeList = new ArrayList<>();
        try{
            StringTokenizer token = new StringTokenizer(content, "\n");
            while(token.hasMoreTokens()){
                noticeList.add(token.nextToken());
            }
            return noticeList;
        }catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }
}
