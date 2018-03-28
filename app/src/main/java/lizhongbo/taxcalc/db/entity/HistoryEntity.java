package lizhongbo.taxcalc.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lizhongbo.taxcalc.model.History;

@Entity(tableName = "history")
public class HistoryEntity implements History {

    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "before")
    private int beforeTaxIncome;

    @ColumnInfo(name = "tax")
    private double tax;
    @ColumnInfo(name = "after")
    private double afterTaxIncome;
    @Override
    public int GetIncome() {
        return 0;
    }

    @Override
    public int GetTax() {
        return 0;
    }

    @Override
    public int GetAfterTaxIncome() {
        return 0;
    }
}
