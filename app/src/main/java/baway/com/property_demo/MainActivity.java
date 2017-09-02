package baway.com.property_demo;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        findViewById(R.id.btn_alpha).setOnClickListener(this);
        findViewById(R.id.btn_trans).setOnClickListener(this);
        findViewById(R.id.btn_scale).setOnClickListener(this);
        findViewById(R.id.btn_rotate).setOnClickListener(this);
        findViewById(R.id.next).setOnClickListener(this);
        Logger.d("logger test");
        Logger.e("logger  test");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha:
                ObjectAnimator animator=ObjectAnimator.ofFloat(imageView,"alpha",1.0f,0.5f,0.3f);
                animator.setDuration(3000);
                animator.start();
                break;
            case R.id.btn_rotate:
                ObjectAnimator object_rotate=ObjectAnimator.ofFloat(
                        imageView,"rotation",0,180,360);
                object_rotate.setDuration(3000);
                object_rotate.start();
                break;
            case R.id.btn_scale:
                ObjectAnimator object_scale=ObjectAnimator.ofFloat(imageView,"scaleX",1,0);
                object_scale.setDuration(3000);
                object_scale.end();
                object_scale.start();
                break;
            case R.id.btn_trans:
                ObjectAnimator object_trans=ObjectAnimator.ofFloat(imageView,"translationX",0,200);
                object_trans.setDuration(3000);
                object_trans.start();
                break;
            case R.id.next:
                startActivity(new Intent(MainActivity.this,SecendActivity.class));
                break;
        }
    }
}
