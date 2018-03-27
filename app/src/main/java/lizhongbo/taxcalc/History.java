package lizhongbo.taxcalc;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by flying on 2018/3/27.
 */

@Entity
public class History {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "income")
    private int income;//收入

    @ColumnInfo(name = "Tax")
    private  int Tax; //税收

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getTax() {
        return Tax;
    }

    public void setTax(int tax) {
        Tax = tax;
    }
}
