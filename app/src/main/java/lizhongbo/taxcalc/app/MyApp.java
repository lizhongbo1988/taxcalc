package lizhongbo.taxcalc.app;

import android.app.Application;
import android.content.SharedPreferences;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import lizhongbo.taxcalc.TaxRateManager;
import lizhongbo.taxcalc.beans.TaxRate;

public class MyApp extends Application {

    public static final String FILE_NAME = "taxrate";
    public static final String KEY_START_TAX = "start_tax";
     @Override
    public void onCreate(){
         super.onCreate();
         FlowManager.init(this);
         //读取起征点
         SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
         TaxRateManager.startTaxIncome = sharedPreferences.getInt(KEY_START_TAX, 3500);
         /*第一次启动APP时，如果税率表为空，则添加默认税率到数据库*/
         List<TaxRate> taxRates = SQLite.select().from(TaxRate.class).queryList();
         if(taxRates == null || taxRates .size() == 0){
             TaxRateManager.setDefaultTaxRate();
         }
     }
}
