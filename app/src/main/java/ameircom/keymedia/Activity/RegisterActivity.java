package ameircom.keymedia.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ameircom.keymedia.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
Button b1 ;
    Button b2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b1 =(Button) findViewById(R.id.angry_btn3);
        b1.setOnClickListener(this);
        b2 =(Button) findViewById(R.id.Buttin1);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == b1 ) {
            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(i);
        }
        if (view == b2 ) {
            Intent r = new Intent(RegisterActivity.this, Main2Activity.class);
            startActivity(r);
}
        }
        }
//galaleslam10@yahoo.com