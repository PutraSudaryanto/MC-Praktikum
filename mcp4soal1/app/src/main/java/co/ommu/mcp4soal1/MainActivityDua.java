package co.ommu.mcp4soal1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityDua extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dua);

        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //onBackPressed();
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
                // TODO Auto-generated method stub
            }
        });
    }
}
