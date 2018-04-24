package lizhongbo.taxcalc.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import lizhongbo.taxcalc.R;
import lizhongbo.taxcalc.TaxRateManager;
import lizhongbo.taxcalc.app.MyApp;
import lizhongbo.taxcalc.beans.TaxRate;

public class TaxRateActivity extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemClickListener{
    private ListView mListView;
    private TaxRateAdapter mTaxRateAdapter;
    private EditText mStartTaxEdit;
    List<TaxRate> taxRateList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxrate);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mListView = findViewById(R.id.taxrate_list);
        mTaxRateAdapter = new TaxRateAdapter(this);
        Button addButton = findViewById(R.id.addtaxButton);
        addButton.setOnClickListener(this);

        taxRateList = SQLite.select().from(TaxRate.class).queryList();
        mTaxRateAdapter.setTaxRateList(taxRateList);
        mListView.setAdapter(mTaxRateAdapter);
        mListView.setOnItemClickListener(this);
        mStartTaxEdit = findViewById(R.id.startTaxEditText);
        mStartTaxEdit.setText(Integer.toString(TaxRateManager.startTaxIncome));
        Button saveStartTaxButton = findViewById(R.id.saveStartTaxButton);
        saveStartTaxButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addtaxButton:
                break;
            case R.id.saveStartTaxButton:
                String s = mStartTaxEdit.getText().toString();
                if(!TextUtils.isEmpty(s)){
                    SharedPreferences sharedPreferences = getSharedPreferences(MyApp.FILE_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt(MyApp.KEY_START_TAX, Integer.getInteger(s));
                    editor.commit();
                }

                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(taxRateList != null){
            TaxRate taxRate = taxRateList.get(position);
            Log.e("taxRate", "onItemClick: taxRate = "  + taxRate.level);
        }
    }
}
