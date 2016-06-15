package com.cinnamon.digitapp;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Noticia>listaNoticias=new ArrayList<>();
    private RecyclerView recyclerView;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView= (RecyclerView)findViewById(R.id.layout_recycler_view);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        llenarListaNoticias();

        AdapterRecyclerView adapterRecyclerView=new AdapterRecyclerView(listaNoticias);

        recyclerView.setAdapter(adapterRecyclerView);

        ListenerNoticias unListenerDeNoticias = new ListenerNoticias();
        adapterRecyclerView.setOnClickListener(unListenerDeNoticias);

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new ListenerMenu());

        }

    public void llenarListaNoticias(){
        listaNoticias.add(new Noticia("Uruguay eliminado de la Copa América","Perdió con Venezuela",R.drawable.uruguay,1,R.drawable.pelota_futbol));
        listaNoticias.add(new Noticia("Fede Bal habló en Showmatch","Desmintió violencia de genero",R.drawable.showmatch,10,R.drawable.tele));
        listaNoticias.add(new Noticia("Snapchat, la red de los jóvenes","Muy popular entre los millennials",R.drawable.snapchat,20,R.drawable.redes));
        listaNoticias.add(new Noticia("El viernes 17 será feriado","Se aprobó en diputados",R.drawable.diputados,30,R.drawable.taza));
        listaNoticias.add(new Noticia("Procesaron al ex titular del PAMI","Se trata de Luciano Di Césare",R.drawable.pami,45,R.drawable.taza));
        listaNoticias.add(new Noticia("River interesado por Franco Armani","Oferta formal por el arquero",R.drawable.armani,50,R.drawable.pelota_futbol));
        listaNoticias.add(new Noticia("Medio aguinaldo fuera de ganancias","Opina Sergio Massa",R.drawable.ganancias,60,R.drawable.taza));
        listaNoticias.add(new Noticia("Obama apoya oficialmente a Hillary Clinton","Lo hizo en un video de Youtube",R.drawable.obama,100,R.drawable.taza));
        listaNoticias.add(new Noticia("Macarena abandonó la casa de GH","Fue por voluntad propia",R.drawable.gh,120,R.drawable.tele));
        listaNoticias.add(new Noticia("Mira el nuevo look de Messi","Se dejo la barba",R.drawable.messi,140,R.drawable.vestido));
    }
    private class ListenerNoticias implements View.OnClickListener{


        @Override
        public void onClick(View view) {
            Intent unIntent= new Intent(view.getContext(),ViewPagerActivity.class);
            startActivity(unIntent);
        }
    }
    private void selectedMenuItem(MenuItem item){


     Integer id =item.getItemId();

        if(id== R.id.mas_leidas_drawer_view) {

            FragmentMasLeido crearFragmentMasLeido = new FragmentMasLeido();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.aca_va_el_fragment, crearFragmentMasLeido);
            fragmentTransaction.commit();

        } else if (id==R.id.deporte_drawer_view) {

            FragmentDeporte crearFragmentDeporte = new FragmentDeporte();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.aca_va_el_fragment, crearFragmentDeporte);
            fragmentTransaction.commit();
        } else if (id==R.id.entretenimiento_drawer_view) {

            FragmentEntretenimiento crearFragmentEntretenimiento = new FragmentEntretenimiento();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.aca_va_el_fragment, crearFragmentEntretenimiento);
            fragmentTransaction.commit();
        }else if (id==R.id.social_drawer_view) {

            FragmentSocial crearFragmentSocial = new FragmentSocial();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.aca_va_el_fragment, crearFragmentSocial);
            fragmentTransaction.commit();
        } else if (id==R.id.moda_drawer_view)
                Toast.makeText(this,"Tocaste moda",Toast.LENGTH_SHORT).show();
          FragmentModa crearFragmentModa = new FragmentModa();
          FragmentManager fragmentManager = getSupportFragmentManager();
          FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
          fragmentTransaction.replace(R.id.aca_va_el_fragment, crearFragmentModa);
          fragmentTransaction.commit();
    }

    private class ListenerMenu implements NavigationView.OnNavigationItemSelectedListener{

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            selectedMenuItem(item);
            return true;
        }
    }
}
