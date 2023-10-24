package com.example.lesson8.ui.cats_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lesson8.R;
import com.example.lesson8.ui.cats.model.Cat;
import com.example.lesson8.ui.utils.GlideProvider;


public class CatsInfoFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private Cat cat;

    public static CatsInfoFragment newInstance(Cat cat) {
        CatsInfoFragment fragment = new CatsInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, cat);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cat = (Cat) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.catIdTextView);
        ImageView imageView = view.findViewById(R.id.catImageView);

        GlideProvider.loadImage(cat.getImage(), imageView);
        textView.setText(cat.getId());
    }
}