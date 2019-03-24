package com.mafcarrefour.feedapplication.views.feed.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.mafcarrefour.feedapplication.BR;
import com.mafcarrefour.feedapplication.R;
import com.mafcarrefour.feedapplication.databinding.ActivityFeedDetailsBinding;
import com.mafcarrefour.feedapplication.databinding.ActivityFeedListBinding;
import com.mafcarrefour.feedapplication.models.Article;
import com.mafcarrefour.feedapplication.views.feed.base.BaseActivity;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class FeedDetailsActivity extends BaseActivity<ActivityFeedDetailsBinding, FeedDetailsViewModel> {

    private FeedDetailsViewModel viewModel;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    ActivityFeedDetailsBinding viewBinding;

    private static final String PARAM_ARTICLE = "param_article";

    // to create intent for FeedDetailsActivity
    public static Intent getStartIntent(Context context, Article article) {
        Intent intent = new Intent(context, FeedDetailsActivity.class);
        intent.putExtra(PARAM_ARTICLE, article);
        return intent;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = getViewDataBinding();
        if (getIntent().hasExtra(PARAM_ARTICLE))
            viewModel.setArticle(getIntent().getParcelableExtra(PARAM_ARTICLE));
        viewBinding.setItem(viewModel.getArticle());

    }

    @Override
    public int getBindingVariable() {
        return BR._all;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_feed_details;
    }

    @Override
    public FeedDetailsViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, mViewModelFactory).get(FeedDetailsViewModel.class);
        return viewModel;
    }

}
