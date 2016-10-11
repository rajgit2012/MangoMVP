package com.manglolab.mangopost.dagger.modules;

import com.manglolab.mangopost.model.PostsAPI;
import com.manglolab.mangopost.services.CommentsAPIService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    PostsAPI providePostsApi() {
        return new PostsAPI();
    }

    @Provides
    @Singleton
    CommentsAPIService provideCommentsApi() {
        return new CommentsAPIService();
    }

}
