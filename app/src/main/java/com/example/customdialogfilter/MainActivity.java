package com.example.customdialogfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnFilter;
    private TextView txtFilterMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView(){
        btnFilter=findViewById(R.id.btnFilter);
        txtFilterMsg=findViewById(R.id.txtFilterMsg);

    }
    private void initListener(){
        btnFilter.setOnClickListener(new btnFilterClickListener());
    }

    private class btnFilterClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            FilterDialog filterDialog =new FilterDialog(MainActivity.this);
            filterDialog.setOnFilterlistner(new FilterActions());
            filterDialog.show();
        }
    }

    class FilterActions implements FilterDialog.onFilterlistner{

        @Override
        public void onSuccess() {
            txtFilterMsg.setText("No Property Available");

        }
    }

}