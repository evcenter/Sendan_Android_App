package ev.exam.arduinobt;


import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;
import java.util.UUID;


//20:15:02:13:13:94
public class MainActivity extends AppCompatActivity{
    JSONArray ja;
    BluetoothAdapter mBluetoothAdapter;
    BluetoothSocket mmSocket;
    BluetoothDevice mmDevice;
    static OutputStream mmOutputStream;
    static InputStream mmInputStream;
    Thread workerThread;
    byte[] readBuffer;
    int readBufferPosition;
    int counter;
    volatile boolean stopWorker;
    List<String> led;
    List<String> pins;
    int to=0;
    private int mode=0;
    private int frompin;

    FloatingActionButton bt,cars,random,on_off,p1,p2,p3,p4,p1a,p2a,p3s,p4s;
    TextView polyvard,park,petrolStation,store_left,store_right,shop_right,shop_left,exhibits,autoworld,constructoinworld,mosq;
    private Context context;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
context=this;





        bt = (FloatingActionButton) findViewById(R.id.bt);
        cars = (FloatingActionButton) findViewById(R.id.cars);
        random = (FloatingActionButton) findViewById(R.id.random);
        on_off = (FloatingActionButton) findViewById(R.id.on_off);
        p1 = (FloatingActionButton) findViewById(R.id.p1);
        p2 = (FloatingActionButton) findViewById(R.id.p2);
        p3 = (FloatingActionButton) findViewById(R.id.p3);
        p4 = (FloatingActionButton) findViewById(R.id.p4);

        p1a = (FloatingActionButton) findViewById(R.id.p1a);
        p2a = (FloatingActionButton) findViewById(R.id.p2a);
        p3s = (FloatingActionButton) findViewById(R.id.p3s);
        p4s = (FloatingActionButton) findViewById(R.id.p4s);
        polyvard=(TextView)findViewById(R.id.polyvard);
        store_left=(TextView)findViewById(R.id.store_left);
        store_right=(TextView)findViewById(R.id.store_right);
        park=(TextView)findViewById(R.id.park);
        petrolStation=(TextView)findViewById(R.id.pstationp3);
        shop_left=(TextView)findViewById(R.id.shops_left);
        shop_right=(TextView)findViewById(R.id.shops_right);
        exhibits=(TextView)findViewById(R.id.exibites);
        autoworld=(TextView)findViewById(R.id.automotiveworld);
        constructoinworld=(TextView)findViewById(R.id.constructionworld);
        mosq=(TextView)findViewById(R.id.mosque);



