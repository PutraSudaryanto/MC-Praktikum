package co.ommu.mcp6;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivityDua extends Activity {
    public SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dua);

        Button btn = (Button) findViewById(R.id.button);
        pref = getSharedPreferences("detail", MODE_PRIVATE);

        final String name = pref.getString("Urlname", "novalue");
        final int val = pref.getInt("Intvalue", 0);
        final float fval = pref.getFloat("Floatvalue", 0);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                //TODO Auto-generated method stub
                LinearLayout I = (LinearLayout) findViewById(R.id.linierlayout);

                TextView tv = new TextView(MainActivityDua.this);
                tv.setText(name);
                tv.setTextColor(Color.GREEN);
                I.addView(tv);

                TextView tv1 = new TextView(MainActivityDua.this);
                tv1.setText(Integer.toString(val));
                tv1.setTextColor(Color.GREEN);
                I.addView(tv1);

                TextView tv2 = new TextView(MainActivityDua.this);
                tv2.setText(Float.toString(fval));
                tv2.setTextColor(Color.GREEN);
                I.addView(tv2);
            }
        });
    }
}
