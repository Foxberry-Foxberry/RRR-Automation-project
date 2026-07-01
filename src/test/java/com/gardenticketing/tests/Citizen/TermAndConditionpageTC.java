package com.gardenticketing.tests.Citizen;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gardenticketing.base.BaseTestClassCitizen;
import com.gardenticketing.pages.Citizen.TermAndConditionPage;

public class TermAndConditionpageTC extends BaseTestClassCitizen {

    @Test
    public void verifyTermAndConditionPage() {

        TermAndConditionPage termPage =
                new TermAndConditionPage(driver);

        termPage.openTermAndConditionPage();

        Assert.assertTrue(
                termPage.isTermAndConditionDisplayed(),
                "Terms and Conditions are not displayed");

        String termsText =
                termPage.getTermAndConditionText();

        System.out.println("Terms & Conditions:");
        System.out.println(termsText);

        Assert.assertFalse(
                termsText.trim().isEmpty(),
                "Terms and Conditions text is empty");
    }
}