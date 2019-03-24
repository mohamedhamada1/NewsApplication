package com.mafcarrefour.feedapplication.views.feed.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mafcarrefour.feedapplication.R;
import com.mafcarrefour.feedapplication.databinding.RowFeedBinding;
import com.mafcarrefour.feedapplication.models.Article;
import com.mafcarrefour.feedapplication.utils.DataBoundListAdapter;
import com.mafcarrefour.feedapplication.utils.DataBoundViewHolder;
import com.mafcarrefour.feedapplication.utils.RecyclerItemListener;

import java.util.List;

import androidx.databinding.DataBindingUtil;


public class FeedAdapter extends DataBoundListAdapter<Article, RowFeedBinding> {

    RecyclerItemListener recyclerItemListener;
    Context context;

    public FeedAdapter(Context context, RecyclerItemListener recyclerItemListener) {
        this.recyclerItemListener = recyclerItemListener;
        this.context = context;
    }

    @Override
    protected RowFeedBinding createBinding(ViewGroup parent) {
        RowFeedBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_feed,
                parent,
                false);
        binding.setCallback(recyclerItemListener);
        return binding;
    }

    public void replace(List<Article> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    protected void bind(DataBoundViewHolder<RowFeedBinding> holder, RowFeedBinding binding, Article item) {
        binding.setItem(item);
    }


    @Override
    protected boolean areItemsTheSame(Article oldItem, Article newItem) {
        return false;
    }

    @Override
    protected boolean areContentsTheSame(Article oldItem, Article newItem) {
        return false;
    }

}
