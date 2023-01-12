package com.ferros.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ferros.model.Label;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LabelViewTest {
    /**
     * Method under test: {@link LabelView#createLabel()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateLabel() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        LabelView labelView = null;

        // Act
        labelView.createLabel();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link LabelView#findLabelById()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindLabelById() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        LabelView labelView = null;

        // Act
        labelView.findLabelById();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link LabelView#showAllLabels()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testShowAllLabels() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new LabelView()).showAllLabels();
    }

    /**
     * Method under test: {@link LabelView#updateLabel()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateLabel() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        LabelView labelView = null;

        // Act
        labelView.updateLabel();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link LabelView#deleteLabelByID()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteLabelByID() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        LabelView labelView = null;

        // Act
        labelView.deleteLabelByID();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link LabelView#showMenuMassage()}
     */
    @Test
    void testShowMenuMassage() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     LabelView.CRUDMassage
        //     LabelView.controller
        //     LabelView.line
        //     LabelView.scanner

        (new LabelView()).showMenuMassage();
    }

    /**
     * Method under test: {@link LabelView#menuChoice()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMenuChoice() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        LabelView labelView = null;

        // Act
        labelView.menuChoice();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link LabelView#printList(List)}
     */
    @Test
    void testPrintList() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     LabelView.CRUDMassage
        //     LabelView.controller
        //     LabelView.line
        //     LabelView.scanner

        LabelView labelView = new LabelView();
        labelView.printList(new ArrayList<>());
    }

    /**
     * Method under test: {@link LabelView#printList(List)}
     */
    @Test
    void testPrintList2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     LabelView.CRUDMassage
        //     LabelView.controller
        //     LabelView.line
        //     LabelView.scanner

        LabelView labelView = new LabelView();

        ArrayList<Label> labelList = new ArrayList<>();
        labelList.add(new Label("Name"));
        labelView.printList(labelList);
    }

    /**
     * Method under test: {@link LabelView#printList(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrintList3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ferros.model.Label.getId()" because "label" is null
        //       at com.ferros.view.LabelView.printLabel(LabelView.java:117)
        //       at com.ferros.view.LabelView.printList(LabelView.java:109)
        //   See https://diff.blue/R013 to resolve this issue.

        LabelView labelView = new LabelView();

        ArrayList<Label> labelList = new ArrayList<>();
        labelList.add(null);
        labelView.printList(labelList);
    }

    /**
     * Method under test: {@link LabelView#printList(List)}
     */
    @Test
    void testPrintList4() {
        LabelView labelView = new LabelView();
        Label label = mock(Label.class);
        when(label.getId()).thenReturn(1);
        when(label.getName()).thenReturn("Name");

        ArrayList<Label> labelList = new ArrayList<>();
        labelList.add(label);
        labelView.printList(labelList);
        verify(label).getId();
        verify(label).getName();
    }

    /**
     * Method under test: {@link LabelView#printLabel(Label, String)}
     */
    @Test
    void testPrintLabel() {
        LabelView labelView = new LabelView();
        Label label = new Label("Name");
        labelView.printLabel(label, "Not all who wander are lost");
        assertEquals("Name", label.getName());
    }

    /**
     * Method under test: {@link LabelView#printLabel(Label, String)}
     */
    @Test
    void testPrintLabel2() {
        LabelView labelView = new LabelView();
        Label label = new Label("Name");
        labelView.printLabel(label, null);
        assertEquals("Name", label.getName());
    }

    /**
     * Method under test: {@link LabelView#printLabel(Label, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrintLabel3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ferros.model.Label.getId()" because "label" is null
        //       at com.ferros.view.LabelView.printLabel(LabelView.java:117)
        //   See https://diff.blue/R013 to resolve this issue.

        (new LabelView()).printLabel(null, "Not all who wander are lost");
    }
}

