package com.automation.seleniumdesign.factory;

public abstract class GooglePage {

    public abstract void launchSite();

    public abstract void search(final String keyword);

    public abstract int getResultsCount();

}
