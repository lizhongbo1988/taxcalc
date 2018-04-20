package lizhongbo.taxcalc;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.Model;

import java.util.jar.Attributes;

@Table(database = AppDatabase.class)
public class History extends BaseModel{
    @PrimaryKey
    int id;

    @Column(name = "income")
    int income;

    @Column(name = "tax")
    double tax;
}
