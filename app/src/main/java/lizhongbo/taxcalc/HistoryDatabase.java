package lizhongbo.taxcalc;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {History.class}, version = 1)
public abstract class HistoryDatabase extends RoomDatabase {
    public abstract HistoryDao historyDao();
}
