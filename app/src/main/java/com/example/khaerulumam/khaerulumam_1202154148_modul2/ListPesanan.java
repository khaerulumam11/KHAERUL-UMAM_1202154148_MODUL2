package com.example.khaerulumam.khaerulumam_1202154148_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.ArrayList;

public class ListPesanan extends AppCompatActivity {

    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> dataMenu;
    private ArrayList<String> dataHarga;
    private ArrayList<Integer> gambar;
    private TextView a,b;

    //Daftar Menu Makanan
    private String[] Judul = {"Nasi Goreng Seafood", "Sate Ayam","Bakso Telor","Mie Goreng Spesial","Soto Ayam","Ayam Bakar",
            "Cah Kangkung","Pecel Lele","Nasi Pecel","Lele Asam Manis"};
    //Daftar Harga
    private String[] test = {"Rp. 30.000", "Rp. 20.000","Rp. 15.000","Rp. 20.000","Rp. 15.000","Rp. 20.000","Rp. 15.000","Rp. 15.000",
    "Rp. 15.000","Rp. 15.000"};
    //Daftar Gambar
    private int[] Gambar = {R.drawable.nasgor, R.drawable.sate,R.drawable.bakso,R.drawable.miegoreng,R.drawable.soto,
    R.drawable.ayambakar,R.drawable.cahkangkung,R.drawable.pecellele,R.drawable.nasipecel,R.drawable.leleasam};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pesanan);

        //mensetting toolbar yang akan muncul di atas dengan nama List Makanan
        Toolbar mToolbar = (Toolbar) findViewById(R.id.appbar_list);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("List Makanan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //mendeklarasikan array list untuk menu, harga dan gambar
        dataMenu = new ArrayList<>();
        dataHarga = new ArrayList<>();
        gambar = new ArrayList<>();
        DaftarItem();

//        iniDataMenu();
//        iniDataHarga();
//        initgambar();

        rvView = (RecyclerView) findViewById(R.id.recyclerview);
        rvView.setHasFixedSize(true);

        /**
         * Kita menggunakan LinearLayoutManager untuk list standar
         * yang hanya berisi daftar item
         * disusun dari atas ke bawah
         */
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(dataMenu,dataHarga,gambar);
        rvView.setAdapter(adapter);

//        rvView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
////                Intent a = new Intent(ListPesanan.this,DetailMakanan.class);
////                a.putExtra("nama",dataMenu);
////                a.putExtra("harga",dataHarga);
////                a.putExtra("gambar",gambar);
////                startActivity(a);
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
    }

    //Mengambil data dari Varibale Gambar dan Judul, lalu memasangnya pada list yang terhubung dengan Class Adapter
    private void DaftarItem(){
        for (int w=0; w<Judul.length; w++){
            dataMenu.add(Judul[w]);
            dataHarga.add(test[w]);
            gambar.add(Gambar[w]);
        }
    }


//    private void initgambar() {
//       gambar.add(R.drawable.android);
//       gambar.add(R.drawable.android);
//       gambar.add(R.drawable.android);
//
//    }
//
//    private void iniDataHarga() {
//        dataHarga.add("Rp. 30.000");
//        dataHarga.add("Rp. 30.000");
//        dataHarga.add("Rp. 30.000");
//
//    }
//
//    private void iniDataMenu() {
//        //Menambahkan isi item yang mau kita inputkan
//        dataMenu.add("Nasi Goreng Ayam");
//        dataMenu.add("Nasi Goreng Ayam");
//        dataMenu.add("Nasi Goreng Ayam");
//
//    }
}
