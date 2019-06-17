package xxxx.xxxx.xxxx.fragmentdeyoutube;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class YoutubeFragment extends Fragment {
    // API キー
    private static final String API_KEY = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    // YouTubeのビデオID
    private static String VIDEO_ID = "EGy39OMyHzw";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.you_tube_api, container, false);

        // YouTubeフラグメントインスタンスを取得
        YouTubePlayerFragment youTubePlayerFragment = (YouTubePlayerFragment) getChildFragmentManager().findFragmentById(R.id.youtube_layout);


        // YouTubeフラグメントのプレーヤーを初期化する
        youTubePlayerFragment.initialize(API_KEY, new OnInitializedListener() {

            // YouTubeプレーヤーの初期化成功
            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.loadVideo(VIDEO_ID);
                    player.play();
                }
            }

            // YouTubeプレーヤーの初期化失敗
            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });

        return rootView;
    }
}