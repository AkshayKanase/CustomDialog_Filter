package com.example.customdialogfilter;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class FilterDialog extends Dialog {
    private TextView txtPriceRange;
    private CheckBox checkOneBhk,checkTwoBhk,checkThreeBhk;
    private Button btnOk;
    private SeekBar seekbarPrice;

    public interface onFilterlistner{
        void onSuccess();


    }
    private onFilterlistner onFilterlistner;
    public void setOnFilterlistner(onFilterlistner onFilterlistner){
        this.onFilterlistner=onFilterlistner;
    }




    public FilterDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_layout);
        initViews();
        initListeners();



        seekbarPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                txtPriceRange.setText(""+String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void initViews(){
        txtPriceRange=findViewById(R.id.txtPriceRange);
        checkOneBhk=findViewById(R.id.checkOneBhk);
        checkTwoBhk=findViewById(R.id.checkTwoBhk);
        checkThreeBhk=findViewById(R.id.checkThreeBhk);
        seekbarPrice=findViewById(R.id.seekbarPrice);
        btnOk=findViewById(R.id.btnOk);
    }
    private void initListeners(){
        btnOk.setOnClickListener(new btnOkListener());
    }

    private class btnOkListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            onFilterlistner.onSuccess();
            dismiss();
        }
    }

}
