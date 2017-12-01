package com.example.alex.groupprojectcomplete;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;


public class BuyBookPage extends AppCompatActivity {

    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId("Acz4oQwktlKMEtRsGlgf8aEiGJMJ6mRKcZiUl9LSwmPL0KUG4d3CH6nWzo2bs3t_YVmd1lIP_vHKFE06");

    String getPrice, getTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_book_page);

        final Button button = (Button) findViewById(R.id.button3);

        String ResNo = getIntent().getStringExtra("ResultNo");
        getTitle = getIntent().getStringExtra("Title");
        String getCondition = getIntent().getStringExtra("Condition");
        getPrice = getIntent().getStringExtra("Price");

        TextView Title = (TextView)this.findViewById(R.id.RTtile);
        TextView Conditon = (TextView)this.findViewById(R.id.RCondition);
        TextView Price = (TextView)this.findViewById(R.id.RPrice);

        Title.setText(getTitle);
        Conditon.setText(getCondition);
        Price.setText(getPrice);



        if(ResNo == "1"){

        }else if(ResNo == "2"){

        }else if(ResNo == "3"){


        }



    }

    public void beginPayment(View view){
        Intent serviceConfig = new Intent(this, PayPalService.class);
        serviceConfig.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(serviceConfig);

        PayPalPayment payment = new PayPalPayment(new BigDecimal(getPrice),
                "GBP", "Book Title:" + getTitle, PayPalPayment.PAYMENT_INTENT_SALE);

        Intent paymentConfig = new Intent(this, PaymentActivity.class);
        paymentConfig.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        paymentConfig.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
        startActivityForResult(paymentConfig, 0);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if (resultCode == Activity.RESULT_OK){
            PaymentConfirmation confirm = data.getParcelableExtra(
                    PaymentActivity.EXTRA_RESULT_CONFIRMATION);
            if (confirm != null){
                try {
                    Log.i("sampleapp", confirm.toJSONObject().toString(4));

                    // TODO: send 'confirm' to your server for verification

                } catch (JSONException e) {
                    Log.e("sampleapp", "no confirmation data: ", e);
                }
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Log.i("sampleapp", "The user canceled.");
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
            Log.i("sampleapp", "Invalid payment / config set");
        }
    }
}
