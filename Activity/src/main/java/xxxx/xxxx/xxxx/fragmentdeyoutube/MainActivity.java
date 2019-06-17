package xxxx.xxxx.xxxx.fragmentdeyoutube;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,YouTubePlayer.OnFullscreenListener {
    private YouTubePlayerView b;
    private static final String API_KEY = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static String VIDEO_ID = "EGy39OMyHzw";
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if (savedInstanceState==null){
//            savedInstanceState = new Bundle();
//        }
//
//        savedInstanceState.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", var2);
          super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        com.google.android.youtube.player.YouTubePlayerView b =findViewById(R.id.main);
        b.initialize(API_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored){
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
            player.loadVideo(VIDEO_ID);
            player.play();
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
//            String errorMessage = String.format(getString(R.string.error_player), errorReason.toString());
//            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return b;
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFullscreen(boolean b) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(API_KEY, this);
        }
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


