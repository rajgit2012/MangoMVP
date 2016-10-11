package com.manglolab.mangopost.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.manglolab.mangopost.ui.presenters.PostsPresenter;
import com.manglolab.mangopost.ui.screen_contracts.PostsScreen;

import javax.inject.Inject;

/**
 * Created by rajforhad on 11/10/2016.
 */

public class PostDetailActivity extends AppCompatActivity implements PostsScreen{

    @Inject
    PostsPresenter postsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
