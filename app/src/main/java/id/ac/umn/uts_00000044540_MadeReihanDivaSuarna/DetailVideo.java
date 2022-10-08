package id.ac.umn.uts_00000044540_MadeReihanDivaSuarna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class DetailVideo extends AppCompatActivity {

    Toolbar my_toolbar;
    VideoView videoView;
    public String name;
    public String videoName;
    TextView tvJudul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_video);
        Intent intent = getIntent();
        tvJudul = findViewById(R.id.tvJudul);

        name = intent.getStringExtra("name");
        videoName = intent.getStringExtra("nameVideo");

        tvJudul.setText(videoName);

        my_toolbar = findViewById(R.id.my_toolbar);
        my_toolbar.setTitle("Detail Video");
        my_toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(my_toolbar);

        my_toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_back_putih));

        my_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(DetailVideo.this, LibraryPage.class);
                inten.putExtra("name", name);
                startActivity(inten);
            }
        });

        MediaController mediaController = new MediaController(this);

        videoView = findViewById(R.id.videoView);
        Uri uri = Uri.parse("https://file-examples.com/storage/feb2e515cc6339d7ba1ffcd/2017/04/file_example_MP4_640_3MG.mp4");
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Video Error", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        videoView.start();

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
                GotoHome();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToProfil() {
        Intent intent = new Intent(getApplicationContext(), ProfilePage.class);
        startActivity(intent);
    }

    private void GotoHome() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}