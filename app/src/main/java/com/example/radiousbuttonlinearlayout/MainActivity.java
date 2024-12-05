package com.example.radiousbuttonlinearlayout;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    RadioGroup orientation;
    RadioGroup gravity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        orientation = (RadioGroup)findViewById(R.id.orientation);
        orientation.setOnCheckedChangeListener(this);

        gravity = (RadioGroup)findViewById(R.id.gravity);
        gravity.setOnCheckedChangeListener(this);

        LinearLayout mainLayout = findViewById(R.id.main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (group.getId() == R.id.orientation) {
            // Cambiar orientación de los botones dentro de este grupo
            if (checkedId == R.id.horizontal) {
                orientation.setOrientation(LinearLayout.HORIZONTAL);
            } else if (checkedId == R.id.vertical) {
                orientation.setOrientation(LinearLayout.VERTICAL);
            }
        } else if (group.getId() == R.id.gravity) {
            // Cambiar gravedad del RadioGroup correspondiente
            if (checkedId == R.id.left) {
                gravity.setGravity(Gravity.START);
            } else if (checkedId == R.id.center) {
                gravity.setGravity(Gravity.CENTER_HORIZONTAL);
            } else if (checkedId == R.id.right) {
                gravity.setGravity(Gravity.END);
            }
        }
    }
}