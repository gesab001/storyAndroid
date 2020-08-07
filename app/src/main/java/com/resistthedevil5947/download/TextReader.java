package com.resistthedevil5947.download;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class TextReader {

    Context context;
    TextToSpeech t1;
    public TextReader(Context context){
        this.context = context;
        t1=new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                    Double obj = new Double("0.5");
                    t1.setSpeechRate(obj.floatValue());
                }
            }
        });
    }

    public void read(String caption){
       t1.speak(caption, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void stop(){
        t1.stop();
    }

    public void exit(){
        t1.shutdown();
    }
}
