package com.manglolab.mangopost.dagger.components;

import com.manglolab.mangopost.dagger.modules.AppModule;
import com.manglolab.mangopost.ui.activities.MainActivity;
import com.manglolab.mangopost.ui.activities.PostsActivity;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(PostsActivity activity);
}
