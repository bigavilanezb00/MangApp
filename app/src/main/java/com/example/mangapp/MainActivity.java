package com.example.mangapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.reciente_container, new DestacadoFragment()).commit();

        bottomNavigationView.setSelectedItemId(R.id.inicioFragment);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.inicioFragment:
                        fragment = new InicioFragment();

                    case R.id.destacadoFragment:
                        fragment = new DestacadoFragment();
                        break;
                    case R.id.buscadorFragment:
                        fragment = new BuscadorFragment();
                        break;
                    case R.id.favoritosFragment:
                        fragment = new FavoritosFragment();
                        break;
                    case R.id.ajustesFragment:
                        fragment = new AjustesFragment();
                        break;
                }

                return true;
            }
        });
    }
}