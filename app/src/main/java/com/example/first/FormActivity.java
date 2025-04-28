package com.example.first;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    EditText etName, etPhone, etEmail;
    Button btnSave, btnViewData;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        btnSave = findViewById(R.id.btnSave);
        btnViewData = findViewById(R.id.btnViewData);

        dbHelper = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();

                boolean inserted = dbHelper.insertUser(name, phone, email);

                if (inserted) {
                    Toast.makeText(FormActivity.this, "Data Saved!", Toast.LENGTH_SHORT).show();
                    etName.setText("");
                    etPhone.setText("");
                    etEmail.setText("");
                } else {
                    Toast.makeText(FormActivity.this, "Error Saving Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open Display Activity
                Intent intent = new Intent(FormActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }
}
