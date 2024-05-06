package com.example.mymusc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.mzk);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                    // Kullanıcı adı ve şifre doğru ise yeni sayfaya yönlendir
                    Intent intent = new Intent(MainActivity.this,MusicActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "Hatalı kullanıcı adı veya şifre!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
