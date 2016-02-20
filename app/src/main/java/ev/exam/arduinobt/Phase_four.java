package ev.exam.arduinobt;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Phase_four extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton unit2up,unit3up,unit4up,unit5up,unit6up,unit2down,unit3down,unit4down,unit5down,unit6down;
    TextView mosq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_four);
        unit2up=(FloatingActionButton)findViewById(R.id.unit2up);
        unit3up=(FloatingActionButton)findViewById(R.id.unit3up);
        unit4up=(FloatingActionButton)findViewById(R.id.unit4up);
        unit5up=(FloatingActionButton)findViewById(R.id.unit5up);
        unit6up=(FloatingActionButton)findViewById(R.id.unit6up);
        unit2down=(FloatingActionButton)findViewById(R.id.unit2down);
        unit3down=(FloatingActionButton)findViewById(R.id.unit3down);
        unit4down=(FloatingActionButton)findViewById(R.id.unit4down);
        unit5down=(FloatingActionButton)findViewById(R.id.unit5down);
        unit6down=(FloatingActionButton)findViewById(R.id.unit6down);
        mosq=(TextView)findViewById(R.id.mosquep4);
        
        unit2up.setOnClickListener(this);
        unit3up.setOnClickListener(this);
        unit4up.setOnClickListener(this);
        unit5up.setOnClickListener(this);
        unit2down.setOnClickListener(this);
        unit3down.setOnClickListener(this);
        unit4down.setOnClickListener(this);
        unit5down.setOnClickListener(this);
        unit6down.setOnClickListener(this);
        mosq.setOnClickListener(this);
        

        statusReciver();


    }
    void changeStatus(TextView frameLayout,long Target){

        try{
            if(App.sendan.checkStatus(Target)){

                frameLayout.setBackgroundColor(Color.parseColor("#a219a924"));

            }else{
                frameLayout.setBackgroundColor(Color.TRANSPARENT);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void statusReciver(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            changeStatus(unit2up, Sendan.UNIT2_RIGHT);
                            changeStatus(unit3up, Sendan.UNIT3_UP);
                            changeStatus(unit4up, Sendan.UNIT4_UP);
                            changeStatus(unit5up, Sendan.UNIT5_UP);
                            changeStatus(unit6up, Sendan.UNIT6_UP);
                            changeStatus(unit2down, Sendan.UNIT2_LEFT);
                            changeStatus(unit3down, Sendan.UNIT3_DOWN);
                            changeStatus(unit4down, Sendan.UNIT4_DOWN);
                            changeStatus(unit5down, Sendan.UNIT5_DOWN);
                            changeStatus(unit6down, Sendan.UNIT6_DOWN);
                           changeStatus(mosq, Sendan.MOSQE);
                            

                        }
                    });

                }
            }
        });
        thread.start();
    }
    void changeStatus(FloatingActionButton frameLayout,long Target){

        try{
            if(App.sendan.checkStatus(Target)){

//                frameLayout.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.parseColor("#a219a924")}));


            }else{
//                frameLayout.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.TRANSPARENT}));

            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.unit2up:
                if (App.sendan.checkStatus(Sendan.UNIT2_RIGHT)) {
                   MainActivity.sendToBt(Sendan.UNIT2_RIGHT, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT2_RIGHT, false);
                }
                break;
            case R.id.unit3up:
                if (App.sendan.checkStatus(Sendan.UNIT3_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT3_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT3_UP, false);
                }
                break;
            case R.id.unit4up:
                if (App.sendan.checkStatus(Sendan.UNIT4_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT4_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT4_UP, false);
                }
                break;
            case R.id.unit5up:
                if (App.sendan.checkStatus(Sendan.UNIT5_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT5_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT5_UP, false);
                }
                break;
            case R.id.unit6up:
                if (App.sendan.checkStatus(Sendan.UNIT6_UP)) {
                    MainActivity.sendToBt(Sendan.UNIT6_UP, true);
                } else {
                    MainActivity.sendToBt(Sendan.UNIT6_UP, false);
                }
                break;
            case R.id.pstationp3:
                if (App.sendan.checkStatus(Sendan.PETROL_STATION)) {
                    MainActivity.sendToBt(Sendan.PETROL_STATION, true);
                } else {
                    MainActivity.sendToBt(Sendan.PETROL_STATION, false);
                }
                break;
            case R.id.unit2down:
                if (App.sendan.checkStatus(Sendan.UNIT2_LEFT)) {
                    MainActivity.sendToBt(Sendan.UNIT2_LEFT, true);
                } else {
                    MainActivity.sendToBt(Sendan.UNIT2_LEFT, false);
                }
                break;
            case R.id.unit3down:
                if (App.sendan.checkStatus(Sendan.UNIT3_DOWN)) {
                    MainActivity.sendToBt(Sendan.UNIT3_DOWN, true);
                } else {
                    MainActivity.sendToBt(Sendan.UNIT3_DOWN, false);
                }
                break;
            case R.id.unit4down:
                if (App.sendan.checkStatus(Sendan.UNIT4_DOWN)) {
                    MainActivity.sendToBt(Sendan.UNIT4_DOWN, true);
                } else {
                    MainActivity.sendToBt(Sendan.UNIT4_DOWN, false);
                }
                break;
            case R.id.unit5down:
                if (App.sendan.checkStatus(Sendan.UNIT5_DOWN)) {
                    MainActivity.sendToBt(Sendan.UNIT5_DOWN, true);
                } else {
                    MainActivity.sendToBt(Sendan.UNIT5_DOWN, false);
                }
                break;
            case R.id.unit6down:
                if (App.sendan.checkStatus(Sendan.UNIT6_DOWN)) {
                    MainActivity.sendToBt(Sendan.UNIT6_DOWN, true);
                } else {
                    MainActivity.sendToBt(Sendan.UNIT6_DOWN, false);
                }
                break;

        }
    }

}
