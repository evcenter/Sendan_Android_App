package ev.exam.arduinobt;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class Phase_one extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton unit7up,unit8up,unit9up,unit10up,storeup,storedown,unit7down,unit8down,unit9down,unit10down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_one);
        unit7up=(FloatingActionButton)findViewById(R.id.unit7up);
        unit8up=(FloatingActionButton)findViewById(R.id.unit8up);
        unit9up=(FloatingActionButton)findViewById(R.id.unit9up);
        unit10up=(FloatingActionButton)findViewById(R.id.unit10up);
        unit7down=(FloatingActionButton)findViewById(R.id.unit7down);
        unit8down=(FloatingActionButton)findViewById(R.id.unit8down);
        unit9down=(FloatingActionButton)findViewById(R.id.unit9down);
        unit10down=(FloatingActionButton)findViewById(R.id.unit10down);
        storeup=(FloatingActionButton)findViewById(R.id.storeupp1);
        storedown=(FloatingActionButton)findViewById(R.id.storedownp1);
        unit7up.setOnClickListener(this);
        unit7up.setOnClickListener(this);
        unit8up.setOnClickListener(this);
        unit9up.setOnClickListener(this);
        unit10up.setOnClickListener(this);
        unit7down.setOnClickListener(this);
        unit8down.setOnClickListener(this);
        unit9down.setOnClickListener(this);
        unit10down.setOnClickListener(this);
        storeup.setOnClickListener(this);
        storedown.setOnClickListener(this);
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
                            changeStatus(unit7up, Sendan.UNIT7_UP);
                            changeStatus(unit8up, Sendan.UNIT8_UP);
                            changeStatus(unit9up, Sendan.UNIT9_UP);
                            changeStatus(unit10up, Sendan.UNIT10_UP);
                            changeStatus(unit7down, Sendan.UNIT7_DOWN);
                            changeStatus(unit8down, Sendan.UNIT8_DOWN);
                            changeStatus(unit9down, Sendan.UNIT9_DOWN);
                            changeStatus(unit10down, Sendan.UNIT10_DOWN);
                            changeStatus(storeup, Sendan.UNIT11_UP);
                            changeStatus(storedown, Sendan.UNIT11_DOWN);

                        }
                    });

                }
            }
        });
        //thread.start();
    }
    void changeStatus(FloatingActionButton frameLayout,long Target){

        try{
            if(App.sendan.checkStatus(Target)){

                frameLayout.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.parseColor("#a219a924")}));


            }else{
                frameLayout.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.TRANSPARENT}));

            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.unit7up:
                if (App.sendan.checkStatus(Sendan.UNIT7_UP)) {
                    MainActivity.sendToBt(Sendan.UNIT7_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT7_UP, false);
                }
                break;
            case R.id.unit8up:
                if (App.sendan.checkStatus(Sendan.UNIT8_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT8_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT8_UP, false);
                }
                break;
            case R.id.unit9up:
                if (App.sendan.checkStatus(Sendan.UNIT9_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT9_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT9_UP, false);
                }
                break;
            case R.id.unit10up:
                if (App.sendan.checkStatus(Sendan.UNIT10_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT10_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT10_UP, false);
                }
                break;
            case R.id.unit7down:
                if (App.sendan.checkStatus(Sendan.UNIT7_DOWN)) {
                   MainActivity.sendToBt(Sendan.UNIT7_DOWN, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT7_DOWN, false);
                }
                break;
            case R.id.unit8down:
                if (App.sendan.checkStatus(Sendan.UNIT8_DOWN)) {
                   MainActivity.sendToBt(Sendan.UNIT8_DOWN, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT8_DOWN, false);
                }
                break;
            case R.id.unit9down:
                if (App.sendan.checkStatus(Sendan.UNIT9_DOWN)) {
                   MainActivity.sendToBt(Sendan.UNIT9_DOWN, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT9_DOWN, false);
                }
                break;
            case R.id.unit10down:
                if (App.sendan.checkStatus(Sendan.UNIT10_DOWN)) {
                   MainActivity.sendToBt(Sendan.UNIT10_DOWN, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT10_DOWN, false);
                }
                break;
            case R.id.storeupp1:
                if (App.sendan.checkStatus(Sendan.UNIT11_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT11_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT11_UP, false);
                }
                break;
            case R.id.storedownp1:
                if (App.sendan.checkStatus(Sendan.UNIT11_DOWN)) {
                   MainActivity.sendToBt(Sendan.UNIT11_DOWN, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT11_DOWN, false);
                }
                break;
        }
    }
}
