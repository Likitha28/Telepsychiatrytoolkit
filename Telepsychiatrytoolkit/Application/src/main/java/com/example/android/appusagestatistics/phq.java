package com.example.android.appusagestatistics;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class phq extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phq);


        Button button= (Button) findViewById(R.id.b1);

        final TextView t1 = (TextView) findViewById(R.id.t1);
        final TextView t2 = (TextView) findViewById(R.id.t2);
        final TextView t3 = (TextView) findViewById(R.id.t3);
     //   final TextView t4 = (TextView) findViewById(R.id.t4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup question1 = (RadioGroup) findViewById(R.id.RG1);
                String answer1 = ((RadioButton) findViewById(question1.getCheckedRadioButtonId())).getText().toString();
                t1.setText(answer1);

                RadioGroup question2 = (RadioGroup) findViewById(R.id.RG2);
                String answer2 = ((RadioButton) findViewById(question2.getCheckedRadioButtonId())).getText().toString();
                t2.setText(answer2);

                //Finding weightage of the answer selected.
                int weightage = 0;

                if( answer1.equals("Several Days"))
                    weightage = weightage + 1;
                if( answer2.equals("Several Days"))
                    weightage = weightage + 1;
                if( answer1.equals("More Than Half the Days"))
                    weightage = weightage + 2;
                if( answer2.equals("More Than Half the Days"))
                    weightage = weightage + 2;
                if( answer1.equals("Nearly Every Day"))
                    weightage = weightage + 3;
                if( answer2.equals("Nearly Every Day"))
                    weightage = weightage + 3;

                //Displaying the phq Page depending on the weightage.
                if( weightage >= 3)
                {
                    Toast.makeText(getApplicationContext(),
                            "Enter your responses for the PHQ2 Questions ", Toast.LENGTH_LONG).show();

                    Intent i=new Intent(phq.this, phq9.class);
                    startActivity(i);

                }
                else
                {
                    //t3.setText("kuch nai");
                    Toast.makeText(getApplicationContext(),
                            "Congratulations .... !!! Your SCORE is below threshold ", Toast.LENGTH_LONG).show();
                    //finish();

                }

            }
        });


    }

}