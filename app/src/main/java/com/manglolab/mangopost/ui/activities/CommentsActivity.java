package com.manglolab.mangopost.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.manglolab.mangopost.R;
import com.manglolab.mangopost.dagger.DaggerInjector;
import com.manglolab.mangopost.events.ErrorEvent;
import com.manglolab.mangopost.events.NewCommentsEvent;
import com.manglolab.mangopost.ui.adapters.CommentsListAdapter;
import com.manglolab.mangopost.ui.contracts.ICommentScreen;
import com.manglolab.mangopost.ui.decorators.DividerItemDecoration;
import com.manglolab.mangopost.ui.presenters.CommentsPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;

public class CommentsActivity extends AppCompatActivity implements ICommentScreen {

    @Inject
    CommentsPresenter commentsPresenter;

    @InjectView(R.id.posts_recycler_view)
    RecyclerView commentsRecyclerView;

    @InjectView(R.id.error_view)
    TextView errorView;

    CommentsListAdapter commentsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comments);

        DaggerInjector.get().inject(this);
        ButterKnife.inject(this);

        initRecyclerView();
        commentsPresenter.loadCommentsFromAPI();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void initRecyclerView() {
        commentsRecyclerView.setHasFixedSize(true);
        commentsRecyclerView.setLayoutManager(new LinearLayoutManager(commentsRecyclerView.getContext()));
        commentsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        commentsRecyclerView.addItemDecoration(new DividerItemDecoration(commentsRecyclerView.getContext(),
                                                                      DividerItemDecoration.VERTICAL_LIST));
        commentsListAdapter = new CommentsListAdapter();
        commentsRecyclerView.setAdapter(commentsListAdapter);
    }

    public void onEventMainThread(NewCommentsEvent newCommentsEvent) {
        hideError();
        commentsListAdapter.addPosts(newCommentsEvent.getComments());
    }

    public void onEventMainThread(ErrorEvent errorEvent) {
        showError();
    }

    private void hideError() {
        commentsRecyclerView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
    }

    private void showError() {
        commentsRecyclerView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
    }
}
