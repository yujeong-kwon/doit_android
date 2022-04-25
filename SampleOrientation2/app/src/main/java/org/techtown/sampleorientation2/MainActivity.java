package org.techtown.sampleorientation2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        //가로 방향으로 전환할 때 처리
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            showToast("방향: ORIENTATION_LANDSCAPE");
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            //세로 방향으로 전환 할 때 처리
            showToast("방향: ORIENTATION_PORTRAIT");
        }
    }

    private void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}