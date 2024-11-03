package com.example.superquiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.superquiz.databinding.FragmentWelcomeBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;

    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        binding.letsplayButton.setEnabled(false);
    }

    // Ajout du support du binding pour affichage et la liaison entre la classe xml et java
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_welcome, container, false);
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);

        // Verifiez si la saisie de l'utilisateur n'est pas vide et dans ce cas autorisé le clic
        binding.usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                boolean isEmpty = editable.toString().isEmpty();
                binding.letsplayButton.setEnabled(!isEmpty);
            }
        });

        // Détecter le clic sur le bouton let's play pour demarrer le quiz
        binding.letsplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Naviguer vers le fragment de quizz
                Log.d("Fanny", "click");
                FragmentManager fragmentManager = getParentFragmentManager(); // Gestionnaire de fragment pour la redirection
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // operation sur un fragment
                QuizFragment quizFragment = new QuizFragment();
                fragmentTransaction.replace(R.id.fragment_container_view, quizFragment);
                fragmentTransaction.commit(); // Il faut toujours commiter une transaction
            }
        });

        return binding.getRoot();
    }




}