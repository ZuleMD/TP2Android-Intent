package n.rnu.isetr.tp2android_intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        v1=findViewById(R.id.view1);
        Bundle extra=getIntent().getExtras();
        String log =extra.getString("log");
        v1.setText(log);
    }
}