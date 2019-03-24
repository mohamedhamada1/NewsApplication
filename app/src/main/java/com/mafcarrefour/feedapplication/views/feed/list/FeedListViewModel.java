package com.mafcarrefour.feedapplication.views.feed.list;

import com.mafcarrefour.feedapplication.models.ArticleContainer;
import com.mafcarrefour.feedapplication.repository.FeedDataModel;
import com.mafcarrefour.feedapplication.views.feed.base.BaseViewModel;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import sa.waqood.networkmodule.Resource;


/**
 * Created by Mohamed.Shaaban on 3/11/2018.
 */

public class FeedListViewModel extends BaseViewModel {
    private FeedDataModel feedDataModel;
    private ArticleContainer articleContainer;// keep data outside of activity lifecycle to handle change in config without re-load

    @Inject
    public FeedListViewModel(FeedDataModel feedDataModel) {
        this.feedDataModel = feedDataModel;
    }

    public LiveData<Resource<ArticleContainer>> fetchArticles() {
        return feedDataModel.fetchArticles();
    }

    public void setArticleContainer(ArticleContainer articleContainer) {
        this.articleContainer = articleContainer;
    }


}
