package com.annamalai.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;

    private EditText name, punchspeed, punchpower, kickspeed, kickpower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btn);
        btnSave.setOnClickListener(MainActivity.this);

        name = findViewById(R.id.edtName);
        punchpower = findViewById(R.id.edtPunchPower);
        punchspeed = findViewById(R.id.edtPunchSpeed);
        kickpower = findViewById(R.id.edtKickPower);
        kickspeed = findViewById(R.id.edtKickSpeed);

    }


    @Override
    public void onClick(View v) {

        try {
            final ParseObject kickBoxer = new ParseObject("Kickboxer");

            kickBoxer.put("name", name.getText().toString());
            kickBoxer.put("punchSpeed", Integer.parseInt(punchspeed.getText().toString()));
            kickBoxer.put("punchPower", Integer.parseInt(punchpower.getText().toString()));
            kickBoxer.put("kickSpeed", Integer.parseInt(kickspeed.getText().toString()));
            kickBoxer.put("kickPower", Integer.parseInt(kickpower.getText().toString()));

            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                    if (e == null) {
                        FancyToast.makeText(MainActivity.this, kickBoxer.get("name") + " is saved to the server", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                    } else {
                        FancyToast.makeText(MainActivity.this, e.getMessage() + " ", FancyToast.LENGTH_LONG, FancyToast.WARNING, true).show();

                    }
                }

            });
        } catch (Exception e){
            FancyToast.makeText(MainActivity.this, e.getMessage() + " ", FancyToast.LENGTH_LONG, FancyToast.WARNING, true).show();
        }
    }
}