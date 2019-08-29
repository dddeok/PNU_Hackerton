package com.example.mentos;


import android.content.Intent;
<<<<<<< HEAD
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
=======
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
>>>>>>> d97a8be31b4e7438b41cb0081442c8b77d6dacd5


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.mentos.ViewUi.Board;
import com.example.mentos.ViewUi.Chat;
import com.example.mentos.ViewUi.Favorite;
import com.example.mentos.ViewUi.Profile;
import com.example.mentos.ViewUi.Qna;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    Intent intent;

=======
public class MainActivity extends AppCompatActivity {
    Button btn_temp;
>>>>>>> d97a8be31b4e7438b41cb0081442c8b77d6dacd5
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer);
        NavigationView navigationView;
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

/*    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }*/


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        Toast.makeText(getApplicationContext(),"클릭됨",Toast.LENGTH_LONG).show();
        Log.i("tag","클릭");
        switch (item.getItemId()) {
            case R.id.profile:
                Toast.makeText(getApplicationContext(),"profile",Toast.LENGTH_LONG).show();
                intent = new Intent(getApplicationContext(), Profile.class);
                Toast.makeText(getApplicationContext(),"profile",Toast.LENGTH_LONG).show();
                startActivity(intent);;
                break;
            case R.id.chat:
                intent = new Intent(getApplicationContext(), Chat.class);
                startActivity(intent);
                break;
            case R.id.favorite:
                intent = new Intent(getApplicationContext(), Favorite.class);
                startActivity(intent);
                break;
            case R.id.mentoBoard:
                intent = new Intent(getApplicationContext(), Board.class);
                startActivity(intent);
                break;
            case R.id.board:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.qna:
                intent = new Intent(getApplicationContext(), Qna.class);
                startActivity(intent);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
=======

        btn_temp = (Button)findViewById(R.id.btn_temp);
        btn_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyChatActivity.class);
                startActivity(intent);
            }
        });
>>>>>>> d97a8be31b4e7438b41cb0081442c8b77d6dacd5
    }
}
