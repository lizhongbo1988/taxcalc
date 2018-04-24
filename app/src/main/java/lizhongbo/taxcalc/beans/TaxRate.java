package lizhongbo.taxcalc.beans;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import lizhongbo.taxcalc.AppDatabase;

@Table(database = AppDatabase.class)
public class TaxRate extends BaseModel{

    @PrimaryKey
    public int start;//起始

    @Column
    public int end;//中止

    @Column
    public double taxRate; //税率

    @Column
    public int quickDeduction; //快速扣除数


    public TaxRate(int start, int end,double taxRate, int quickDeduction){
        this.start = start;
        this.end = end;
        this.taxRate = taxRate;
        this.quickDeduction = quickDeduction;
    }
    public TaxRate(){

    }
}
