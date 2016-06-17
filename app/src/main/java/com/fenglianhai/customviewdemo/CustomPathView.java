package com.fenglianhai.customviewdemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by One Day on 2016/6/17.
 */

public class CustomPathView extends View {

    private Paint paint;

    public CustomPathView(Context context) {
        super(context);
    }

    public CustomPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setViewPaint();
        /*//创建Path
        Path path = new Path();
        //设置Path的起点位置
        path.moveTo(200, 200);
        //path路径连接至某点
        path.lineTo(100, 400);
        path.lineTo(300, 400);
        //设置path的起点与终点相连
        path.close();
        //绘制path
        canvas.drawPath(path, paint);

        //重新设置path起点
        path.moveTo(100, 800);
        path.lineTo(200, 500);
        path.lineTo(300, 800);
        path.lineTo(400, 500);
        path.lineTo(500, 800);
        path.close();
        //绘制M
        canvas.drawPath(path, paint);*/

        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.addCircle(150, 150, 100, Path.Direction.CW);

        Path path1 = new Path();
        path.addCircle(300, 150, 100, Path.Direction.CW);

        path.op(path1, Path.Op.UNION);
        canvas.drawPath(path, paint);

        path.reset();
        path1.reset();
        path.addCircle(150, 400, 100, Path.Direction.CW);
        path1.addCircle(300, 400, 100, Path.Direction.CW);
        path.op(path1, Path.Op.REVERSE_DIFFERENCE);
        canvas.drawPath(path, paint);

        path.reset();
        path1.reset();
        path.addCircle(150, 650, 100, Path.Direction.CW);
        path1.addCircle(300, 650, 100, Path.Direction.CW);
        path.op(path1, Path.Op.INTERSECT);
        canvas.drawPath(path, paint);

        path.reset();
        path1.reset();
        path.addCircle(150, 900, 100, Path.Direction.CW);
        path1.addCircle(300, 900, 100, Path.Direction.CW);
        path.op(path1, Path.Op.DIFFERENCE);
        canvas.drawPath(path, paint);

        path.reset();
        path1.reset();
        path.addCircle(150, 1150, 100, Path.Direction.CW);
        path1.addCircle(300, 1150, 100, Path.Direction.CW);
        path.op(path1, Path.Op.XOR);
        canvas.drawPath(path, paint);
    }

    private void setViewPaint() {
        paint = new Paint();

        //去锯齿
        paint.setAntiAlias(true);

        //设置画笔颜色
        paint.setColor(getResources().getColor(android.R.color.holo_orange_light));

        //为了更好查看Path效果
        //设置绘制风格为空心
        paint.setStyle(Paint.Style.STROKE);

        //设置空心边框的宽度
        paint.setStrokeWidth(5);
    }
}
