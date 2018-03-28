package lizhongbo.taxcalc;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import java.util.List;

import lizhongbo.taxcalc.db.AppDatabase;
import lizhongbo.taxcalc.db.entity.HistoryEntity;
import lizhongbo.taxcalc.db.entity.TaxEntity;

/**
 * Repository handling the work with products and comments.
 */
public class DataRepository {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;
    private MediatorLiveData<List<TaxEntity>> mObservableTax;

    private DataRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableTax = new MediatorLiveData<>();

        mObservableTax.addSource(mDatabase.taxDao().loadAllTaxs(),
                taxEntities -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableTax.postValue(taxEntities);
                    }
                });
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the list of products from the database and get notified when the data changes.
     */
    public LiveData<List<TaxEntity>> getTaxs() {
        return mObservableTax;
    }


    public LiveData<List<HistoryEntity>> loadHistory() {
        return mDatabase.historyDao().loadAllHistory();
    }
}
