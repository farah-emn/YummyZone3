package com.example.yummyzone.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yummyzone.R;
import com.example.yummyzone.activites.MainActivity;
import com.example.yummyzone.activites.MapActivity;
import com.example.yummyzone.adapter.cartItemAdapter;
import com.example.yummyzone.classes.cartItem;

import java.util.ArrayList;

public class cartFragment extends Fragment {

    RecyclerView rv;
    Button b;
    TextView tv;
    ArrayList<cartItem> c;
    MainActivity mainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_cart, container, false);

        rv =view.findViewById(R.id.cart_rv);
        b = view.findViewById(R.id.cart_bt);
        tv =view.findViewById(R.id.cart_tv_price);
        mainActivity = (MainActivity)getActivity();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapActivity.class);
                startActivity(intent);

            }
        });


        c = new ArrayList<>();
        c.add(new cartItem(R.drawable.foodimage, "Big testy","2","44 SR"));
        c.add(new cartItem(R.drawable.foodimage, "Big testy","2","44 SR"));
        cartItemAdapter ad = new cartItemAdapter(c);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(ad);
        return view;
    }
}