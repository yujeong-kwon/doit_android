package org.techtown.doitmisson_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);



        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                moveImageDown();
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                moveImageUp();
            }
        });
        moveImageUp();
    }

    private void moveImageDown(){
        imageView1.setImageResource(R.drawable.test1);
        imageView2.setImageResource(0);

        imageView1.invalidate();
        imageView2.invalidate();
    }

    private void moveImageUp(){
        imageView1.setImageResource(0);
        imageView2.setImageResource(R.drawable.test1);

        imageView1.invalidate();
        imageView2.invalidate();
    }

}