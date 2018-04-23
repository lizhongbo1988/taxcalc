package lizhongbo.taxcalc.beans;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import lizhongbo.taxcalc.AppDatabase;

@Table(database = AppDatabase.class)
public class History extends BaseModel{
    @PrimaryKey(autoincrement = true)
    public int id;

    @Column(name = "income")
    public int income;

    @Column(name = "tax")
    public double tax;

    public History(){
    }
    public History(int income, double tax){
        this.income = income;
        this.tax = tax;
    }
}
