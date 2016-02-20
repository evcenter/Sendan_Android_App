package ev.exam.arduinobt;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Phase_three extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton unit21up,unit23up,unit24up,unit25up,unit22up,unit21down,unit23down,unit24down,unit25down,unit22down;
    TextView pstation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_three);
        unit21up=(FloatingActionButton)findViewById(R.id.unit21up);
        unit22up=(FloatingActionButton)findViewById(R.id.unit22up);
        unit23up=(FloatingActionButton)findViewById(R.id.unit23up);
        unit24up=(FloatingActionButton)findViewById(R.id.unit24up);
        unit25up=(FloatingActionButton)findViewById(R.id.unit25up);

        unit21down=(FloatingActionButton)findViewById(R.id.unit21down);
        unit22down=(FloatingActionButton)findViewById(R.id.unit22down);
        unit23down=(FloatingActionButton)findViewById(R.id.unit23down);
        unit24down=(FloatingActionButton)findViewById(R.id.unit24down);
        unit25down=(FloatingActionButton)findViewById(R.id.unit25down);

        pstation=(TextView)findViewById(R.id.pstationp3);
        
        unit21up.setOnClickListener(this);
        unit23up.setOnClickListener(this);
        unit24up.setOnClickListener(this);
        unit25up.setOnClickListener(this);
        unit22down.setOnClickListener(this);
        unit23down.setOnClickListener(this);
        unit24down.setOnClickListener(this);
        unit25down.setOnClickListener(this);
        unit22down.setOnClickListener(this);
        pstation.setOnClickListener(this);
        

        statusReciver();


    }

    public void statusReciver(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            changeStatus(unit21up, Sendan.UNIT21_UP);
//                            changeStatus(unit22up, Sendan.UNIT22_UP);
//                            changeStatus(unit23up, Sendan.UNIT23_UP);
//                            changeStatus(unit24up, Sendan.UNIT24_UP);
//                            changeStatus(unit25up, Sendan.UNIT25_LEFT);
//
//
//                            changeStatus(unit21down, Sendan.UNIT21_DOWN);
//                            changeStatus(unit22down, Sendan.UNIT22_DOWN);
//                            changeStatus(unit23down, Sendan.UNIT23_DOWN);
//                            changeStatus(unit24down, Sendan.UNIT24_DOWN);
//                            changeStatus(unit25down, Sendan.UNIT25_RIGHT);

                           changeStatus(pstation, Sendan.MOSQE);
                            

                        }
                    });

                }
            }
        });
        thread.start();
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
//    void changeStatus(FloatingActionButton frameLayout,long Target){
//
//        try{
//            if(App.sendan.checkStatus(Target)){
//
//                frameLayout.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.parseColor("#a219a924")}));
//
//
//            }else{
//                frameLayout.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.TRANSPARENT}));
//
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.unit21up:
                if (App.sendan.checkStatus(Sendan.UNIT2_RIGHT)) {
                   MainActivity.sendToBt(Sendan.UNIT2_RIGHT, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT2_RIGHT, false);
                }
                break;
            case R.id.unit23up:
                if (App.sendan.checkStatus(Sendan.UNIT3_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT3_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT3_UP, false);
                }
                break;
            case R.id.unit24up:
                if (App.sendan.checkStatus(Sendan.UNIT4_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT4_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT4_UP, false);
                }
                break;
            case R.id.unit25up:
                if (App.sendan.checkStatus(Sendan.UNIT5_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT5_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT5_UP, false);
                }
                break;
            case R.id.unit22up:
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
