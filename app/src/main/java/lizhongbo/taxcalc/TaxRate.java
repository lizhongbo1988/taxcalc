package lizhongbo.taxcalc;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = AppDatabase.class)
public class TaxRate extends BaseModel{
    @PrimaryKey
    int level; //级别

    @Column
    int income;//所得额

    @Column
    double taxRate; //税率

    @Column
    int quickDeduction; //快速扣除数


    public TaxRate(int level, int income, double taxRate, int quickDeduction){
        this.level = level;
        this.income = income;
        this.taxRate = taxRate;
        this.quickDeduction = quickDeduction;
    }
    public TaxRate(){

    }
}
