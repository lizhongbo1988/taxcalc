package lizhongbo.taxcalc.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import lizhongbo.taxcalc.R;
import lizhongbo.taxcalc.beans.TaxRate;

public class TaxRateActivity extends AppCompatActivity {
    private ListView mListView;
    private TaxRateAdapter mTaxRateAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxrate);
        mListView = findViewById(R.id.taxrate_list);
        mTaxRateAdapter = new TaxRateAdapter(this);
    }
    @Override
    protected void onResume() {
        super.onResume();

        List<TaxRate> taxRateList= SQLite.select().from(TaxRate.class).queryList();
        mTaxRateAdapter.setTaxRateList(taxRateList);
        mListView.setAdapter(mTaxRateAdapter);
    }
}
