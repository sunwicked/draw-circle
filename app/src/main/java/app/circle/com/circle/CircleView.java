package app.circle.com.circle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by admin on 10/09/17.
 */

public class CircleView extends View {

    public static final int MARGIN = 12;
    Paint paint;
    private int cX = 50;
    private int cY = 50;
    private int radius = 20;
    private int colorAccent;
    private Paint paintText;
    String text = "Say hello to my little circle!";

    public CircleView(Context context) {
        super(context);
        init(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        paintText = new Paint();
        paintText.setStyle(Paint.Style.FILL);
        paintText.setColor(ContextCompat.getColor(context, R.color.colorAccent));
        paintText.setAntiAlias(true);
        paintText.setTextAlign(Paint.Align.CENTER);
        paintText.setTextSize(40);


        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CircleView,
                0, 0);

        try {
            setRadius(a.getInteger(R.styleable.CircleView_radius, 20));
            setColorAccent(a.getColor(R.styleable.CircleView_color, ContextCompat.getColor(context, R.color.colorAccent)));
        } finally {
            a.recycle();
        }
        paint.setColor(getCircleColor());
    }


    public void setColorAccent(int colorAccent) {
        this.colorAccent = colorAccent;
    }

    private int getCircleColor() {

        return this.colorAccent;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, getRadius(), paint);
        // Calculating the no of characters we can get in the view
        int numOfChars = paintText.breakText(text, true, getRadius() * 2 - MARGIN, null);
        text = text.substring(0, numOfChars) + "..";

        canvas.drawText(text, canvas.getWidth() / 2, canvas.getHeight() / 2, paintText);

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