        /** floating button actions from right*/
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finding bt", Toast.LENGTH_SHORT).show();
                findBT();


            }
        });
        cars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finding bt", Toast.LENGTH_SHORT).show();
                if (App.sendan.checkStatus(Sendan.ALL_CARS)) {
                    sendToBt(Sendan.ALL_CARS, false);
                } else {
                    sendToBt(Sendan.ALL_CARS, true);
                }


            }
        });
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finding bt", Toast.LENGTH_SHORT).show();



            }
        });
        on_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finding bt", Toast.LENGTH_SHORT).show();
                if (App.sendan.checkStatus(Sendan.ALL)) {
                    sendToBt(Sendan.ALL, false);
                } else {
                    sendToBt(Sendan.ALL, true);
                }


            }
        });

        /** phases button actions from left*/
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finding bt", Toast.LENGTH_SHORT).show();
                if (App.sendan.checkStatus(Sendan.PHASE1)) {
                    sendToBt(Sendan.PHASE1, false);
                } else {
                    sendToBt(Sendan.PHASE1, true);
                }



            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finding bt", Toast.LENGTH_SHORT).show();

                if (App.sendan.checkStatus(Sendan.PHASE2)) {
                    sendToBt(Sendan.PHASE2, false);
                } else {
                    sendToBt(Sendan.PHASE2, true);
                }

            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finding bt", Toast.LENGTH_SHORT).show();

                if (App.sendan.checkStatus(Sendan.PHASE3)) {
                    sendToBt(Sendan.PHASE3, false);
                } else {
                    sendToBt(Sendan.PHASE3, true);
                }

            }
        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finding bt", Toast.LENGTH_SHORT).show();
                if (App.sendan.checkStatus(Sendan.PHASE4)) {
                    sendToBt(Sendan.PHASE4, false);
                } else {
                    sendToBt(Sendan.PHASE4, true);
                }


            }
        });


        polyvard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (App.sendan.checkStatus(Sendan.POLYVARD)) {
                    sendToBt(Sendan.POLYVARD, false);
                } else {
                    sendToBt(Sendan.POLYVARD, true);
                }
            }
        });
        petrolStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (App.sendan.checkStatus(Sendan.PETROL_STATION)) {
                    sendToBt(Sendan.PETROL_STATION, false);
                } else {
                    sendToBt(Sendan.PETROL_STATION, true);
                }
            }
        });
        store_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (App.sendan.checkStatus(Sendan.UNIT5_DOWN|Sendan.UNIT5_UP)) {
                    sendToBt((Sendan.UNIT5_DOWN|Sendan.UNIT5_UP), false);
                } else {
                    sendToBt((Sendan.UNIT5_DOWN|Sendan.UNIT5_UP), true);
                }
            }
        });
        store_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (App.sendan.checkStatus(Sendan.UNIT4_DOWN|Sendan.UNIT4_UP)) {
                    sendToBt((Sendan.UNIT4_DOWN|Sendan.UNIT4_UP), false);
                } else {
                    sendToBt((Sendan.UNIT4_DOWN|Sendan.UNIT4_UP), true);
                }
            }
        });
        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (App.sendan.checkStatus(Sendan.PARK)) {
                    sendToBt(Sendan.PARK, false);
                } else {
                    sendToBt(Sendan.PARK, true);
                }
            }
        });

        /** not done**/
        shop_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (App.sendan.checkStatus(Sendan.UNIT27_UP)) {
                    sendToBt(Sendan.UNIT27_UP, false);
                } else {
                    sendToBt(Sendan.UNIT27_UP, true);
                }
            }
        });
        shop_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (App.sendan.checkStatus(Sendan.UNIT29_UP)) {
                    sendToBt(Sendan.UNIT29_UP, false);
                } else {
                    sendToBt(Sendan.UNIT29_UP, true);
                }
            }
        });
        exhibits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (App.sendan.checkStatus(Sendan.UNIT1_RIGHT|Sendan.UNIT2_RIGHT)) {
                    sendToBt(Sendan.UNIT1_RIGHT|Sendan.UNIT2_RIGHT, false);
                } else {
                    sendToBt(Sendan.UNIT1_RIGHT|Sendan.UNIT2_RIGHT, true);
                }
            }
        });
        autoworld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (App.sendan.checkStatus(Sendan.AUTOMOBILE_WORLD)) {
                    sendToBt(Sendan.AUTOMOBILE_WORLD, false);
                } else {
                    sendToBt(Sendan.AUTOMOBILE_WORLD, true);
                }
            }
        });
        constructoinworld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (App.sendan.checkStatus(Sendan.CONSTRUCTION_WORLD)) {
                    sendToBt(Sendan.CONSTRUCTION_WORLD, false);
                } else {
                    sendToBt(Sendan.CONSTRUCTION_WORLD, true);
                }
            }
        });
        mosq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (App.sendan.checkStatus(Sendan.MOSQE)) {
                    sendToBt(Sendan.MOSQE, false);
                } else {
                    sendToBt(Sendan.MOSQE, true);
                }
            }
        });


        p1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Phase_one.class));
            }
        });
        p2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Phase_two.class));
            }
        });
        p3s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Phase_three.class));
            }
        });
        p4s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Phase_four.class));
            }
        });



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
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    void changeStatus(FloatingActionButton frameLayout,long Target,int onid,int offid){

        try{
            if(App.sendan.checkStatus(Target)){

                frameLayout.setBackground(ResourcesCompat.getDrawable(getResources(), onid, null));

            }else{
                frameLayout.setBackground(ResourcesCompat.getDrawable(getResources(), offid, null));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    private void sendData(String data) {
        String msg = data+"\n";
        try {
            mmOutputStream.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("bt", "Data Sent "+msg);
    }


    public static void sendToBt(long target,boolean i){
        byte[] buffer;

        if(i==true){
            buffer=App.sendan.switchOn(target);
        }else{
            buffer=App.sendan.switchOff(target);
        }
        try {
            mmOutputStream.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    void findBT()
    {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter == null)
        {
            Log.d("bt","No bluetooth adapter available");
        }

        if(!mBluetoothAdapter.isEnabled())
        {
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth, 0);
        }

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        if(pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices)
            {
                if(device.getAddress().equals("20:15:02:13:13:94"))
                {
                    mmDevice = device;
                    try {
                        openBT();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        Log.d("bt", " bluetooth device available");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    void openBT() throws IOException
    {
        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard SerialPortService ID
        mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
        mmSocket.connect();
        mmOutputStream = mmSocket.getOutputStream();
        mmInputStream = mmSocket.getInputStream();

        Toast.makeText(MainActivity.this,"Connected",Toast.LENGTH_SHORT).show();
        bt.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.network_bt_on, null));
        beginListenForData();

        Log.d("bt", "Bluetooth Opened");
    }

    void beginListenForData()
    {
        final Handler handler = new Handler();
        final byte delimiter = 10; //This is the ASCII code for a newline character

        stopWorker = false;
        readBufferPosition = 0;
        readBuffer = new byte[1024];
        workerThread = new Thread(new Runnable()
        {
            public void run()
            {
                while(!Thread.currentThread().isInterrupted() && !stopWorker)
                {
                    try
                    {
                        int bytesAvailable = mmInputStream.available();
                        if(bytesAvailable > 0) {
                            byte[] packetBytes = new byte[bytesAvailable];
                            mmInputStream.read(packetBytes);
                            if(packetBytes.length==10){
                                App.sendan.setStatus(packetBytes);
                            }



                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    changeStatus(polyvard, Sendan.POLYVARD);
                                    changeStatus(park, Sendan.PARK);
                                    changeStatus(petrolStation, Sendan.PETROL_STATION);
                                    changeStatus(store_left, (Sendan.UNIT5_DOWN|Sendan.UNIT5_UP));
                                    changeStatus(store_right, (Sendan.UNIT4_DOWN|Sendan.UNIT4_UP));
                                    changeStatus(exhibits,(Sendan.UNIT1_RIGHT|Sendan.UNIT2_RIGHT));

                                    changeStatus(autoworld,(Sendan.AUTOMOBILE_WORLD));
                                    changeStatus(constructoinworld,Sendan.CONSTRUCTION_WORLD);
                                    changeStatus(mosq,Sendan.MOSQE);

                                    changeStatus(shop_right,Sendan.UNIT29_UP);
                                    changeStatus(shop_left,Sendan.UNIT27_UP);
                                    changeStatus(shop_left,Sendan.UNIT27_UP);
                                    changeStatus(cars,Sendan.ALL_CARS,R.drawable.car_on,R.drawable.car_off);
                                    changeStatus(on_off,Sendan.ALL,R.drawable.car_on,R.drawable.car_off);
//                                    changeStatus(cars, Sendan.ALL_CARS);
                                }
                            });
                            Log.d("bt", "from bt " + String.valueOf(packetBytes) + " lemgth " + packetBytes.length);

                        }
                    }
                    catch (IOException ex)
                    {
                        stopWorker = true;
                    }
                }
            }
        });

        workerThread.start();
    }

    void closeBT() throws IOException
    {
        stopWorker = true;
        mmOutputStream.close();
        mmInputStream.close();
        mmSocket.close();
        Log.d("bt","Bluetooth Closed");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onResume() {

        super.onResume();


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
