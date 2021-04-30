package com.example.paytusker;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paytusker.Fragments.DepositFragment;
import com.example.paytusker.Fragments.HomeFragment;
import com.example.paytusker.Fragments.MyActivityFragment;
import com.example.paytusker.Fragments.ProfileFragment;
import com.example.paytusker.Fragments.WalletsFragment;
import com.example.paytusker.Utils.App;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private AdvanceDrawerLayout advance_drawer;
    private ImageView img_side_menu, img_close;
    private TextView nav_dashboard,nav_profile,nav_activity,nav_wallet,nav_deposit,nav_payout,nav_sendmoney,nav_requestmoney,nav_exchange,nav_logout;
    private TextView heading;
    private ImageView back;
    private RelativeLayout background_topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ids();
        setup();
        performActions();
    }

    private void performActions() {
        advance_drawer.useCustomBehavior(Gravity.END);
        advance_drawer.setRadius(Gravity.END, 35);//set end container's corner radius (dimension)
        advance_drawer.setViewScale(Gravity.END, 0.9f);
        advance_drawer.setViewElevation(Gravity.END, 20);
    }

    private void setup() {
        heading.setText("Dashboard");
        img_side_menu.setOnClickListener(this);
        nav_profile.setOnClickListener(this);
        nav_payout.setOnClickListener(this);
        nav_sendmoney.setOnClickListener(this);
        nav_exchange.setOnClickListener(this);
        nav_wallet.setOnClickListener(this);
        nav_logout.setOnClickListener(this);
        nav_dashboard.setOnClickListener(this);
        nav_requestmoney.setOnClickListener(this);
        nav_deposit.setOnClickListener(this);
        nav_activity.setOnClickListener(this);
        img_close.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private void ids() {
        img_side_menu = findViewById(R.id.img_side_menu);
        advance_drawer =findViewById(R.id.advance_drawer);
        img_close =findViewById(R.id.img_close);
        heading = findViewById(R.id.heading);
        back = findViewById(R.id.back);
        nav_profile = findViewById(R.id.nav_profile);
        nav_sendmoney = findViewById(R.id.nav_sendmoney);
        nav_exchange = findViewById(R.id.nav_exchange);
        nav_payout = findViewById(R.id.nav_payout);
        nav_deposit = findViewById(R.id.nav_deposit);
        nav_wallet = findViewById(R.id.nav_wallets);
        nav_dashboard = findViewById(R.id.nav_dashboard);
        nav_requestmoney = findViewById(R.id.nav_requestmoney);
        nav_activity = findViewById(R.id.nav_activity);
        nav_logout = findViewById(R.id.nav_logout);
        background_topbar = findViewById(R.id.background_topbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finishAffinity();
                break;

            case R.id.img_side_menu:
                advance_drawer.openDrawer(GravityCompat.END);
                break;
            case R.id.img_close:
                advance_drawer.closeDrawer(GravityCompat.END);
                break;
            case R.id.nav_dashboard:
                App.getSingleton().setCheckScreen(1);
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                finish();
                advance_drawer.closeDrawer(GravityCompat.END);
                break;
            case R.id.nav_profile:
                App.getSingleton().setCheckScreen(2);
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                finish();
                advance_drawer.closeDrawer(GravityCompat.END);
                break;
            case R.id.nav_activity:
                App.getSingleton().setCheckScreen(3);
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                finish();
                advance_drawer.closeDrawer(GravityCompat.END);
                break;
            case R.id.nav_wallets:
                App.getSingleton().setCheckScreen(4);
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                finish();
                advance_drawer.closeDrawer(GravityCompat.END);
                break;
            case R.id.nav_deposit:
                App.getSingleton().setCheckScreen(5);
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                finish();
                advance_drawer.closeDrawer(GravityCompat.END);
                break;
            case R.id.nav_payout:
                App.getSingleton().setCheckScreen(6);
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                finish();
                advance_drawer.closeDrawer(GravityCompat.END);
                break;
            case R.id.nav_sendmoney:
                App.getSingleton().setCheckScreen(7);
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                finish();
                advance_drawer.closeDrawer(GravityCompat.END);
                break;
            case R.id.nav_requestmoney:
                App.getSingleton().setCheckScreen(8);
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                finish();
                advance_drawer.closeDrawer(GravityCompat.END);
                break;

            case R.id.nav_exchange:
                App.getSingleton().setCheckScreen(9);
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                finish();
                advance_drawer.closeDrawer(GravityCompat.END);
                break;

            case R.id.nav_logout:
                App.getSingleton().setLogout(1);
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
                finish();
                advance_drawer.closeDrawer(GravityCompat.END);
                break;
        }
    }
}