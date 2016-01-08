package co.ommu.mcp7;

/**
 * Created by Putra Sudaryanto on 1/8/2016.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCreateLocation = (Button) findViewById(R.id.buttonCreateStudent);
        buttonCreateLocation.setOnClickListener(new OnClickListenerCreateStudent());
        countRecords();
        readRecords();
    }

    public void countRecords() {
        int recordCount = new TableControllerStudent(this).count();
        TextView textViewRecordCount = (TextView) findViewById(R.id.textViewRecordCount);
        textViewRecordCount.setText(recordCount + " records found.");
    }

    public void readRecords() {
        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();
        List<ObjectStudent> students = new TableControllerStudent(this).read();
        if (students.size() > 0) {
            for (ObjectStudent obj : students) {
                int id = obj.id;
                String studentFirstname = obj.firstname;
                String studentEmail = obj.email;
                String textViewContents = studentFirstname + " - " + studentEmail;
                TextView textViewLocationItem = new TextView(this);
                textViewLocationItem.setPadding(0, 10, 0, 10);
                textViewLocationItem.setText(textViewContents);
                textViewLocationItem.setTag(Integer.toString(id));
                textViewLocationItem.setOnLongClickListener(new OnLongClickListenerStudentRecord());
                linearLayoutRecords.addView(textViewLocationItem);
            }
        } else {
            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records yet.");
            linearLayoutRecords.addView(locationItem);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
