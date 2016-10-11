package com.manglolab.mangopost.ui.presenters;

import com.manglolab.mangopost.events.ErrorEvent;
import com.manglolab.mangopost.events.NewCommentsEvent;
import com.manglolab.mangopost.model.pojo.Comment;
import com.manglolab.mangopost.services.CommentsAPIService;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class CommentsPresenter {

    CommentsAPIService commentsAPIService;

    @Inject
    public CommentsPresenter(CommentsAPIService commentsAPIService) {
        this.commentsAPIService = commentsAPIService;
    }

    public void loadCommentsFromAPI() {
        commentsAPIService.getCommentsObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                                                                                     .mainThread())
                .subscribe(new Subscriber<List<Comment>>() {
                    @Override
                    public void onNext(List<Comment> newComments) {
                        EventBus.getDefault().post(new NewCommentsEvent(newComments));
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
