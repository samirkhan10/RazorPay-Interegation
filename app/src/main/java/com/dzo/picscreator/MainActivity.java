package com.dzo.picscreator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dzo.picscreator.databinding.ActivityMainBinding;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentProcess();
            }
        });

    }

    private void paymentProcess() {
        Checkout checkout = new Checkout();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name","samir");
            jsonObject.put("desc","Ordering from Zomato Apk");
            jsonObject.put("image", android.R.drawable.btn_star_big_on);
            jsonObject.put("currency","INR");
            jsonObject.put("amount","100");
            JSONObject object = new JSONObject();
            object.put("contact","9854745684");
            object.put("email","sam@gmail.com");
            jsonObject.put("object","object");
            checkout.open(MainActivity.this,jsonObject);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();

    }
}