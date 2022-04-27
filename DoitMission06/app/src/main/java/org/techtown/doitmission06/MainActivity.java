package org.techtown.doitmission06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        EditText editText = findViewById(R.id.EditText);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //최초 탭하여 드래그 시작 시 발생
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressBar.setProgress(i);
                //문자열로 변환
                editText.setText(String.valueOf(i));
            }

            @Override
            //드래그 중 발생
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            //드래그 멈추면 발생
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}