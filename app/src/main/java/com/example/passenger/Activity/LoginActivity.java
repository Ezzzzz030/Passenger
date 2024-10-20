package com.example.passenger.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.passenger.Model.AppConfig.AppConfig;
import com.example.passenger.R;
import com.example.passenger.Utility.SettingsFragment;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    EditText editText_email;
    EditText editText_password;
    Button button_accedi;
    TextView textView_registrati;
    TextView textView_passwordDimenticata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        changeColorStatusBar();

        editText_email = this.findViewById(R.id.editText_email);
        editText_password = this.findViewById(R.id.editText_password);
        button_accedi = this.findViewById(R.id.button_accedi);
        textView_registrati = findViewById(R.id.textView_registrati);
        textView_passwordDimenticata = findViewById(R.id.textView_passwordDimenticata);

        button_accedi.setOnClickListener(this);
        textView_registrati.setOnClickListener(this);

        SpannableString spannableStringRegistrati = new SpannableString("Registrati");
        SpannableString spannableStringPasswordDimenticata = new SpannableString("Password dimenticata");

        spannableStringRegistrati.setSpan(this, 0, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringRegistrati.setSpan(new UnderlineSpan(), 0, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringRegistrati.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableStringPasswordDimenticata.setSpan(this, 0, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringPasswordDimenticata.setSpan(new UnderlineSpan(), 0, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringPasswordDimenticata.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView_registrati.setText(spannableStringRegistrati);
        textView_registrati.setMovementMethod(LinkMovementMethod.getInstance());

        textView_passwordDimenticata.setText(spannableStringPasswordDimenticata);
        textView_passwordDimenticata.setMovementMethod(LinkMovementMethod.getInstance());

        AppConfig.Load(this);

        if(!AppConfig.Email.isEmpty())
        {
            editText_email.setText(AppConfig.Email);
        }

        if(!AppConfig.Password.isEmpty())
        {
            editText_password.setText(AppConfig.Password);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_accedi:
                if(!String.valueOf(editText_email.getText()).isEmpty())
                {
                    AppConfig.Email = String.valueOf(editText_email.getText());
                }

                if(!String.valueOf(editText_password.getText()).isEmpty())
                {
                    AppConfig.Password = String.valueOf(editText_password.getText());
                }

                AppConfig.Save(this);
                break;
            default:
                break;
        }
    }

    private void changeColorStatusBar()
    {
        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));
    }
}