package com.manglolab.mangopost.services;

import com.manglolab.mangopost.model.pojo.Post;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by rajforhad on 11/10/2016.
 */

public class PostsAPIService {

    private interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostsList();
    }

    private Observable<List<Post>> postsObservable = new RestAdapter.Builder()
            .setEndpoint("http://jsonplaceholder.typicode.com")
            .build().create(com.manglolab.mangopost.services.PostsAPIService.PostService.class).getPostsList().cache();


    public Observable<List<Post>> getPostsObservable() {
        return postsObservable;
    }
}
