
//Name: Khushi Patel
//Id: A00198843
//MAD204-JAVA
package com.example.myintro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etAge, etProgram;
    private Button btnIntroduce;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect widgets
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etProgram = findViewById(R.id.etProgram);
        btnIntroduce = findViewById(R.id.btnIntroduce);
        tvOutput = findViewById(R.id.tvOutput);

        // Set button click listener
        btnIntroduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                String ageStr = etAge.getText().toString().trim();
                String program = etProgram.getText().toString().trim();

                // Input validation
                if (name.isEmpty()) {
                    tvOutput.setText("Error: Name cannot be empty.");
                    return;
                }
                if (ageStr.isEmpty()) {
                    tvOutput.setText("error: Age cannot be empty.");
                    return;
                }

                int age;
                try {
                    age = Integer.parseInt(ageStr);
                    if (age <= 0) {
                        tvOutput.setText("error: Age must be greater than 0.");
                        return;
                    }
                } catch (NumberFormatException e) {
                    tvOutput.setText("error: Age must be a number.");
                    return;
                }

                if (program.isEmpty()) {
                    tvOutput.setText("error: Program cannot be empty.");
                    return;
                }

                // If all inputs valid
                String message = "Hello! My name is " + name + ", I am " + age + " years old, and I study " + program + ".";
                tvOutput.setText(message);
            }
        });
    }
}
