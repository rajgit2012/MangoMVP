package com.manglolab.mangopost.dagger;

import com.manglolab.mangopost.dagger.components.AppComponent;
import com.manglolab.mangopost.dagger.components.DaggerAppComponent;
import com.manglolab.mangopost.dagger.modules.AppModule;

public class DaggerInjector {
    private static AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();

    public static AppComponent get() {
        return appComponent;
    }
}
