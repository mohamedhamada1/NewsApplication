package com.mafcarrefour.feedapplication.views.feed.details;

import com.mafcarrefour.feedapplication.di.ViewModelProviderFactory;
import com.mafcarrefour.feedapplication.views.feed.list.FeedAdapter;
import com.mafcarrefour.feedapplication.views.feed.list.FeedListActivity;
import com.mafcarrefour.feedapplication.views.feed.list.FeedListViewModel;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Mohamed.Shaaban on 3/11/2018.
 */
@Module
public class FeedDetailsActivityModule {

    @Provides
    ViewModelProvider.Factory provideFeedDetailsViewModelFactory(FeedDetailsViewModel viewModel) {
        return new ViewModelProviderFactory<>(viewModel);
    }

}
