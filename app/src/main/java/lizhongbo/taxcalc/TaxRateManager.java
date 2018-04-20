package lizhongbo.taxcalc;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class TaxRateManager {

    /*起征点*/
    public static int startTaxIncome = 3500;

    /*恢复默认税率*/
    public static void setDefaultTaxRate(){
        TaxRate level1 = new TaxRate(1, 1500, 0.03, 0);
        level1.insert();
        TaxRate level2 = new TaxRate(2, 4500, 0.1, 105);
        level2.insert();
        TaxRate level3 = new TaxRate(3, 9000, 0.2, 555);
        level3.insert();
        TaxRate level4 = new TaxRate(4, 35000, 0.25, 1005);
        level4.insert();
        TaxRate level5 = new TaxRate(5, 55000, 0.30, 2755);
        level5.insert();
        TaxRate level6 = new TaxRate(6, 80000, 0.35, 5505);
        level6.insert();
        TaxRate level7 = new TaxRate(7, 80000, 0.45, 13505);
        level7.insert();
    }


    /*计算税率*/
    public static double CalcTaxRate(int beforeTaxIncome){
        List<TaxRate> taxRates = SQLite.select().from(TaxRate.class).queryList();
        int taxIncome = beforeTaxIncome - startTaxIncome;
        if(taxIncome < taxRates.get(0).getIncome()){
            return 0;
        }
        if(taxIncome > taxRates.get(taxRates.size() - 1).getIncome()){
            TaxRate taxRate = taxRates.get(taxRates.size() - 1);
            return taxRate.getIncome() * taxRate.getTaxRate() - taxRate.getQuickDeduction();
        }

        for(int i = taxRates.size() - 2; i > 0; i--){
            if(taxIncome > taxRates.get(i).getIncome()){
                return taxRates.get(i).getIncome() * taxRates.get(i).getTaxRate() - taxRates.get(i).getQuickDeduction();
            }
        }
        return 0;
    }
}
