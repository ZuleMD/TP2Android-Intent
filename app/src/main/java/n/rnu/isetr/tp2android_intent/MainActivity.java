package n.rnu.isetr.tp2android_intent;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        e=findViewById(R.id.edit1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log = e.getText().toString();
                if (e.length() == 0)
                    Toast.makeText(getApplicationContext(),
                            "champs vide",
                            Toast.LENGTH_LONG).show();
                else {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("log",log);
                    startActivity(i);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, "Event Title");
                Date udate;
                try {
                    udate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-12-31");
                } catch (ParseException e) {
                    udate = new Date();
                }
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, udate.getTime());
                //intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, DateTime);
                intent.putExtra(CalendarContract.Events.ALL_DAY, false);
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Event Descripttion");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location");
                startActivity(Intent.createChooser(intent, "Add to calendar"));
            }
        });

    }
}