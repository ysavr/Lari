package com.example.savr.lari;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.savr.lari.Login.Login;
import com.example.savr.lari.Tab.MyAdapter;
import com.example.savr.lari.Login.SharedPreferenManager;
import com.example.savr.lari.Tab.SlidingTabLayout;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;

public class MainActivity extends AppCompatActivity {
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private Drawer.Result navigationDrawerLeft;
    private AccountHeader.Result headerNavigationLeft; //untuk menambahkan akun header

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!SharedPreferenManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this,Login.class));
        }

        //pemanggilan xml toolbar ke java
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.vp_tabs);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),this));

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.st1_tabs);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorsliding));
        slidingTabLayout.setCustomTabView(R.layout.tab_view,R.id.tv_tab);
        slidingTabLayout.setViewPager(viewPager);

        //=======================================================================================//
        //navigationDrawer//

        headerNavigationLeft = new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.color.colorPrimary)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mlayu").withEmail("Mlayu@mail.com").withIcon(getResources().getDrawable(R.drawable.user))
                )
                .build();
        navigationDrawerLeft = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)//didepan/luar toolbar
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigationLeft)
                .withSelectedItem(0)
                .build();

        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Activity").withIcon(getResources().getDrawable(R.drawable.ic_directions_run_black_36dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("History").withIcon(getResources().getDrawable(R.drawable.ic_list_black_36dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Statistic").withIcon(getResources().getDrawable(R.drawable.statistic)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Setting").withIcon(getResources().getDrawable(R.drawable.setting)));
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
}
