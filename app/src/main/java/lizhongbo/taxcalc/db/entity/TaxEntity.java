package lizhongbo.taxcalc.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lizhongbo.taxcalc.model.Tax;

@Entity(tableName = "taxs")
public class TaxEntity implements Tax {
    @PrimaryKey
    private int level;

    @ColumnInfo(name = "start_price")
    private int startPrice;

    @ColumnInfo(name = "percent")
    private double percent;

    @ColumnInfo(name = "reduced")
    private int reduced;

    public TaxEntity(int level, int startPrice, double percent, int reduced){
        this.level = level;
        this.startPrice = startPrice;
        this.percent = percent;
        this.reduced = reduced;
    }
    @Override
    public int GetLevel() {
        return level;
    }

    public void SetLevel(int level){
        this.level = level;
    }
    @Override
    public int GetStartPrice() {
        return startPrice;
    }

    public void SetStartPrice(int startPrice){
        this.startPrice = startPrice;
    }


    @Override
    public double GetPercent() {
        return percent;
    }
    public void SetPercent(double percent){
        this.percent = percent;
    }
    @Override
    public int GetReduced() {
        return reduced;
    }

    public void SetReduced(int reduced){
        this.reduced = reduced;
    }
}
