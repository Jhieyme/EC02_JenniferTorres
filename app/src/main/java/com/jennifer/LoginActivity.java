package com.jennifer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Toast;

import com.jennifer.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.tilEmail.getEditText().getText().toString();
            String password = binding.tilPassword.getEditText().getText().toString();

            // Validacion de ingreso ----------------------------------------------------------

            if (isCredentialsValid(email, password)) {
                if (email.equals("ejemplo@idat.com.pe") && password.equals("Idat1234")) {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Datos no validos", Toast.LENGTH_SHORT).show();
            }
        });

        binding.tilEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Boolean isOk = isCredentialsValid(s.toString(), binding.tilPassword.getEditText().getText().toString());
                binding.btnLogin.setEnabled(isOk);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.tilPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Boolean isOk = isCredentialsValid(binding.tilEmail.getEditText().getText().toString(), s.toString());
                binding.btnLogin.setEnabled(isOk);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    // Validacion de tipo de dato --------------------------------------------------------------------------------

    private Boolean isCredentialsValid(String email, String password) {
        Boolean isEmailValid = !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        Boolean isPasswordValid = password.matches("(?=.*[0-9])(?=.*[a-zA-Z]).{8,}");
        return isEmailValid && isPasswordValid;
    }
}