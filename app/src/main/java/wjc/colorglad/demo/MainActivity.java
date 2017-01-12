
package wjc.colorglad.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

import wjc.colorglad.libray.ColorGlad;
import wjc.colorglad.libray.ColorGladView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private static final String TAG = MainActivity.class.getName();
    private View mView;
    private SeekBar mSeekbar;
    private ColorGladView mColorGladView;

    private ColorGlad mColorGlad;
    private List<Integer> mColor = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = (View)findViewById(R.id.colorglad);
        mSeekbar = (SeekBar)findViewById(R.id.seekbar);
        mSeekbar.setOnSeekBarChangeListener(this);
        mColorGladView = (ColorGladView)findViewById(R.id.colorview);

        mColor.add(Color.RED);
        mColor.add(Color.GREEN);
        mColor.add(Color.BLUE);

        mColorGlad = new ColorGlad(mColor);
        mColorGladView.setColors(mColor);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        mView.setBackgroundColor(mColorGlad.getColorGlad(i));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
