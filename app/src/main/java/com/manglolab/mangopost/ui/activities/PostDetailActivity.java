package com.manglolab.mangopost.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.manglolab.mangopost.ui.contracts.IPostScreen;
import com.manglolab.mangopost.ui.presenters.PostsPresenter;


import javax.inject.Inject;

/**
 * Created by rajforhad on 11/10/2016.
 */

public class PostDetailActivity extends AppCompatActivity implements IPostScreen{

    @Inject
    PostsPresenter postsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
