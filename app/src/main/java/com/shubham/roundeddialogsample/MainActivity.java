package com.shubham.roundeddialogsample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.shubham.roundeddialog.roundedDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button open = findViewById(R.id.open);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new roundedDialog.Builder(MainActivity.this)
                        .setTitle("Dialog")
                        .setMessage("This is a rounded dialog")
                        .setDoneText("Awesome Dialog")
                        .setCancelText("Cancel")
                        .setOnClick(new roundedDialog.onClick() {
                            @Override
                            public void onDone(Dialog dialog) {

                            }

                            @Override
                            public void onCancel(Dialog dialog) {

                            }
                        })
                        .show();

            }
        });
    }
}
