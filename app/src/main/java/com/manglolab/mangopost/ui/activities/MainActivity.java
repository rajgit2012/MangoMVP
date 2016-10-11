package com.manglolab.mangopost.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.manglolab.mangopost.R;
import com.manglolab.mangopost.dagger.DaggerInjector;
import com.manglolab.mangopost.ui.contracts.IMasterScreen;
import com.manglolab.mangopost.ui.presenters.MainPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMasterScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        DaggerInjector.get().inject(this);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.show_posts_button)
    public void OnListSampleButtonClick() {
        mainPresenter.OnShowPostsButtonClick(this);
    }

    @Override
    public void launchPostsActivity() {
        //Intent intent = new Intent(this, PostsActivity.class);
        Intent intent = new Intent(this, CommentsActivity.class);
        startActivity(intent);
    }

}
