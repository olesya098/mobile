package com.example.clicer2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int tet = 0;
    private int level = 1;
    private TextView textView;
    private int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton click = findViewById(R.id.imageButton);
        textView = findViewById(R.id.textView1);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tet += level;
                clicks++;
                if (clicks % 20 == 0) {
                    level++;
                    Toast.makeText(MainActivity.this, "Ваш уровень был повышен до " + level, Toast.LENGTH_SHORT).show();
                }
                update();
            }
        });

        // Обработчик для другой кнопки
        ImageButton otherButton = findViewById(R.id.imageButton1);
        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tet = 0;
                level = 1;
                clicks = 0; // Сбрасываем счетчик нажатий
                Toast.makeText(MainActivity.this, "Все баллы были аннулированы", Toast.LENGTH_SHORT).show();
                update();
            }
        });
    }

    private void update() {
        textView.setText("Уровень: " + level + "\nКлики: " + tet);
    }
}
