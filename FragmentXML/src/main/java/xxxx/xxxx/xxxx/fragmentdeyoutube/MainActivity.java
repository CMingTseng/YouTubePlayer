package xxxx.xxxx.xxxx.fragmentdeyoutube;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerFragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private YouTubePlayerFragment playerFragment;
    private static final String API_KEY = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String VIDEO_ID = "EGy39OMyHzw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtubePF);
        playerFragment.initialize(API_KEY, new OnInitializedListener() {
            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored){
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.loadVideo(VIDEO_ID);
                    player.play();
                }
            }

            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
                String errorMessage = error.toString();
                Toast.makeText(getBaseContext(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtubePF);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}


