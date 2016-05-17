package com.example.mzglinicki96.yourowndictionary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread() {

            @Override
            public void run() {
                try {
                    translate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

    public void translate() throws Exception {
        //Replace client_id and client_secret with your own.

        Translate.setClientId("mzglinicki96");
        Translate.setClientSecret("udiNG2vCp/+XUoTuP3KVGSXUG3yC/l98NUnIPHbLNA8=");

        // Translate an english string to spanish
        String englishString = "Hello World!";
        String spanishTranslation = Translate.execute(englishString, Language.POLISH);

        Log.e("dupa", "Original english phrase: " + englishString);
        Log.e("dupa", "Translated spanish phrase: " + spanishTranslation);
    }

}
