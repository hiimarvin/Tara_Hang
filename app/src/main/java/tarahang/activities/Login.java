package tarahang.activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView usernameTV, passwordTV;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        usernameTV = (TextView) findViewById(R.id.usernameTV);
        passwordTV = (TextView) findViewById(R.id.passwordTV);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameTV.getText().toString();
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor spEditor = sp.edit();

                spEditor.putString(MainApp.SP_KEY_USERNAME, username);
                spEditor.commit();
                finish();
            }
        });

    }
}
