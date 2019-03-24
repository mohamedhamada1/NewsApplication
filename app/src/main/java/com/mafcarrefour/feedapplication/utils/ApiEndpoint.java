package com.mafcarrefour.feedapplication.utils;

import com.mafcarrefour.feedapplication.BuildConfig;

public interface ApiEndpoint {

    String GET_ARTICLE = BuildConfig.BASE_URL + "v2/everything?q=bitcoin&from=2019-02-24&sortBy=publishedAt&apiKey=5345966e25d943e285b9518833486a74";

}
