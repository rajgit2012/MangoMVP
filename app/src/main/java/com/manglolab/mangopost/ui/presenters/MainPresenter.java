package com.manglolab.mangopost.ui.presenters;

import com.manglolab.mangopost.ui.contracts.IMasterScreen;

import javax.inject.Inject;

public class MainPresenter {

    @Inject
    public MainPresenter() {
    }

    public void OnShowPostsButtonClick(IMasterScreen masterScreen) {
        masterScreen.launchPostsActivity();
    }
}
