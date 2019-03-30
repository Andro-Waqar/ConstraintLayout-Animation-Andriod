package com.softwindevs.animationconstraintlayout;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_animate;
    ConstraintLayout constraintLayout;
    private boolean isOpen = false;
    private ConstraintSet layout1, layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = new ConstraintSet();
        layout2 = new ConstraintSet();

        btn_animate = (Button)findViewById(R.id.btn_animate);
        constraintLayout = findViewById(R.id.main_activity_layout);
        layout2.clone(this,R.layout.activity_main_animate);
        layout1.clone(constraintLayout);


        btn_animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isOpen){
                    TransitionManager.beginDelayedTransition(constraintLayout);
                    layout2.applyTo(constraintLayout);
                    isOpen=!isOpen;
                }
                else{
                    TransitionManager.beginDelayedTransition(constraintLayout);
                    layout1.applyTo(constraintLayout);
                    isOpen=!isOpen;
                }

            }
        });


    }
}
