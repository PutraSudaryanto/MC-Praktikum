package co.ommu.mcp4soal2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText username, password;
    Button login;
    String user = "yuni", pass = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onClick(View arg0) {
        try {
            if (arg0.getId() == R.id.login) {
                if (username.getText().toString().equals("") && password.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Username dan Password tidak boleh kosong", Toast.LENGTH_LONG).show();
                else {
                    if (username.getText().toString().equals(user) && password.getText().toString().equals(pass)) {
                        Intent i = new Intent(getBaseContext(), MainActivityDua.class);
                        startActivityForResult(i, 0);
                    } else
                        Toast.makeText(getBaseContext(), "Anda Tidak Berhak Masuk", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Anda Tidak Berhak	Masuk", Toast.LENGTH_LONG).show();
        }
    }
}
