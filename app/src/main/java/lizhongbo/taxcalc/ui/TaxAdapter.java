package lizhongbo.taxcalc.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import lizhongbo.taxcalc.model.Tax;

public class TaxAdapter extends RecyclerView.Adapter<TaxAdapter.TaxViewHolder>{
    List<? extends Tax> mTaxList;


    public void setProductList(final List<? extends Tax> taxList) {
        if (mTaxList == null) {
            mTaxList = taxList;
            notifyItemRangeInserted(0, taxList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return taxList.size();
                }

                @Override
                public int getNewListSize() {
                    return taxList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return mTaxList.get(oldItemPosition).GetLevel() ==
                            taxList.get(newItemPosition).GetLevel();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Tax newTax = taxList.get(newItemPosition);
                    Tax oldTax = mTaxList.get(oldItemPosition);
                    return newTax.GetLevel() == oldTax.GetLevel()
                            && newTax.GetStartPrice() == oldTax.GetStartPrice()
                            && newTax.GetReduced() == oldTax.GetReduced()
                            && Double.compare(newTax.GetPercent(), oldTax.GetPercent()) == 0;
                }
            });
            mTaxList = taxList;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public TaxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TaxItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.tax_item,
                        parent, false);
        return new TaxViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(TaxViewHolder holder, int position) {
        holder.binding.setTax(mTaxList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mTaxList == null ? 0 : mTaxList.size();
    }

    static class TaxViewHolder extends RecyclerView.ViewHolder {

        final TaxItemBinding binding;

        public TaxViewHolder(TaxItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
