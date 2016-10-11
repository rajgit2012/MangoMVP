package com.manglolab.mangopost.ui.presenters;

import com.manglolab.mangopost.events.ErrorEvent;
import com.manglolab.mangopost.events.NewPostsEvent;
import com.manglolab.mangopost.model.pojo.Post;
import com.manglolab.mangopost.services.PostsAPIService;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PostsPresenter {

    PostsAPIService postsAPI;

    @Inject
    public PostsPresenter(PostsAPIService postsAPI) {
        this.postsAPI = postsAPI;
    }

    public void loadPostsFromAPI() {
        postsAPI.getPostsObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                                                                                     .mainThread())
                .subscribe(new Subscriber<List<Post>>() {
                    @Override
                    public void onNext(List<Post> newPosts) {
                        EventBus.getDefault().post(new NewPostsEvent(newPosts));
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        EventBus.getDefault().post(new ErrorEvent());
                    }

                });
    }

}
