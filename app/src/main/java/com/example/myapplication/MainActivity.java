package com.example.myapplication;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private Switch darkModeSwitch;
    private TextView title, subtitle, textDarkMode, uploadLabel;
    private EditText name, password, confirmPassword;
    private CheckBox termsCheckbox;
    private Button registerButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos
        darkModeSwitch = findViewById(R.id.switch_dark_mode);
        title = findViewById(R.id.title);
        subtitle = findViewById(R.id.subtitle);
        textDarkMode = findViewById(R.id.text_dark_mode);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        uploadLabel = findViewById(R.id.upload_label);
        termsCheckbox = findViewById(R.id.terms_checkbox);
        registerButton = findViewById(R.id.register_button);
        resetButton = findViewById(R.id.reset_button);

        // Listener para el Switch de modo oscuro
        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Modo oscuro activado
                findViewById(R.id.main).setBackgroundColor(Color.BLACK); // Fondo negro
                cambiarColorLetras(Color.WHITE); // Letras blancas
                cambiarIconoSwitch(R.drawable.ic_sun); // Cambiar ícono a Sol
                textDarkMode.setText("Light mode"); // Cambiar texto a Light mode
            } else {
                // Modo oscuro desactivado
                findViewById(R.id.main).setBackgroundColor(Color.WHITE); // Fondo blanco
                cambiarColorLetras(getResources().getColor(R.color.light_purple)); // Letras morado claro
                cambiarIconoSwitch(R.drawable.ic_moon); // Cambiar ícono a Luna
                textDarkMode.setText("Dark mode"); // Cambiar texto a Dark mode
            }
        });
    }

    // Método para cambiar el color de las letras dinámicamente
    private void cambiarColorLetras(int color) {
        title.setTextColor(color);
        subtitle.setTextColor(color);
        textDarkMode.setTextColor(color);
        uploadLabel.setTextColor(color);
        name.setTextColor(color);
        name.setHintTextColor(color);
        password.setTextColor(color);
        password.setHintTextColor(color);
        confirmPassword.setTextColor(color);
        confirmPassword.setHintTextColor(color);
        termsCheckbox.setTextColor(color);
        registerButton.setTextColor(color);
        resetButton.setTextColor(color);
    }

    // Método para cambiar el ícono del Switch
    private void cambiarIconoSwitch(int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(this, drawableId);
        if (drawable != null) {
            darkModeSwitch.setThumbDrawable(drawable);
        }
    }
}