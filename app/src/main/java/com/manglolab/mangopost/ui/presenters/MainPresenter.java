package com.manglolab.mangopost.ui.presenters;

import com.manglolab.mangopost.ui.screen_contracts.MainScreen;

import javax.inject.Inject;

public class MainPresenter {

    @Inject
    public MainPresenter() {
    }

    public void OnShowPostsButtonClick(MainScreen mainScreen) {
        mainScreen.launchPostsActivity();
    }

}
