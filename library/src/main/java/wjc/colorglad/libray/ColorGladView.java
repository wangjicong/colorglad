package wjc.colorglad.libray;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class ColorGladView extends View {
    private static final String TAG = ColorGladView.class.getName();
    private static final int MAX_GLAD = 200;
    private ColorGlad mColorGlad;

    public ColorGladView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ColorGladView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorGladView(Context context) {
        super(context);
    }

    public void setColors(List<Integer> colors){
        mColorGlad = new ColorGlad(colors);
        this.invalidate();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (null == mColorGlad){
            return;
        }
        float stage = (float)(canvas.getWidth())/MAX_GLAD;

        Paint paint = new Paint();
        RectF rectF = new RectF();
        rectF.top=0;
        rectF.bottom=canvas.getHeight();

        for (int i =0;i<MAX_GLAD;i++){
            paint.setColor(mColorGlad.getColorGlad(i*100.0F/MAX_GLAD));
            rectF.left=i*stage;

            rectF.right=rectF.left+stage;
            canvas.drawRect(rectF,paint);
        }
    }
}
