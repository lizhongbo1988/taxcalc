package lizhongbo.taxcalc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lizhongbo.taxcalc.ItemFragment.OnListFragmentInteractionListener;

import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<HistoryContent.HistoryItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<HistoryContent.HistoryItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.minComeView.setText(mValues.get(position).income);
        holder.mTaxView.setText(mValues.get(position).tax);
//
//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mYingfaView;
        public final TextView minComeView;
        public final TextView mTaxView;
        public HistoryContent.HistoryItem mItem;

        public ViewHolder(View view) {
            super(view);
            minComeView = (TextView) view.findViewById(R.id.incomeTextView);
            mTaxView = (TextView) view.findViewById(R.id.TaxTextView);
            mYingfaView = (TextView) view.findViewById(R.id.yingfaTextView);
        }
    }
}
