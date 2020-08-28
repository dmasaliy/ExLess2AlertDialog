package com.example.exless2alertdialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentProviderClient;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView colaredText;

    Button simpleDialog;
    Button simpleChoiseDialog;
    Button multiChoiseDialog;
    Button customDialog;
    Button datePicker;
    Button login;

    int year;
    int month;
    int dyOfMonth;

    HashMap<String, String> users = new HashMap<String, String>();

    public static final int FIRST_ITEM = 0;
    public static final int SECOND_ITEM = 1;
    public static final int THIRST_ITEM = 2;



    boolean Checked[] = new boolean[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users.put("log","login");
        users.put("pas");

        simpleDialog = findViewById((R.id.simple_dialog));
        simpleDialog.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Answer!")
                    .setMessage("2 + 2 = 4?")
                    .setPositiveButton("Ok", (dialog, which) -> {
                        Toast.makeText(this, "Right answer", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("No", (dialog, which) -> {
                        Toast.makeText(this, "Ti durak?", Toast.LENGTH_SHORT).show();
                    })
                    .setNeutralButton("niznayu", (dialog, which) -> {
                        Toast.makeText(this, "Ti durak?", Toast.LENGTH_SHORT).show();

                    });

            AlertDialog dialog = builder.create();
            dialog.show();

        });

        colaredText = findViewById((R.id.colaredText));

        simpleChoiseDialog = findViewById((R.id.simple_choise_dialog));
        simpleChoiseDialog.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("multi Choise")

                    .setSingleChoiceItems(new String[]{"red", "green", "blue"}, -1, (dialog, which) -> {
                        switch (which) {
                            case 0:
                                colaredText.setTextColor(Color.RED);
                                break;
                            case 1:
                                colaredText.setTextColor(Color.GREEN);
                                break;
                            case 2:
                                colaredText.setTextColor(Color.BLUE);
                                break;
                        }


                    })
                    .setNegativeButton("No", (dialog, which) -> {
                        Toast.makeText(this, "Ti durak?", Toast.LENGTH_SHORT).show();
                    });

            AlertDialog dialog = builder.create();
            dialog.show();

        });

        multiChoiseDialog = findViewById(R.id.multi_choise_dialog);
        multiChoiseDialog.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(("Multi Choise"))
                    .setMultiChoiceItems(new String[]{"first", "second ", "thirst"}, Checked, (dialog, which, isChecked) -> {
                        StringBuilder sb = new StringBuilder();
                        for(int i = 0; i < Checked.length; i++){
                            if(Checked[i]){
                                sb.append("checked" + i);
                            }else{
                                sb.append("uncheked" + i);
                            }
                        }
                        builder.setTitle(sb.toString());
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        });

        customDialog = findViewById(R.id.custom_dialog);
        customDialog.setOnClickListener( v ->{

            View customView = getLayoutInflater().inflate(R.layout.dialog_view, null, false);

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("enter y name")
                    .setView(customView)
                    .setPositiveButton("ok", (dialog, which) -> {
                        EditText name = customView.findViewById(R.id.name);
                        Toast.makeText(this, "Hello" + name.getText().toString(), Toast.LENGTH_SHORT).show();
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        datePicker = findViewById(R.id.date_picker_dialog);
        datePicker.setOnClickListener( v ->{

            Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            dyOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog ( MainActivity.this, null,year,month,dyOfMonth ){
                @Override
                public void onDateChanged(@NonNull DatePicker view, int year, int month, int dayOfMonth) {
                    MainActivity.this.year = year;
                    MainActivity.this.month = month;
                    MainActivity.this.dyOfMonth = dayOfMonth;

                    Toast.makeText(MainActivity.this, "Date : " + year + "/" + ++month + "/" + dayOfMonth,
                            Toast.LENGTH_SHORT).show();
                }
            };
            dialog.show();
        });

        login = findViewById(R.id.login);
        login.setOnClickListener( v -> {

            View login = getLayoutInflater().inflate(R.layout.registr, null, false);

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle("enter y login / password")
                    .setView(login)
                    .setPositiveButton("ok", (dialog, which) -> {
                        EditText logins = login.findViewById(R.id.login1);
                        EditText passwords = login.findViewById(R.id.password);

                        Toast.makeText(this, "Hello" + logins.getText().toString(), Toast.LENGTH_SHORT).show();

                    });
            AlertDialog dialog = builder.create();
            dialog.show();

        });


    }
}