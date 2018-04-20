package lizhongbo.taxcalc;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class MyApp extends Application {

//    /**起征点*/
//    public static int startTaxIncome = 3500;
     @Override
    public void onCreate(){
         super.onCreate();
         FlowManager.init(this);
         /*第一次启动APP时，如果税率表为空，则添加默认税率到数据库*/
         List<TaxRate> taxRates = SQLite.select().from(TaxRate.class).queryList();
         if(taxRates == null || taxRates .size() == 0){
             TaxRateManager.setDefaultTaxRate();
         }
     }
}
