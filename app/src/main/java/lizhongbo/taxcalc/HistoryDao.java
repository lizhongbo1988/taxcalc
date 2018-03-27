package lizhongbo.taxcalc;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;


/**
 * 李中博 on 2018/3/27.
 * 历史记录接口类
 */
@Dao
public interface HistoryDao {
    @Query("SELECT * FROM History")
    List<History> getAll();

    @Insert
    void insert(History history);

    @Delete
    void deleteHistory(History history);
}
