颜色渐变
===
##效果演示
===
![](https://github.com/wangjicong/colorglad/blob/master/show/02.png)
![](https://github.com/wangjicong/colorglad/blob/master/show/03.png)
![](https://github.com/wangjicong/colorglad/blob/master/show/show.gif)


###如何使用
```java
    <View
        android:id="@+id/colorglad"
        android:layout_below="@+id/colorview"
        android:layout_marginTop="50dp"
        android:layout_width="match_parent"
        android:layout_height="40dp" />

```

```java
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
        mView.setBackgroundColor(mColorGlad.getColorGlad(0));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        mView.setBackgroundColor(mColorGlad.getColorGlad(i));
    }
```
