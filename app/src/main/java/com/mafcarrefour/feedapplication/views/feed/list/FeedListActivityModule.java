package com.mafcarrefour.feedapplication.views.feed.list;

import com.mafcarrefour.feedapplication.di.ViewModelProviderFactory;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Mohamed.Shaaban on 3/11/2018.
 */
@Module
public class FeedListActivityModule {

    @Provides
    ViewModelProvider.Factory provideFeedListViewModelFactory(FeedListViewModel viewModel) {
        return new ViewModelProviderFactory<>(viewModel);
    }

    @Provides
    public FeedAdapter provideFeedAdapter(FeedListActivity feedListActivity) {
        return new FeedAdapter(feedListActivity, feedListActivity);
    }
}
