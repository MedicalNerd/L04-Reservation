package sg.edu.rp.c346.id22021421.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etName, etMobile, etGroupSize;
    DatePicker dpBookingDate;
    TimePicker tpBookingTime;
    RadioGroup rgTableType;
    RadioButton rbSmoking, rbNonSmoking;
    Button btnConfirm, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextTextName);
        etMobile = findViewById(R.id.editTextNumberMobile);
        etGroupSize = findViewById(R.id.editTextNumbergroup);
        dpBookingDate = findViewById(R.id.datePicker);
        tpBookingTime = findViewById(R.id.timePicker);
        rgTableType = findViewById(R.id.smoke);
        btnConfirm = findViewById(R.id.Confirmbutton);
        btnReset = findViewById(R.id.Resetbutton);
        rbNonSmoking = findViewById(R.id.nonsmoking);
        rbSmoking=findViewById(R.id.smoking);


        dpBookingDate.updateDate(2020, 5, 1);
        tpBookingTime.setCurrentHour(19);
        tpBookingTime.setCurrentMinute(30);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String mobile = etMobile.getText().toString();

                int groupSize = Integer.parseInt(etGroupSize.getText().toString());
                int year = dpBookingDate.getYear();
                int month = dpBookingDate.getMonth();
                int dayOfMonth = dpBookingDate.getDayOfMonth();
                int hour = tpBookingTime.getCurrentHour();
                int minute = tpBookingTime.getCurrentMinute();
                if (rbSmoking.isChecked()){
                    String message = "Name: " + name + "\nMobile number: " + mobile + "\nGroup size: " + groupSize
                            + "\nDate: " + dayOfMonth + "/" + (month + 1) + "/" + year + "\nTime: " + String.format("%02d:%02d", hour, minute)
                            + "\nTable type: Smoking" ;
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
                else{
                    String message = "Name: " + name + "\nMobile number: "
                                    + mobile + "\nGroup size: " + groupSize
                                    + "\nDate: " + dayOfMonth + "/" + (month + 1) + "/" + year + "\nTime: " + String.format("%02d:%02d", hour, minute)
                            + "\nTable type: Non-Smoking" ;
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etMobile.setText("");
                etGroupSize.setText("");
                dpBookingDate.updateDate(2020, 5, 1);
                tpBookingTime.setCurrentHour(19);
                tpBookingTime.setCurrentMinute(30);
                rbSmoking.setChecked(false);
                rbNonSmoking.setChecked(false);
            }
        });
    }
}