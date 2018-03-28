package lizhongbo.taxcalc.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import lizhongbo.taxcalc.db.entity.HistoryEntity;

@Dao
public interface HistoryDao {
    @Query("SELECT * FROM history")
    LiveData<List<HistoryEntity>> loadAllHistory();

    @Insert
    void insert(HistoryEntity historyEntity);
}
