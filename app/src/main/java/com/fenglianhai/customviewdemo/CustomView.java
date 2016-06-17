package com.fenglianhai.customviewdemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fengl on 2016/6/16.
 */
public class CustomView extends View{
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //drawCircle(canvas);
        //drawRect(canvas);
        //drawRoundRect(canvas);
        //drawOval(canvas);
        //drawArc(canvas);
        drawText(canvas);
    }

    protected void drawCircle(Canvas canvas){
        //创建画笔
        Paint paint = new Paint();

        //抗锯齿
        paint.setAntiAlias(true);

        //设置颜色
        paint.setColor(getResources().getColor(android.R.color.holo_blue_light));

        //绘制实心圆
        canvas.drawCircle(200, 200, 100, paint);

        //设置空心Style
        paint.setStyle(Paint.Style.STROKE);

        //设置边框大小
        paint.setStrokeWidth(20);

        //绘制空心圆
        canvas.drawCircle(200, 500, 100, paint);
    }

    protected void drawRect(Canvas canvas){
        //创建画笔
        Paint paint = new Paint();

        //抗锯齿
        paint.setAntiAlias(true);

        //设置颜色
        paint.setColor(getResources().getColor(android.R.color.holo_green_light));

        //绘制实心矩形
        canvas.drawRect(100, 100, 400, 300, paint);
        canvas.drawRect(new RectF(500, 100, 800, 300), paint);

        //设置空心Style
        paint.setStyle(Paint.Style.STROKE);

        //设置边框大小
        paint.setStrokeWidth(30);

        //绘制空心圆
        canvas.drawRect(100, 400, 400, 600, paint);
    }

    @TargetApi(21)
    protected void drawRoundRect(Canvas canvas){
        //创建画笔
        Paint paint = new Paint();

        //抗锯齿
        paint.setAntiAlias(true);

        //设置颜色
        paint.setColor(getResources().getColor(android.R.color.holo_orange_light));

        //绘制实心圆角矩形
        canvas.drawRoundRect(100, 100, 400, 300, 50, 50, paint);
        canvas.drawRoundRect(new RectF(500, 100, 800, 300), 50, 50, paint);

        //设置空心Style
        paint.setStyle(Paint.Style.STROKE);

        //设置边框大小
        paint.setStrokeWidth(30);

        //绘制空心圆
        canvas.drawRoundRect(100, 400, 400, 600, 30, 30, paint);
    }

    @TargetApi(21)
    protected void drawOval(Canvas canvas){
        //创建画笔
        Paint paint = new Paint();

        //抗锯齿
        paint.setAntiAlias(true);

        //设置颜色
        paint.setColor(getResources().getColor(android.R.color.holo_red_light));

        //绘制实心圆角矩形
        canvas.drawOval(100, 100, 500, 300, paint);
        canvas.drawOval(new RectF(600, 100, 1000, 300), paint);

        //设置空心Style
        paint.setStyle(Paint.Style.STROKE);

        //设置边框大小
        paint.setStrokeWidth(30);

        //绘制空心圆
        canvas.drawOval(100, 400, 500, 600, paint);
    }

    protected void drawArc(Canvas canvas){
        //创建画笔
        Paint paint = new Paint();

        //抗锯齿
        paint.setAntiAlias(true);

        //设置颜色
        paint.setColor(getResources().getColor(android.R.color.holo_blue_dark));

        //绘制不带圆心的弧线
        RectF rectF = new RectF(100, 100, 200, 200);
        canvas.drawArc(rectF, 0, 270, false, paint);

        //绘制带圆心的弧线
        rectF.set(100, 300, 200, 400);
        canvas.drawArc(rectF, 0, 270, true, paint);

        //设置空心Style
        paint.setStyle(Paint.Style.STROKE);

        //设置边框大小
        paint.setStrokeWidth(20);

        //绘制空心没有圆心的圆弧
        rectF.set(100, 500, 200, 600);
        canvas.drawArc(rectF, 0, 270, false, paint);
        //绘制空心有圆心的圆弧
        rectF.set(100, 700, 200, 800);
        canvas.drawArc(rectF, 0, 270, true, paint);
    }

    protected void drawText(Canvas canvas){
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(android.R.color.holo_green_dark));
        paint.setTextSize(100);
        canvas.drawText("ZZLJjHhoYy", 80, 150, paint);
    }
}
