package lizhongbo.taxcalc;

import android.app.Application;

import lizhongbo.taxcalc.db.AppDatabase;

public class BasicApp extends Application {
    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, mAppExecutors);
    }
}
