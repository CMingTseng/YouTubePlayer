package xxxx.xxxx.xxxx.fragmentdeyoutube;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // フラグメント起動 （v4の作法で）
        YoutubeFragment fragment = new YoutubeFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction()
                .replace(R.id.main, fragment)
                .addToBackStack(null)
                .commit();
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


