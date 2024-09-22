package com.example.cis183_homework02_rgb;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //declare Vars
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;

    TextView tv_J_redNum;
    TextView tv_J_greenNum;
    TextView tv_J_blueNum;
    TextView tv_j_hexNum;

    Button btn_j_addColor;

    ConstraintLayout cl_J_backRound;

    ListView lv_J_listView;

    ArrayList<MyColor> colorList;

    ColorListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //attach java variables to view counterparts
        sb_j_blue = findViewById(R.id.sb_v_blue);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_red = findViewById(R.id.sb_v_red);
        tv_J_blueNum = findViewById(R.id.tv_v_bluenum);
        tv_J_greenNum = findViewById(R.id.tv_v_greennum);
        tv_J_redNum = findViewById(R.id.tv_v_rednum);
        tv_j_hexNum = findViewById(R.id.tv_v_hexnum);
        btn_j_addColor = findViewById(R.id.btn_v_savecolor);
        cl_J_backRound = findViewById(R.id.main_cc);
        lv_J_listView = findViewById(R.id.listView);

        colorList = new ArrayList<MyColor>();
        
        seekBarChangeLister();
        buttonClickListner();
        onListClick();



    }

    private void brightnessChecker(){

    }

    private void onListClick(){
        lv_J_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyColor color = colorList.get(i);
                sb_j_red.setProgress(color.getRed());
                sb_j_green.setProgress(color.getGreen());
                sb_j_blue.setProgress(color.getBlue());
                //cl_J_backRound.setBackgroundColor(Color.rgb(color.getRed(), color.getGreen(), color.getBlue()));


            }
        });
    }
    
    private void buttonClickListner(){
        btn_j_addColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create a new color object to be added to arraylist
                MyColor newColor = new MyColor();
                //set color attributes
                newColor.setRed(sb_j_red.getProgress());
                newColor.setGreen(sb_j_green.getProgress());
                newColor.setBlue(sb_j_blue.getProgress());


                //add new color to arraylist
                colorList.add(newColor);
                //update list view
                fillListView();
                //reset backround


                sb_j_red.setProgress(255);
                sb_j_green.setProgress(255);
                sb_j_blue.setProgress(255);


            }
        });
    }

    private void seekBarChangeLister() {

        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_J_redNum.setText(String.valueOf(sb_j_red.getProgress()));
                cl_J_backRound.setBackgroundColor(Color.rgb(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress()));
                tv_j_hexNum.setText(String.format("#%02X%02X%02X", sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress()));


            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_J_greenNum.setText(String.valueOf(sb_j_green.getProgress()));
                cl_J_backRound.setBackgroundColor(Color.rgb(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress()));
                tv_j_hexNum.setText(String.format("#%02X%02X%02X", sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress()));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_J_blueNum.setText(String.valueOf(sb_j_blue.getProgress()));
                cl_J_backRound.setBackgroundColor(Color.rgb(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress()));
                tv_j_hexNum.setText(String.format("#%02X%02X%02X", sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress()));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void fillListView(){
        adapter = new ColorListAdapter(this, colorList);
        lv_J_listView.setAdapter(adapter);

    }
}