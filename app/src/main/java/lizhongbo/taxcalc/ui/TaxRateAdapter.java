package lizhongbo.taxcalc.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

import lizhongbo.taxcalc.R;
import lizhongbo.taxcalc.beans.TaxRate;

public class TaxRateAdapter extends BaseAdapter {
    private List<TaxRate> taxRateList ;
    private Context mContext;

    public TaxRateAdapter(Context context){
        mContext = context;
    }
    //设置税率
    public void setTaxRateList(List<TaxRate> taxRateList) {
        this.taxRateList = taxRateList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return taxRateList != null ? taxRateList.size(): 0;
    }

    @Override
    public Object getItem(int position) {
        return taxRateList != null ? taxRateList.get(position): null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.taxrate_item, null);
            viewHolder = new ViewHolder();
            viewHolder.levelTextView = convertView.findViewById(R.id.levelTextView);
            viewHolder.startTextView = convertView.findViewById(R.id.startTextView);
            viewHolder.endTextView = convertView.findViewById(R.id.endTextView);
            viewHolder.taxRateTextView = convertView.findViewById(R.id.taxrateTextView);
            viewHolder.quickDeductionTextView = convertView.findViewById(R.id.quickDeductionTextView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        TaxRate taxRate = taxRateList.get(position);
        viewHolder.levelTextView.setText(Integer.toString(taxRate.level));
        viewHolder.startTextView.setText(Integer.toString(taxRate.start));
        viewHolder.endTextView.setText(Integer.toString(taxRate.end));
        if(taxRate.end == Integer.MAX_VALUE){
            viewHolder.endTextView.setText("");
            viewHolder.startTextView.setTextSize(15);
            viewHolder.startTextView.setText(Integer.toString(taxRate.start) + " 以上");
        }
        viewHolder.taxRateTextView.setText(Double.toString(taxRate.taxRate));
        viewHolder.quickDeductionTextView.setText(Integer.toString(taxRate.quickDeduction));
        return convertView;
    }

    public class ViewHolder{
        TextView levelTextView;
        TextView startTextView;
        TextView endTextView;
        TextView taxRateTextView;
        TextView quickDeductionTextView;
    }
}
