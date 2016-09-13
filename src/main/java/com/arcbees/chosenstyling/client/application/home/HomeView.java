package com.arcbees.chosenstyling.client.application.home;

import javax.inject.Inject;

import com.arcbees.chosen.client.ChosenOptions;
import com.arcbees.chosen.client.gwt.ChosenListBox;
import com.arcbees.chosen.client.gwt.MultipleChosenValueListBox;
import com.arcbees.chosenstyling.client.resources.ChosenDarkResources;
import com.arcbees.chosenstyling.client.resources.ChosenTradeworksResources;
import com.arcbees.chosenstyling.client.resources.ChosenUnicornResources;
import com.google.common.collect.Lists;
import com.google.gwt.core.client.GWT;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

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

    private static final ChosenDarkResources CHOSEN_RESOURCES_DARK = GWT.create(ChosenDarkResources.class);
    private static final ChosenUnicornResources CHOSEN_RESOURCES_UNICORN = GWT.create(ChosenUnicornResources.class);
    private static final ChosenTradeworksResources CHOSEN_RESOURCES_TRADEWORKS = GWT.create(ChosenTradeworksResources.class);

    //Don’t forget that the component has to be provided
    @UiField(provided = true)
    MultipleChosenValueListBox<Choices> multipleValues;
    @UiField(provided = true)
    MultipleChosenValueListBox<Choices> multipleValuesDark;
    @UiField(provided = true)
    MultipleChosenValueListBox<Choices> multipleValuesUnicorn;
    @UiField(provided = true)
    ChosenListBox singleChosenDark;
    @UiField(provided = true)
    ChosenListBox singleChosenUnicorn;
    @UiField(provided = true)
    ChosenListBox singleChosenTradeworks;

    @Inject
    HomeView(Binder uiBinder) {
        //There are multiple options that you can set on GWTChosen.
        //These and the construction have to be called before the call to createAndBindUi
        ChosenOptions chosenOptions = new ChosenOptions();
        chosenOptions.setPlaceholderText("Choose your favorite character");

        multipleValues = new MultipleChosenValueListBox<>(new ChoiceRenderer(), chosenOptions);

        ChosenOptions chosenOptionsDark = new ChosenOptions();
        chosenOptionsDark.setPlaceholderText("Choose your favorite character");
        chosenOptionsDark.setResources(CHOSEN_RESOURCES_DARK);

        singleChosenDark = new ChosenListBox(chosenOptionsDark);
        multipleValuesDark = new MultipleChosenValueListBox<>(new ChoiceRenderer(), chosenOptionsDark);

        ChosenOptions chosenOptionsUnicorn = new ChosenOptions();
        chosenOptionsUnicorn.setPlaceholderText("Choose your favorite character");
        chosenOptionsUnicorn.setResources(CHOSEN_RESOURCES_UNICORN);

        singleChosenUnicorn = new ChosenListBox(chosenOptionsUnicorn);
        multipleValuesUnicorn = new MultipleChosenValueListBox<>(new ChoiceRenderer(), chosenOptionsUnicorn);

        ChosenOptions chosenOptionsTradeworks = new ChosenOptions();
        chosenOptionsTradeworks.setPlaceholderText("Choose your favorite character");
        chosenOptionsTradeworks.setResources(CHOSEN_RESOURCES_TRADEWORKS);

        singleChosenTradeworks = new ChosenListBox(chosenOptionsTradeworks);

        initWidget(uiBinder.createAndBindUi(this));

        //Acceptable and selected values are set after createAndBindUi
        for (Choices o : Choices.values()) {
            singleChosenTradeworks.addItem(o.getLiteral());
        }
        multipleValues.setAcceptableValues(Lists.newArrayList(Choices.values()));
        multipleValues.setValue(Lists.newArrayList(Choices.VADER, Choices.LEIA));

        multipleValuesDark.setAcceptableValues(Lists.newArrayList(Choices.values()));
        multipleValuesDark.setValue(Lists.newArrayList(Choices.VADER, Choices.LEIA));

        multipleValuesUnicorn.setAcceptableValues(Lists.newArrayList(Choices.values()));
        multipleValuesUnicorn.setValue(Lists.newArrayList(Choices.VADER, Choices.LEIA));
    }
}
