package com.exam.cineoo.view.recycleview;

import android.view.MotionEvent;
import android.view.View;

public interface OnClickRecycleView{

    void onClick(View view, int position, boolean isLongClick, MotionEvent motionEvent);
//    void onLongClick (View view, int position, boolean isLongClick, MotionEvent motionEvent);

}
