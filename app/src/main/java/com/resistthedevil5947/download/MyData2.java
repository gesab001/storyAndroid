package com.resistthedevil5947.download;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyData2 {

    JSONArray jsonArray;

    public MyData2(){}
    //    static String[] letters = {"A", "B", "C", "D", "E", "F", "G","H", "I", "J", "K"};
//
//    static String[] names = {"Abraham", "Isaac", "Isaac", "Isaac", "Isaac", "Isaac", "Isaac", "Isaac", "Isaac", "Isaac", "Isaac"};
    public JSONArray getArray(){
        String array = "[{\"letter\": \"A\", \"names\": [\"Abraham sacrifices Isaac\"]}, {\"letter\": \"B\", \"names\": []}, {\"letter\": \"C\", \"names\": []}, {\"letter\": \"D\", \"names\": []}, {\"letter\": \"E\", \"names\": []}, {\"letter\": \"F\", \"names\": []}, {\"letter\": \"G\", \"names\": [\"Gabriel talks to mary\", \"Good samaritan\"]}, {\"letter\": \"H\", \"names\": []}, {\"letter\": \"I\", \"names\": []}, {\"letter\": \"J\", \"names\": [\"Jesus is born\", \"Joseph and Mary escape to Egypt\", \"Jesus lost in jerusalem\", \"Jesus is baptized\", \"Jesus attends a wedding\", \"Jesus teaches the beautitudes\", \"Jesus talks about the prodigal son\", \"Jesus is fasting in the wilderness\", \"Jesus talks about the end of the world\", \"Jesus feeds 5,000\", \"Jesus walks on the water\", \"Jesus is resurrected\"]}, {\"letter\": \"K\", \"names\": []}, {\"letter\": \"L\", \"names\": [\"Lazarus\"]}, {\"letter\": \"M\", \"names\": []}, {\"letter\": \"N\", \"names\": []}, {\"letter\": \"O\", \"names\": []}, {\"letter\": \"P\", \"names\": []}, {\"letter\": \"Q\", \"names\": []}, {\"letter\": \"R\", \"names\": []}, {\"letter\": \"S\", \"names\": []}, {\"letter\": \"T\", \"names\": []}, {\"letter\": \"U\", \"names\": []}, {\"letter\": \"V\", \"names\": []}, {\"letter\": \"W\", \"names\": [\"Wise men visit baby Jesus\"]}, {\"letter\": \"X\", \"names\": []}, {\"letter\": \"Y\", \"names\": []}, {\"letter\": \"Z\", \"names\": [\"Zacchaeus\"]}]";
        try {
            jsonArray = new JSONArray(array);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;

    }
}