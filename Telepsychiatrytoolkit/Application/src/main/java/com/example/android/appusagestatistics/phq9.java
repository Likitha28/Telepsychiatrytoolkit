package com.example.android.appusagestatistics;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class phq9 extends AppCompatActivity {

    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_phq9);



        Button button= (Button) findViewById(R.id.b1);

        final TextView t1 = (TextView) findViewById(R.id.t1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup question1 = (RadioGroup) findViewById(R.id.RG1);
                String answer1 = ((RadioButton) findViewById(question1.getCheckedRadioButtonId())).getText().toString();

                RadioGroup question2 = (RadioGroup) findViewById(R.id.RG2);
                String answer2 = ((RadioButton) findViewById(question2.getCheckedRadioButtonId())).getText().toString();

                RadioGroup question3 = (RadioGroup) findViewById(R.id.RG3);
                String answer3 = ((RadioButton) findViewById(question3.getCheckedRadioButtonId())).getText().toString();

                RadioGroup question4 = (RadioGroup) findViewById(R.id.RG4);
                String answer4 = ((RadioButton) findViewById(question4.getCheckedRadioButtonId())).getText().toString();

                RadioGroup question5 = (RadioGroup) findViewById(R.id.RG5);
                String answer5 = ((RadioButton) findViewById(question5.getCheckedRadioButtonId())).getText().toString();

                RadioGroup question6 = (RadioGroup) findViewById(R.id.RG6);
                String answer6 = ((RadioButton) findViewById(question6.getCheckedRadioButtonId())).getText().toString();

                RadioGroup question7 = (RadioGroup) findViewById(R.id.RG7);
                String answer7 = ((RadioButton) findViewById(question7.getCheckedRadioButtonId())).getText().toString();

                RadioGroup question8 = (RadioGroup) findViewById(R.id.RG8);
                String answer8 = ((RadioButton) findViewById(question8.getCheckedRadioButtonId())).getText().toString();

                RadioGroup question9 = (RadioGroup) findViewById(R.id.RG9);
                String answer9 = ((RadioButton) findViewById(question9.getCheckedRadioButtonId())).getText().toString();

                int weightage = 0;

                if( answer1.equals("Several Days"))
                    weightage = weightage + 1;
                if( answer1.equals("More Than Half the Days"))
                    weightage = weightage + 2;
                if( answer1.equals("Nearly Every Day"))
                    weightage = weightage + 3;
                if( answer2.equals("Several Days"))
                    weightage = weightage + 1;
                if( answer2.equals("More Than Half the Days"))
                    weightage = weightage + 2;
                if( answer2.equals("Nearly Every Day"))
                    weightage = weightage + 3;
                if( answer3.equals("Several Days"))
                    weightage = weightage + 1;
                if( answer3.equals("More Than Half the Days"))
                    weightage = weightage + 1;
                if( answer3.equals("Nearly Every Day"))
                    weightage = weightage + 1;
                if( answer4.equals("Several Days"))
                    weightage = weightage + 1;
                if( answer4.equals("More Than Half the Days"))
                    weightage = weightage + 2;
                if( answer4.equals("Nearly Every Day"))
                    weightage = weightage + 3;
                if( answer5.equals("Several Days"))
                    weightage = weightage + 1;
                if( answer5.equals("More Than Half the Days"))
                    weightage = weightage + 2;
                if( answer5.equals("Nearly Every Day"))
                    weightage = weightage + 3;
                if( answer6.equals("Several Days"))
                    weightage = weightage + 1;
                if( answer6.equals("More Than Half the Days"))
                    weightage = weightage + 2;
                if( answer6.equals("Nearly Every Day"))
                    weightage = weightage + 3;
                if( answer7.equals("Several Days"))
                    weightage = weightage + 1;
                if( answer7.equals("More Than Half the Days"))
                    weightage = weightage + 2;
                if( answer7.equals("Nearly Every Day"))
                    weightage = weightage + 3;
                if( answer8.equals("Several Days"))
                    weightage = weightage + 1;
                if( answer8.equals("More Than Half the Days"))
                    weightage = weightage + 2;
                if( answer8.equals("Nearly Every Day"))
                    weightage = weightage + 3;
                if( answer9.equals("Several Days"))
                    weightage = weightage + 1;
                if( answer9.equals("More Than Half the Days"))
                    weightage = weightage + 2;
                if( answer9.equals("Nearly Every Day"))
                    weightage = weightage + 3;

                //Displaying the phq Page depending on the weightage.
                if( weightage ==5 )
                {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setMessage("Mild Depression ! Would you like to read a few jokes ?");
                            alertDialogBuilder.setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            Intent i = new Intent(phq9.this, Jokes.class);
                                            startActivity(i);
                                        }
                                    });

                    alertDialogBuilder.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();


                }

                else if( weightage ==10 )
                {

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setMessage("Moderate Depression ! Would you like to read a few jokes ?");
                    alertDialogBuilder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    Intent i = new Intent(phq9.this, Jokes.class);
                                    startActivity(i);
                                }
                            });

                    alertDialogBuilder.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }

                else if( weightage ==15 )
                {


                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setMessage("Moderately Severe Depression ! Would you like to read a few jokes ?");
                    alertDialogBuilder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    Intent i = new Intent(phq9.this, Jokes.class);
                                    startActivity(i);
                                }
                            });

                    alertDialogBuilder.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
                else if( weightage ==20 )
                {


                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setMessage("Severe Depression ! Would you like to read a few jokes ?");
                    alertDialogBuilder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    Intent i = new Intent(phq9.this, Jokes.class);
                                    startActivity(i);
                                }
                            });

                    alertDialogBuilder.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

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
