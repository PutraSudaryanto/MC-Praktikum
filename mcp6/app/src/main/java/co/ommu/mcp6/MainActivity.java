package co.ommu.mcp6;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    public SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Auto-generated method stub
                String str="www.androidprogramz.in";
                int no = 234;
                float fno = 234.234f;

                pref = getSharedPreferences("detail", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("Urlname",str);
                editor.putInt("Intvalue",no);
                editor.putFloat("Floatvalue",fno);
                editor.commit();

                Intent i = new Intent(getBaseContext(), MainActivityDua.class);
                startActivityForResult(i, 0);
            }
        });
    }
}
