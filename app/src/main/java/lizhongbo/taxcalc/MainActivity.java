package lizhongbo.taxcalc;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AppDatabase mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                mDatabase = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "calc").build();
            }
        }).start();

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        Button calcButton = findViewById(R.id.calcBtn);
        calcButton.setOnClickListener(this);
//        FloatingActionButton fab_setting = (FloatingActionButton) findViewById(R.id.fab_setting);
//        fab_setting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        FloatingActionButton fab_history = (FloatingActionButton) findViewById(R.id.fab_history);
//        fab_history.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "history", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calcBtn:
                Log.e("haha", "onClick: calcBtn" );

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        History history = new History();
                        history.setIncome(3500);
                        history.setTax(200);
                        mDatabase.historyDao().insert(history);
                        List<History> historyList = mDatabase.historyDao().getAll();
                        for(History history1: historyList){
                            Log.e("hjhhh", "historyList income = " + history1.getIncome() + "  Tax = " + history1.getTax());
                        }
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
