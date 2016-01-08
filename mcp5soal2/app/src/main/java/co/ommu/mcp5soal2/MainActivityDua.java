package co.ommu.mcp5soal2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityDua extends Activity implements View.OnClickListener {
    Button exit, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dua);
        back = (Button) findViewById(R.id.back);
        exit = (Button) findViewById(R.id.exit);
        back.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_main2, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        try {
            if (v.getId() == R.id.exit) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Apakah Anda Ingin Keluar?")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            MainActivityDua.this.finish();
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
            } else if (v.getId() == R.id.back) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivityForResult(i, 0);
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Hahaha", Toast.LENGTH_SHORT).show();
        }
    }
}
