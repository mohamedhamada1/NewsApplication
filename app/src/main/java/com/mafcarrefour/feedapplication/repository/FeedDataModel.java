package com.mafcarrefour.feedapplication.repository;

import com.mafcarrefour.feedapplication.models.ArticleContainer;
import com.mafcarrefour.feedapplication.utils.ApiEndpoint;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import sa.waqood.networkmodule.AppExecutors;
import sa.waqood.networkmodule.NetworkBoundResource;
import sa.waqood.networkmodule.RXRequestNetwork;
import sa.waqood.networkmodule.Resource;

/**
 * Created by Mohamed.Shaaban on 3/13/2018.
 */

public class FeedDataModel {

    private final AppExecutors appExecutors;

    @Inject
    public FeedDataModel(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
    }

    public LiveData<Resource<ArticleContainer>> fetchArticles() {

        return new NetworkBoundResource<ArticleContainer, ArticleContainer>(appExecutors) {

            @Override
            protected void saveCallResult(@NonNull ArticleContainer jsonObject) {

// in case you need to cache the result in DB or using any way you should to do this operation here
            }

            @Override
            protected boolean shouldFetch(@Nullable ArticleContainer data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<ArticleContainer> loadFromDb() {
                // load from DB , it should use this method if you want to have sync between local and server data
                return null;
            }

            @NonNull
            @Override
            protected LiveData<Resource<?>> createCall() {
                return RXRequestNetwork.get(ApiEndpoint.GET_ARTICLE)
                        .build()
                        .asObjectObservable(ArticleContainer.class);
            }

            @NonNull
            @Override
            protected int getRequestId() {
                return 101;
            }
        }.asLiveData();
    }


}
