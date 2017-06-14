package com.example.etbel.tentamen_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public class LoginActivity extends AppCompatActivity {

        private EditText editTextUsername;
        private EditText editTextPassword;
        private TextView txtLoginErrorMsg;
        private Button btnLogin;

        private String mUsername;
        private String mPassword;

        public final String TAG = this.getClass().getSimpleName();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            editTextUsername = (EditText) findViewById(R.id.edittextUsername);
            editTextPassword = (EditText) findViewById(R.id.edittextPassword);
            txtLoginErrorMsg = (TextView) findViewById(R.id.txtLoginErrorMessage);
            btnLogin = (Button) findViewById(R.id.btnLogin);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mUsername = editTextUsername.getText().toString();
                    mPassword = editTextPassword.getText().toString();
                    txtLoginErrorMsg.setText("");

                    // TODO Checken of username en password niet leeg zijn

                    handleLogin(mUsername, mPassword);
                }
            });
        }

        private void handleLogin(String username, String password) {
            //
            // Maak een JSON object met username en password. Dit object sturen we mee
            // als request body (zoals je ook met Postman hebt gedaan)
            //
            String body = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
            Log.i(TAG, "handleLogin - body = " + body);
        }
    }
}