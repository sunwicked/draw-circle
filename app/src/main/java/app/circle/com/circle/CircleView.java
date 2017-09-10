package app.circle.com.circle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by admin on 10/09/17.
 */

public class CircleView extends View {

    Paint paint;
    private int cX=20;
    private int cY=20;
Bitmap dragon = null;
    public CircleView(Context context) {
        super(context);
        init(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, R.color.colorAccent));
        paint.setStyle(Paint.Style.FILL);
        dragon =  BitmapFactory.decodeResource(getResources(), R.drawable.dragon );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
// Icon made by https://www.flaticon.com/authors/freepik from www.flaticon.com
      //  canvas.drawCircle(cX, cY, 20, paint);
        canvas.drawBitmap(dragon,cX,cY,null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


}
