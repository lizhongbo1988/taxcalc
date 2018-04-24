package lizhongbo.taxcalc.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import lizhongbo.taxcalc.AppDatabase;

@Table(database = AppDatabase.class)
public class TaxRate extends BaseModel implements Parcelable{

    @PrimaryKey
    public int level; //级别

    @Column
    public int start;//起始

    @Column
    public int end;//中止

    @Column
    public double taxRate; //税率

    @Column
    public int quickDeduction; //快速扣除数


    public TaxRate(int level, int start, int end,double taxRate, int quickDeduction){
        this.level = level;
        this.start = start;
        this.end = end;
        this.taxRate = taxRate;
        this.quickDeduction = quickDeduction;
    }
    public TaxRate(){

    }

    protected TaxRate(Parcel in) {
        level = in.readInt();
        start = in.readInt();
        end = in.readInt();
        taxRate = in.readDouble();
        quickDeduction = in.readInt();
    }

    public static final Creator<TaxRate> CREATOR = new Creator<TaxRate>() {
        @Override
        public TaxRate createFromParcel(Parcel in) {
            return new TaxRate(in);
        }

        @Override
        public TaxRate[] newArray(int size) {
            return new TaxRate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(level);
        dest.writeInt(start);
        dest.writeInt(end);
        dest.writeDouble(taxRate);
        dest.writeInt(quickDeduction);
    }
}
