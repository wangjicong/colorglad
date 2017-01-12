package wjc.colorglad.libray;

import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class ColorGlad {
    private static final String TAG = ColorGlad.class.getName();
    private List<Integer> mColorList=new ArrayList<>();
    private int mCount;
    private float mStage;


    public ColorGlad(List<Integer> colorList){
        this.mColorList = colorList;
        this.mCount = mColorList.size();
        this.mStage = 100/(mCount-1);
    }

    public int getColorGlad(float percent){
        int out_color = 0;
        int bengin_color = getBenginColor(percent);
        int end_color = getEndColor(percent);
        float two_color_percent = getPercent(bengin_color,end_color,percent);
        Log.d(TAG,"two_color_percent = "+two_color_percent);
        int r = (int) (Color.red(mColorList.get(end_color))*two_color_percent + Color.red(mColorList.get(bengin_color))*(1.0f-two_color_percent));
        int g = (int) (Color.green(mColorList.get(end_color))*two_color_percent + Color.green(mColorList.get(bengin_color))*(1.0f -two_color_percent));
        int b = (int) (Color.blue(mColorList.get(end_color))*two_color_percent + Color.blue(mColorList.get(bengin_color))*(1.0f - two_color_percent));
        out_color = Color.rgb(r,g,b);
        return out_color;
    }

    private int getBenginColor(float percent){
        return (int) (percent/mStage);
    }
    private int getEndColor(float percent){
        return (int) ((percent+mStage-1)/mStage);
    }

    private float getPercent(int bengin,int end,float percent){
        return (percent*(mCount-1)-bengin*100)/100;
    }
}
