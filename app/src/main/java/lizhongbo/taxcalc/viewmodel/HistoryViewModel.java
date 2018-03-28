package lizhongbo.taxcalc.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import lizhongbo.taxcalc.BasicApp;
import lizhongbo.taxcalc.db.entity.HistoryEntity;
import lizhongbo.taxcalc.db.entity.TaxEntity;

public class HistoryViewModel extends AndroidViewModel {
    private final MediatorLiveData<List<HistoryEntity>> mObservableHistory;
    public HistoryViewModel(@NonNull Application application) {
        super(application);
        mObservableHistory = new MediatorLiveData<>();
        mObservableHistory.setValue(null);
        LiveData<List<HistoryEntity>> history = ((BasicApp)application).getDatabase().historyDao().loadAllHistory();
        mObservableHistory.addSource(history,mObservableHistory::setValue);
    }

    public MediatorLiveData<List<HistoryEntity>> getObservableHistory() {
        return mObservableHistory;
    }
}
