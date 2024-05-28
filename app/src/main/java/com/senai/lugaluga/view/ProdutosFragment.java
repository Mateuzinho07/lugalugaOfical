package com.senai.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.senai.lugaluga.R;
import com.senai.lugaluga.RecyclerItemClickListener;
import com.senai.lugaluga.model.Produto;
import com.senai.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProdutosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProdutosFragment extends Fragment {

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();

    public ProdutosFragment() {
        // Required empty public constructor
    }


    public static ProdutosFragment newInstance(String param1, String param2) {
        ProdutosFragment fragment = new ProdutosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view = inflater.inflate(R.layout.fragment_produtos, container, false);

        recyclerView = view.findViewById(R.id.listaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getContext(),ProdutoActivity.class);
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

     return view;
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
