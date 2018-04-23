package lizhongbo.taxcalc.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import lizhongbo.taxcalc.R;
import lizhongbo.taxcalc.beans.History;

public class HistoryListAdapter extends BaseAdapter{
    private List<History> mHistoryList;
    private Context mContext;
    public HistoryListAdapter(Context context){
        mContext = context;
    }
    @Override
    public int getCount() {
        return mHistoryList == null?0:mHistoryList.size();
    }

    @Override
    public Object getItem(int position) {
        if(mHistoryList!= null){
            return mHistoryList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setHistoryList(List<History> historyList){
        this.mHistoryList = historyList;
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = View.inflate(mContext,R.layout.history_item, null);
            viewHolder = new ViewHolder();
            viewHolder.beforeTaxTextView = convertView.findViewById(R.id.beforeIncomeTextView);
            viewHolder.taxTextView = convertView.findViewById(R.id.taxTextView);
            viewHolder.afterTaxTextView = convertView.findViewById(R.id.afterIncomeTextView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        History history = mHistoryList.get(position);
        viewHolder.beforeTaxTextView.setText(history.income);
        viewHolder.taxTextView.setText(Double.toString(history.tax));
        viewHolder.afterTaxTextView.setText(Double.toString(history.income - history.tax));
        return convertView;
    }

    public static class ViewHolder{
        TextView beforeTaxTextView;
        TextView taxTextView;
        TextView afterTaxTextView;
    }
}
