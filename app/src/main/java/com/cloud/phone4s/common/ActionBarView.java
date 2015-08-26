package com.cloud.phone4s.common;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cloud.phone4s.R;


/**
 * Created by 贾永斌 on 15/4/14.
 * 共用的actionBar
 */
public class ActionBarView extends RelativeLayout {

    public RelativeLayout ll_head_leftmenu;
    public RelativeLayout ll_head_rightmenu;
    public ImageView iv_head_left;
    public ImageView iv_head_right;
    public TextView tv_head_title;
    public TextView tv_head_right;
    public RelativeLayout actionBarRoot;
    public LinearLayout lay_right_1;
    public LinearLayout lay_right_2;
    public ImageView img_collection;

    public ActionBarView(Context context) {
        super(context);
        init();
    }

    public ActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ActionBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View v = inflater.inflate(R.layout.communal_head, this);
        actionBarRoot = (RelativeLayout) v.findViewById(R.id.actionBarRoot);
        ll_head_leftmenu = (RelativeLayout) v.findViewById(R.id.ll_head_leftmenu);
        ll_head_rightmenu = (RelativeLayout) v.findViewById(R.id.ll_head_rightmenu);
        iv_head_left = (ImageView) v.findViewById(R.id.iv_head_left);
        iv_head_right = (ImageView) v.findViewById(R.id.iv_head_right);
        tv_head_title = (TextView) v.findViewById(R.id.tv_head_title);
        tv_head_right = (TextView) v.findViewById(R.id.tv_head_right);
        img_collection = (ImageView) v.findViewById(R.id.img_collection);
        ll_head_leftmenu.setVisibility(View.GONE);
        ll_head_rightmenu.setVisibility(View.GONE);
        iv_head_right.setVisibility(View.GONE);
        tv_head_right.setVisibility(View.GONE);
        lay_right_1 = (LinearLayout) v.findViewById(R.id.lay_collection);
        lay_right_2 = (LinearLayout) v.findViewById(R.id.lay_share);
        ll_head_leftmenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity) getContext();
                activity.finish();
            }
        });
    }

    /**
     * 设置标题内容
     *
     * @param text 需要显示的头部内容
     */
    public void setTitleText(String text) {
        this.tv_head_title.setText(text);
    }

    /**
     * 设置右边按钮图片，显示ImageView隐藏TextView
     *
     * @param res 传入图片资源ID
     */
    public void setRightBtnBackground(int res) {
        this.iv_head_right.setBackgroundResource(res);
        iv_head_right.setVisibility(VISIBLE);
        tv_head_right.setVisibility(View.GONE);
    }

    /**
     * 设置右边按钮文字，显示TextView隐藏ImageView
     *
     * @param text
     */
    public void setRightBtnText(String text) {
        tv_head_right.setText(text);
        tv_head_right.setVisibility(VISIBLE);
        iv_head_right.setVisibility(View.GONE);
    }

    /**
     * 获得左边按钮点击区域
     *
     * @return 获得左边按钮点击控件
     */
    public View getLeftMenu() {
        return ll_head_leftmenu;
    }

    /**
     * 获得右边按钮点击区域
     *
     * @return 获得右边按钮点击控件
     */
    public View getRightMenu() {
        return ll_head_rightmenu;
    }

    public LinearLayout getLay_right_1() {
        return lay_right_1;
    }

    public void setLay_right_1(LinearLayout lay_right_1) {
        this.lay_right_1 = lay_right_1;
    }

    public LinearLayout getLay_right_2() {
        return lay_right_2;
    }

    public void setLay_right_2(LinearLayout lay_right_2) {
        this.lay_right_2 = lay_right_2;
    }
}