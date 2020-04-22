package com.example.e1i3_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import com.google.android.material.navigation.NavigationView;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Realm 초기화
        Realm.init(this);
        //Configuration 설정
        RealmConfiguration realmConfiguration=new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        //Realm 인스턴스를 얻는다
        Realm realm = Realm.getDefaultInstance();

        //navigation drawer 버튼 클릭시 drawer되게끔!
        final DrawerLayout drawerLayout=findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
//menu 네비게이션 바 안에 아이콘 색 넣어주는건데 우선 색 사용하지 않아서 디자인 할 때 사용하면 좋을 거 같음
        NavigationView navigationView=findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController= Navigation.findNavController(this,R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView,navController);

    }
}
