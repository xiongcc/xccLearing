package com.example.xiong.xionglearing.xcc.ancitvity;

import android.view.View;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

/**
 * Created by zhoujunzhou on 2016/3/15.
 */
public class AnimatorHelper {


    public static final int MAIN_TAG_DURATION = 1000;

    public static ObjectAnimator getMainTagAnim(final View view, final IMainTagAnimEndCallBack animEndCallBack) {
        ObjectAnimator alphAnima = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        alphAnima.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                view.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animEndCallBack.doAnimEnd();
            }
        });
        alphAnima.setDuration(MAIN_TAG_DURATION);
        return alphAnima;
    }


    public static void playTranXAnimSet(final View view, int startX, int endX) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "translationX", startX, endX);
        anim2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                view.setVisibility(View.VISIBLE);
            }
        });

        set.setDuration(500);
        set.play(anim1).with(anim2).with(scaleX).with(scaleY);
        set.start();
//        return anim1;
    }


    public interface IMainTagAnimEndCallBack {
        void doAnimEnd();
    }

}
