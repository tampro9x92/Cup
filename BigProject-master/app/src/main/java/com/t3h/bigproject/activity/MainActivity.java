package com.t3h.bigproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.t3h.bigproject.R;
import com.t3h.bigproject.fragment.screen.drinkmenu.fragment.DrinkMenu;
import com.t3h.bigproject.fragment.screen.login.fragment.Login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private FrameLayout panel;
    private Login login = new Login();
    private DrinkMenu drinkMenu = new DrinkMenu();
    private LinearLayout lnToolbar;
    private TextView tvTitle;
    private CircleImageView circleImageAvatar;
    private ImageView imvSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        initTransition();
        showFragment(drinkMenu);

    }

    private void initView() {
        panel = findViewById(R.id.panel);
        lnToolbar = findViewById(R.id.lnToolbar);
        tvTitle = findViewById(R.id.tvTitle);
        circleImageAvatar = findViewById(R.id.circleImageAvatarUser);
        imvSearch = findViewById(R.id.imvSearch);
    }

    public void initTransition(){
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.add(R.id.panel,login);
        transition.add(R.id.panel,drinkMenu);
        transition.commit();
    }


    public void showFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.panel,login);
        transaction.replace(R.id.panel,drinkMenu);
        transaction.show(fragment);
        transaction.commit();
    }

    public void checking(){
        if (!login.isVisible()){
            lnToolbar.setVisibility(View.VISIBLE);
        }else {
            lnToolbar.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        checking();
        super.onResume();
    }
}
