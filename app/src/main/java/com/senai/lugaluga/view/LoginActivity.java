package com.senai.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.senai.lugaluga.R;

public class LoginActivity extends AppCompatActivity {
    private Button buttonLogin;

    private TextInputLayout inputEmail, inputSenha;

    private TextView fazerCadastro;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.outlinedTextField);
        inputSenha = findViewById(R.id.outlinedTextField2);
        buttonLogin = findViewById(R.id.btn);
        fazerCadastro = findViewById(R.id.fazercadastro);


        Intent intent = new Intent(this, MainActivity2.class);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validaEmailSenha()) {
                    startActivity(intent);
                }
            }
        });

        Intent intentCadastro = new Intent(this,cadastro_usuario.class);

        fazerCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCadastro);
            }
        });

}

    public boolean validaEmailSenha() {
        if (inputEmail.getEditText() != null
                && inputEmail.getEditText().getText().toString().equals("")) {
            inputEmail.setError("Informe o email");
            return false;
        }
        if(inputSenha.getEditText() != null
                && inputSenha.getEditText().getText().toString().equals("")){
            inputSenha.setError("Informe a senha");
            return true;
        }
        return true;

    }
}

