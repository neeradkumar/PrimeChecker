package com.bard.primechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numberEditText = (EditText) findViewById(R.id.number);
        Button isPrimeButton = (Button) findViewById(R.id.is_prime_button);
        Button untilPrimeButton = (Button) findViewById(R.id.primes_till_button);
        final TextView resultTextView = (TextView) findViewById(R.id.result_text);

        isPrimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = numberEditText.getText().toString();
                if(inputString.equals("")){
                    numberEditText.setError("Can't be empty");
                    return;
                }
                int inputInteger = Integer.parseInt(inputString);
                boolean isPrime = PrimeUtils.isPrimeOrNot(inputInteger);
                if(isPrime){
                    resultTextView.setText(inputInteger+" is a prime");
                }
                else{
                    resultTextView.setText(inputInteger+" is not a prime");
                }
            }
        });
        untilPrimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = numberEditText.getText().toString();
                if(inputString.equals("")){
                    numberEditText.setError("Can't be empty");
                    return;
                }
                int inputInteger = Integer.parseInt(inputString);
                ArrayList<Integer> primeNumberTill = PrimeUtils.primeNumbersUpto(inputInteger);
                String primeNumberTillString = primeNumberTill.toString();
                resultTextView.setText("List of prime numbers are "+primeNumberTillString);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
