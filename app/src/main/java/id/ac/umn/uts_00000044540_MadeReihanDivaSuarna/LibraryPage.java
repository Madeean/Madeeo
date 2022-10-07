package id.ac.umn.uts_00000044540_MadeReihanDivaSuarna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class LibraryPage extends AppCompatActivity {

    Toolbar my_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_page);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Toast.makeText(this, "Welcome " + name, Toast.LENGTH_SHORT).show();

        my_toolbar = findViewById(R.id.my_toolbar);
        my_toolbar.setTitle("Hello, " + name);
        setSupportActionBar(my_toolbar);





    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.profil:
                goToProfil();
                return true;
            case R.id.kembali:
                goToProfil();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToProfil() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}