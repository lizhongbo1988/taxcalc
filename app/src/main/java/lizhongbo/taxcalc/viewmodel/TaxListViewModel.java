package lizhongbo.taxcalc.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import java.util.Base64;
import java.util.List;

import lizhongbo.taxcalc.BasicApp;
import lizhongbo.taxcalc.db.entity.TaxEntity;

public class TaxListViewModel extends AndroidViewModel {

    private final MediatorLiveData<List<TaxEntity>> mObservableTaxs;

    public TaxListViewModel(@NonNull Application application) {
        super(application);
        mObservableTaxs = new MediatorLiveData<>();
        mObservableTaxs.setValue(null);
        LiveData<List<TaxEntity>> taxs = ((BasicApp)application).getDatabase().taxDao().loadAllTaxs();
        mObservableTaxs.addSource(taxs, mObservableTaxs::setValue);
    }

    public MediatorLiveData<List<TaxEntity>> getTaxs() {
        return mObservableTaxs;
    }
}
