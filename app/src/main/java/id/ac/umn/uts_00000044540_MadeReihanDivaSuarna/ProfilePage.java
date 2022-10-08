package id.ac.umn.uts_00000044540_MadeReihanDivaSuarna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

public class ProfilePage extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        toolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_back_hitam));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(ProfilePage.this, MainActivity.class);
                startActivity(inten);
            }
        });

    }

}