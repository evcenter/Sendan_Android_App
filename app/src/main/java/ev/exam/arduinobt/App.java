package ev.exam.arduinobt;

import android.app.Application;

/**
 * Created by pccrazy on 2/17/16.
 */
public class App extends Application {
    static Sendan sendan;
    @Override
    public void onCreate() {
        super.onCreate();
        sendan=new Sendan();
    }

}
