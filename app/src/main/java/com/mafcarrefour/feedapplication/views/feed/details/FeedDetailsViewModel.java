package com.mafcarrefour.feedapplication.views.feed.details;

import com.mafcarrefour.feedapplication.models.Article;
import com.mafcarrefour.feedapplication.models.ArticleContainer;
import com.mafcarrefour.feedapplication.repository.FeedDataModel;
import com.mafcarrefour.feedapplication.views.feed.base.BaseViewModel;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import sa.waqood.networkmodule.Resource;


/**
 * Created by Mohamed.Shaaban on 3/11/2018.
 */

public class FeedDetailsViewModel extends BaseViewModel {

    private Article article;
    @Inject
    public FeedDetailsViewModel(){

    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
