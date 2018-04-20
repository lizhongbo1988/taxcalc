package lizhongbo.taxcalc;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = AppDatabase.class)
public class TaxRate extends BaseModel{
    @PrimaryKey
    private int level; //级别

    @Column
    private int income;//所得额

    @Column
    private double taxRate; //税率

    @Column
    private int quickDeduction; //快速扣除数

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public TaxRate(int level, int income, double taxRate, int quickDeduction){
        this.level = level;
        this.income = income;
        this.taxRate = taxRate;
        this.quickDeduction = quickDeduction;
    }

    public int getQuickDeduction() {
        return quickDeduction;
    }

    public void setQuickDeduction(int quickDeduction) {
        this.quickDeduction = quickDeduction;
    }
}
