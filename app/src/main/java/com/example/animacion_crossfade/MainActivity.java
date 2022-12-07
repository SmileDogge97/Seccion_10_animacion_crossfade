package com.example.animacion_crossfade;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvContenido;
    ProgressBar pbLoading;
    private int duracionAnimacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContenido = findViewById(R.id.textViewContenido);
        pbLoading = findViewById(R.id.progressBarLoading);

        duracionAnimacion = getResources().getInteger(android.R.integer.config_longAnimTime);

        //ocultar el texto
        tvContenido.setVisibility(View.GONE);
        pbLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crossfadeAnimation();
            }
        });
    }

    private void crossfadeAnimation(){
        //mostrar progresivamente el texto
        tvContenido.setAlpha(0f);
        tvContenido.setVisibility(View.VISIBLE);

        tvContenido.animate().alpha(1f).setDuration(duracionAnimacion);

        //ocultar progresivamente la barra de carga
        pbLoading.animate().alpha(0f).setDuration(duracionAnimacion).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                pbLoading.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}