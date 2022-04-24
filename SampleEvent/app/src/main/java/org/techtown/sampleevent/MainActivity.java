package org.techtown.sampleevent;

import static java.sql.DriverManager.println;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    //제스처 디텍터 객체 선언
    GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        View view = findViewById(R.id.view);
        //new로 객체를 생성해서 전달하여 리스너를 등록
        view.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent motionEvent){
                int action = motionEvent.getAction();

                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if(action == MotionEvent.ACTION_DOWN){
                    println("손가락 눌림: " + curX + ", " + curY);
                }else if(action == MotionEvent.ACTION_MOVE){
                    println("손가락 움직임: " + curX + ", " + curY);
                }else if(action == MotionEvent.ACTION_UP){
                    println("손가락 뗌: " + curX + ", " + curY);
                }

                return true;
            }
        });
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                println("onDown() 호출됨. ");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                println("onShowPress() 호출됨. ");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                println("onSingleTapUp() 호출됨. ");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onScroll() 호출됨: " + v + ", " + v1);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                println("onLongPress() 호출됨. ");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onFling() 호출됨: " + v + ", " + v1);
                return true;
            }
        });
        View view2 = findViewById(R.id.view2);
        //뷰를 터치했을 때 발생하는 터치 이벤트를 제스쳐 디덱터로 전달
        //-> 제스처 디텍터가 터치 이벤출를 처리한 후 제스쳐디텍터 객체에 정의된 메서드를 호출
        view2.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent motionEvent){
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }
    public void println(String data){
        textView.append(data + "\n");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK){
            Toast.makeText(this, "시스템 [BACK] 버튼이 눌렸습니다. ", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}