package lizhongbo.taxcalc.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import lizhongbo.taxcalc.db.entity.TaxEntity;

@Dao
public interface TaxDao {
    @Query("SELECT * FROM TAXS")
    LiveData<List<TaxEntity>> loadAllTaxs();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TaxEntity taxEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<TaxEntity> taxs);
}
