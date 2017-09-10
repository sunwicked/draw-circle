package app.circle.com.circle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    CircleView circle;
    float dX, dY;
    private int motionEventX;
    private int motionEventY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.rl_par);
        circle = (CircleView) findViewById(R.id.circle);
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                motionEventX = (int) motionEvent.getX();
                motionEventY = (int) motionEvent.getY();
                switch (motionEvent.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        moveCircle(motionEventX, motionEventY);
                        break;
                    case MotionEvent.ACTION_MOVE:

                        moveCircle(motionEventX, motionEventY);
                        break;
                    case MotionEvent.ACTION_UP:

                }
                return true;
            }
        });
    }

    private void moveCircle(int x, int y) {

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
        params.leftMargin = x;
        params.topMargin = y;
        circle.setLayoutParams(params);
    }

    private void addCircle(MotionEvent motionEvent) {

        CircleView circleView = new CircleView(this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
        params.leftMargin = (int) motionEvent.getX();
        params.topMargin = (int) motionEvent.getY();

        relativeLayout.addView(circleView, params);
    }


}
