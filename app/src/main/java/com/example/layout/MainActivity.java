package com.example.layout;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    int banner_img[]={R.drawable.ima,R.drawable.cam,R.drawable.max};
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaring and initilazing the bottomNavigation Bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        //Setting on the onclick listener on each item of navigation bar
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home is pressed", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.locate:
                        Toast.makeText(MainActivity.this, "locate Me is pressed", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.olx:
                        Toast.makeText(MainActivity.this, "PUDaOlx is pressed", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });

        //Declaring image
        image = findViewById(R.id.image_slide_show);
        image.setImageResource(R.drawable.ima);

        //Setting timer for changing image after 5 seconds
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                if (i==banner_img.length) i=0;
                handler.postDelayed(this,5000);
                image.setImageResource(banner_img[i]);
                i++;
            }
        };handler.post(run);


        //Setting on the onclick listener on each item of top action bar
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn_events:
                Toast.makeText(this, "Event has been clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.btn_notification:
                Toast.makeText(this, "Notifications has been clicked", Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }



}
