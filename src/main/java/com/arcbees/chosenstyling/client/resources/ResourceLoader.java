package com.arcbees.chosenstyling.client.resources;

import javax.inject.Inject;

public class ResourceLoader {
    @Inject
    ResourceLoader(AppResources appResources,
            ChosenDarkResources chosenResources,
            ChosenUnicornResources chosenUnicornResources) {
        appResources.normalize().ensureInjected();
        appResources.style().ensureInjected();
        chosenResources.css().ensureInjected();
        chosenUnicornResources.css().ensureInjected();
    }
}
