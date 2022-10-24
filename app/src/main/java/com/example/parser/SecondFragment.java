package com.example.parser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.instagram4j.instagram4j.IGClient;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.parser.databinding.FragmentSecondBinding;
import com.github.instagram4j.instagram4j.actions.IGClientActions;
import com.github.instagram4j.instagram4j.requests.igtv.IgtvSearchRequest;
import com.github.instagram4j.instagram4j.responses.igtv.IgtvSearchResponse;

import java.util.concurrent.CompletableFuture;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        IGClient client = IGClient.builder()
                .username("username")
                .password("password")
                .build();
//        binding = FragmentSecondBinding.inflate(inflater, container, false);
//        return binding.getRoot();

        CompletableFuture<IgtvSearchResponse> res = client.sendRequest(new IgtvSearchRequest());

        return null;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}