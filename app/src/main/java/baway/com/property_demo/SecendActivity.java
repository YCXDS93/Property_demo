package baway.com.property_demo;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SecendActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_secend);
        imageView = (ImageView) findViewById(R.id.imag);

    }

    public void combine1(View v) {
        //设置属性动画的数据及动画效果
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.2f);
        PropertyValuesHolder scalex = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.3f);
        PropertyValuesHolder scaley = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.3f);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, alpha, scalex, scaley);
        animator.setDuration(10000);
        animator.start();
    }

    public void combine2(View v) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView,"alpha", 1.0f, 0);
        //设置新监听
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //获取当前的值
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                imageView.setScaleX(animatedValue);
                imageView.setScaleY(animatedValue);
                imageView.setAlpha(animatedValue);
                imageView.setRotation(animatedValue);
            }
        });
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }
}
