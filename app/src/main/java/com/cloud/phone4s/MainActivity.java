package com.cloud.phone4s;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cloud.phone4s.adapter.FragAdapter;
import com.cloud.phone4s.common.IndexViewPager;
import com.cloud.phone4s.fragment.CartPageFrag;
import com.cloud.phone4s.fragment.HomePageFrag;
import com.cloud.phone4s.fragment.ShopPageFrag;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<Fragment> fragments;
    private IndexViewPager vp_viewpage;
    private FragAdapter fragAdapter;
    private LinearLayout ll_homepage;
    private LinearLayout ll_near;
    private LinearLayout ll_personal;
    private ImageView iv_homepage;
    private ImageView iv_near;
    private ImageView iv_personal;
    private TextView tv_homepage;
    private TextView tv_near;
    private TextView tv_personal;

    HomePageFrag homePageFrag;
    ShopPageFrag shopPageFrag;
    CartPageFrag cartPageFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        //加载view
        vp_viewpage = (IndexViewPager) findViewById(R.id.vp_viewpage);
        vp_viewpage.setOffscreenPageLimit(3);
        ll_homepage = (LinearLayout) findViewById(R.id.ll_homepage);
        ll_homepage.setOnClickListener(this);
        ll_near = (LinearLayout) findViewById(R.id.ll_near);
        ll_near.setOnClickListener(this);
        ll_personal = (LinearLayout) findViewById(R.id.ll_personal);
        ll_personal.setOnClickListener(this);
        iv_homepage = (ImageView) findViewById(R.id.iv_homepage);
        iv_near = (ImageView) findViewById(R.id.iv_near);
        iv_personal = (ImageView) findViewById(R.id.iv_personal);
        tv_homepage = (TextView) findViewById(R.id.tv_homepage);
        tv_near = (TextView) findViewById(R.id.tv_near);
        tv_personal = (TextView) findViewById(R.id.tv_personal);
        //初始化viewpage
        initViewPage();
    }

    public void initViewPage() {
        fragments = new ArrayList<>();
        homePageFrag = new HomePageFrag();
        shopPageFrag = new ShopPageFrag();
        cartPageFrag = new CartPageFrag();

        fragments.add(homePageFrag);
        fragments.add(shopPageFrag);
        fragments.add(cartPageFrag);

        FragmentManager manager = getSupportFragmentManager();
        fragAdapter = new FragAdapter(manager, fragments);
        vp_viewpage.setAdapter(fragAdapter);
        vp_viewpage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                setCheck(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    /**
     * 改变tab颜色方法
     * status：当前选中view
     */
    private void setCheck(int status) {
        iv_homepage.setBackgroundResource(R.drawable.bottom_menu_tuan);
        iv_near.setBackgroundResource(R.drawable.bottom_menu_fujin);
        iv_personal.setBackgroundResource(R.drawable.bottom_menu_mine);

        tv_homepage.setTextColor(getResources().getColor(R.color.t757676));
        tv_near.setTextColor(getResources().getColor(R.color.t757676));
        tv_personal.setTextColor(getResources().getColor(R.color.t757676));
        switch (status) {
            case 0:
                iv_homepage.setBackgroundResource(R.drawable.bottom_menu_tuan1);
                tv_homepage.setTextColor(getResources().getColor(R.color.t4baaaa));
                break;
            case 1:
                iv_near.setBackgroundResource(R.drawable.bottom_menu_fujin1);
                tv_near.setTextColor(getResources().getColor(R.color.t4baaaa));
                break;
            case 2:
                iv_personal.setBackgroundResource(R.drawable.bottom_menu_mine1);
                tv_personal.setTextColor(getResources().getColor(R.color.t4baaaa));
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_homepage:
                //首页
                setCheck(0);
                vp_viewpage.setCurrentItem(0);
                break;
            case R.id.ll_near:
                //附近
                setCheck(1);
                vp_viewpage.setCurrentItem(1);
                break;
            case R.id.ll_personal:
                //更多
                setCheck(2);
                vp_viewpage.setCurrentItem(2);
                break;
        }
    }
}
