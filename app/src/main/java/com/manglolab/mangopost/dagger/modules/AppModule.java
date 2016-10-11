package com.manglolab.mangopost.dagger.modules;

import com.manglolab.mangopost.services.CommentsAPIService;
import com.manglolab.mangopost.services.PostsAPIService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    PostsAPIService providePostsApi() {
        return new PostsAPIService();
    }

    @Provides
    @Singleton
    CommentsAPIService provideCommentsApi() {
        return new CommentsAPIService();
    }

}
