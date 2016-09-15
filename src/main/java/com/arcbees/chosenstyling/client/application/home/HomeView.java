package com.arcbees.chosenstyling.client.application.home;

import javax.inject.Inject;

import com.arcbees.chosenstyling.client.resources.ChosenTradeworksResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.watopi.chosen.client.ChosenOptions;
import com.watopi.chosen.client.gwt.ChosenListBox;

public class HomeView extends ViewImpl implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

    //First we declare our choices in an enum
    enum Choices {
        VADER("Darth Vader"),
        LUKE("Luke Skywalker"),
        LEIA("Princess Leia"),
        C3PO("C3PO"),
        R2D2("R2D2"),
        ANAKIN("Anakin Skywalker"),
        OBI_WAN("Obi Wan Kenobi"),
        BOBA_FETT("Boba Fett");

        public String getLiteral() {
            return name;
        }

        private final String name;

        Choices(String s) {
            name = s;
        }
    }

    //We decide how we want to show the different choices
    private static class ChoiceRenderer extends AbstractRenderer<Choices> {
        @Override
        public String render(Choices choices) {
            return choices != null ? choices.getLiteral() : "";
        }
    }

    private static final ChosenTradeworksResources CHOSEN_RESOURCES_TRADEWORKS = GWT.create(ChosenTradeworksResources.class);

    @UiField(provided = true)
    ChosenListBox singleChosenTradeworks;

    @Inject
    HomeView(Binder uiBinder) {
        ChosenOptions chosenOptionsTradeworks = new ChosenOptions();
        chosenOptionsTradeworks.setPlaceholderText("Choose your favorite character");
        chosenOptionsTradeworks.setResources(CHOSEN_RESOURCES_TRADEWORKS);

        singleChosenTradeworks = new ChosenListBox(chosenOptionsTradeworks);

        initWidget(uiBinder.createAndBindUi(this));

        //Acceptable and selected values are set after createAndBindUi
        for (Choices o : Choices.values()) {
            singleChosenTradeworks.addItem(o.getLiteral());
        }
    }
}
