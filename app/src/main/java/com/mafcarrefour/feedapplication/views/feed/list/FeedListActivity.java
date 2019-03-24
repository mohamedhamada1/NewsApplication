package com.mafcarrefour.feedapplication.views.feed.list;


import android.os.Bundle;
import android.widget.Toast;

import com.mafcarrefour.feedapplication.BR;
import com.mafcarrefour.feedapplication.R;
import com.mafcarrefour.feedapplication.callback.RetryCallback;
import com.mafcarrefour.feedapplication.databinding.ActivityFeedListBinding;

import com.mafcarrefour.feedapplication.models.Article;
import com.mafcarrefour.feedapplication.utils.RecyclerItemListener;
import com.mafcarrefour.feedapplication.views.feed.base.BaseActivity;
import com.mafcarrefour.feedapplication.views.feed.details.FeedDetailsActivity;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import sa.waqood.networkmodule.enums.Status;

/**
 * USING MVVM design pattern with databinding and life data to manage life cycle of activity
 * Using DI
 */

public class FeedListActivity extends BaseActivity<ActivityFeedListBinding, FeedListViewModel> implements RecyclerItemListener, RetryCallback {

    private FeedListViewModel viewModel;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    ActivityFeedListBinding viewBinding;
    @Inject
    FeedAdapter feedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = getViewDataBinding();
        fetchArticles();
        initRecycler();

    }

    private void initRecycler() {
        viewBinding.RVFeed.setLayoutManager(new LinearLayoutManager(this));
        viewBinding.RVFeed.setAdapter(feedAdapter);
        viewBinding.setCallback(this);
    }


    private void fetchArticles() {
        viewModel.fetchArticles().observe(this, articleContainerResource -> {
            viewBinding.setResource(articleContainerResource);
            if (articleContainerResource.status == Status.SUCCESS) {
                viewModel.setArticleContainer(articleContainerResource.data);
                feedAdapter.replace(articleContainerResource.data.getArticles());
            }
        });
    }

    @Override
    public FeedListViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, mViewModelFactory).get(FeedListViewModel.class);
        return viewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR._all;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_feed_list;
    }


    @Override
    public void itemClick(Object item) {
        // handle recycler item click
        startActivity(FeedDetailsActivity.getStartIntent(FeedListActivity.this, (Article) item));
    }

    @Override
    public void retry() {
        // in case any error we should show this error and enable user to retry load again
        fetchArticles();
    }
}
