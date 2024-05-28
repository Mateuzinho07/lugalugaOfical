package com.senai.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.senai.lugaluga.R;
import com.senai.lugaluga.RecyclerItemClickListener;
import com.senai.lugaluga.model.Produto;
import com.senai.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar2);
        setSupportActionBar(myToolbar);




        recyclerView = findViewById(R.id.listaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this , LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                intent.putExtra("produto", produtoList.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

    }

    public void CriarListaProdutos(){
        Produto produto;

        produto = new Produto("Iphone 13" , "Iphone 13 64gb , Branco" , 200.00 , 10 , "Indisponível");
        produtoList.add(produto);

        produto = new Produto("Samsung A30" , "Samsung A30 64gb , Branco" , 100.00 , 4 , "Indisponível");
        produtoList.add(produto);

        produto = new Produto("Xbox One" , "Xbox One 500gb , Preto" , 150.00 , 7 , "Disponível");
        produtoList.add(produto);

        produto = new Produto("Samsung A10" , "Samsung A10 64gb , Vermelho" , 40.00 , 4 , "Indisponível");
        produtoList.add(produto);

        produto = new Produto("Iphone 14" , "Iphone 14 64gb , Preto" , 250.00 , 9 , "Disponível");
        produtoList.add(produto);

        produto = new Produto("Motorola G9" , "Motorola G9 64gb , Preto" , 60.00 , 4 , "Disponível");
        produtoList.add(produto);

        produto = new Produto("Xbox 360" , "Xbox 369 500gb , Preto" , 50.00 , 7 , "Disponível");
        produtoList.add(produto);

        produto = new Produto("Playstation 4" , "Playstation 4 500gb , Preto" , 90.00 , 5 , "Disponível");
        produtoList.add(produto);

        produto = new Produto("LG-K10" , "LG-K10 63gb , Preto" , 20.00 , 2 , "Disponível");
        produtoList.add(produto);

        produto = new Produto("Playstation 5" , "Playstation 5 500gb , Preto" , 200.00 , 5 , "Disponível");
        produtoList.add(produto);




    }
}