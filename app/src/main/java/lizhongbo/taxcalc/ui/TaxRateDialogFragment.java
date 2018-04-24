package lizhongbo.taxcalc.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import lizhongbo.taxcalc.R;
import lizhongbo.taxcalc.beans.TaxRate;

public class TaxRateDialogFragment extends DialogFragment implements View.OnClickListener {
    TaxRate taxRate;
    private EditText levelEditText;
    private EditText startEditText;
    private EditText endEditText;
    private EditText taxRateEditText;
    private EditText quickEditText;

    private Button delButton;
    private Button saveButton;

    private OnChangeListener mChangeListener;
    public interface OnChangeListener{
        void delTax(TaxRate taxRate);
        void saveTax(TaxRate taxRate);
    }

    public void setOnChangeListener(OnChangeListener onChangeListener){
        mChangeListener = onChangeListener;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_taxrate, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            taxRate = bundle.getParcelable("taxRate");
        }else{
            taxRate = new TaxRate();
        }
        levelEditText = view.findViewById(R.id.levelEditText);
        startEditText = view.findViewById(R.id.startTaxEditText);
        endEditText = view.findViewById(R.id.endTaxEditText);
        taxRateEditText = view.findViewById(R.id.taxRateEditText);
        quickEditText = view.findViewById(R.id.quickEditText);
        delButton = view.findViewById(R.id.delTaxrateButton);
        delButton.setOnClickListener(this);
        saveButton = view.findViewById(R.id.saveTaxButton);
        saveButton.setOnClickListener(this);
        if (taxRate != null) {
            levelEditText.setText(Integer.toString(taxRate.level));
            startEditText.setText(Integer.toString(taxRate.start));
            endEditText.setText(Integer.toString(taxRate.end));
            taxRateEditText.setText(Double.toString(taxRate.taxRate));
            quickEditText.setText(Integer.toString(taxRate.quickDeduction));
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delTaxrateButton:
                if(mChangeListener != null){
                    mChangeListener.delTax(taxRate);
                }
            case R.id.saveTaxButton:
                if(mChangeListener != null){
                    mChangeListener.saveTax(taxRate);
                }
                break;
            default:
                break;
        }
    }
}
