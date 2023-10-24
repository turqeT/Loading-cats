package com.example.lesson8.ui.cats_mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson8.R;
import com.example.lesson8.ui.adapter.CatAdapter;
import com.example.lesson8.ui.cats.model.Cat;
import com.example.lesson8.ui.cats.presenter.CatListPresenter;
import com.example.lesson8.ui.cats.presenter.CatListView;
import com.example.lesson8.ui.cats_info.CatsInfoFragment;
import com.example.lesson8.ui.listener.CatsListener;

import java.util.List;


public class CatsMVPFragment extends Fragment implements CatsListener, CatListView {
    private RecyclerView recyclerView;
    private TextView noDataTextView;
    private CatListPresenter catListPresenter;
    private CatAdapter catAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        catListPresenter = new CatListPresenter(this, getContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        catAdapter = new CatAdapter(this);
        noDataTextView = view.findViewById(R.id.noDataTextView);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(catAdapter);
        catListPresenter.getCats();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onItemClick(Cat cat) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.container, CatsInfoFragment.newInstance(cat));
        ft.addToBackStack(null)
                .commit();
    }

    @Override
    public void showCats(List<Cat> cats) {
        recyclerView.setVisibility(View.VISIBLE);
        noDataTextView.setVisibility(View.GONE);
        catAdapter.setCats(cats);
    }

    @Override
    public void showNoDataMessage() {
        recyclerView.setVisibility(View.GONE);
        noDataTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        catListPresenter.onDestroy();
    }
}