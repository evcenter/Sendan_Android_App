package ev.exam.arduinobt;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Phase_two extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton unit17up,unit18up,unit19up,unit20up,storeup,storedown,unit17down,unit18down,unit19down,unit20down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_two);
        unit17up=(FloatingActionButton)findViewById(R.id.unit17up);
        unit18up=(FloatingActionButton)findViewById(R.id.unit18up);
        unit19up=(FloatingActionButton)findViewById(R.id.unit19up);
        unit20up=(FloatingActionButton)findViewById(R.id.unit20up);
        unit17down=(FloatingActionButton)findViewById(R.id.unit17down);
        unit18down=(FloatingActionButton)findViewById(R.id.unit18down);
        unit19down=(FloatingActionButton)findViewById(R.id.unit19down);
        unit20down=(FloatingActionButton)findViewById(R.id.unit20down);
        storeup=(FloatingActionButton)findViewById(R.id.storeupp2);
        storedown=(FloatingActionButton)findViewById(R.id.storedownp2);
        unit17up.setOnClickListener(this);
        unit18up.setOnClickListener(this);
        unit19up.setOnClickListener(this);
        unit20up.setOnClickListener(this);
        unit17down.setOnClickListener(this);
        unit18down.setOnClickListener(this);
        unit19down.setOnClickListener(this);
        unit20down.setOnClickListener(this);
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
                            changeStatus(unit17up, Sendan.UNIT7_UP);
                            changeStatus(unit18up, Sendan.UNIT8_UP);
                            changeStatus(unit19up, Sendan.UNIT9_UP);
                            changeStatus(unit20up, Sendan.UNIT10_UP);
                            changeStatus(unit17down, Sendan.UNIT7_DOWN);
                            changeStatus(unit18down, Sendan.UNIT8_DOWN);
                            changeStatus(unit19down, Sendan.UNIT9_DOWN);
                            changeStatus(unit20down, Sendan.UNIT10_DOWN);
                            changeStatus(storeup, Sendan.UNIT11_UP);
                            changeStatus(storedown, Sendan.UNIT11_DOWN);

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
            case R.id.unit17up:
                if (App.sendan.checkStatus(Sendan.UNIT17_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT17_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT17_UP, false);
                }
                break;
            case R.id.unit18up:
                if (App.sendan.checkStatus(Sendan.UNIT18_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT18_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT18_UP, false);
                }
                break;
            case R.id.unit19up:
                if (App.sendan.checkStatus(Sendan.UNIT19_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT19_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT19_UP, false);
                }
                break;
            case R.id.unit10up:
                if (App.sendan.checkStatus(Sendan.UNIT20_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT20_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT20_UP, false);
                }
                break;
            case R.id.unit7down:
                if (App.sendan.checkStatus(Sendan.UNIT17_DOWN)) {
                   MainActivity.sendToBt(Sendan.UNIT17_DOWN, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT17_DOWN, false);
                }
                break;
            case R.id.unit18down:
                if (App.sendan.checkStatus(Sendan.UNIT18_DOWN)) {
                   MainActivity.sendToBt(Sendan.UNIT18_DOWN, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT18_DOWN, false);
                }
                break;
            case R.id.unit19down:
                if (App.sendan.checkStatus(Sendan.UNIT19_DOWN)) {
                   MainActivity.sendToBt(Sendan.UNIT19_DOWN, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT19_DOWN, false);
                }
                break;
            case R.id.unit20down:
                if (App.sendan.checkStatus(Sendan.UNIT20_DOWN)) {
                   MainActivity.sendToBt(Sendan.UNIT20_DOWN, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT20_DOWN, false);
                }
                break;
            case R.id.storeupp1:
                if (App.sendan.checkStatus(Sendan.UNIT16_UP)) {
                   MainActivity.sendToBt(Sendan.UNIT16_UP, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT16_UP, false);
                }
                break;
            case R.id.storedownp1:
                if (App.sendan.checkStatus(Sendan.UNIT16_DOWN)) {
                   MainActivity.sendToBt(Sendan.UNIT16_DOWN, true);
                } else {
                   MainActivity.sendToBt(Sendan.UNIT16_DOWN, false);
                }
                break;
        }
    }

}
