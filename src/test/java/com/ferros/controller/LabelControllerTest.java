package com.ferros.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ferros.model.Label;
import com.ferros.repository.LabelRepository;
import com.ferros.repository.gson.JsonLabelRepositoryImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LabelControllerTest {
    /**
     * Method under test: {@link LabelController#LabelController(LabelRepository)}
     */
    @Test
    void testConstructor() {
        assertTrue((new LabelController(new JsonLabelRepositoryImpl())).getAllLabels().isEmpty());
    }

    /**
     * Method under test: {@link LabelController#LabelController()}
     */
    @Test
    void testConstructor2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        new LabelController();
    }

    /**
     * Method under test: {@link LabelController#saveLabel(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveLabel() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new LabelController()).saveLabel("Name");
    }

    /**
     * Method under test: {@link LabelController#saveLabel(String)}
     */
    @Test
    void testSaveLabel2() {
        JsonLabelRepositoryImpl jsonLabelRepositoryImpl = mock(JsonLabelRepositoryImpl.class);
        Label label = new Label("Name");
        when(jsonLabelRepositoryImpl.save((Label) any())).thenReturn(label);
        assertSame(label, (new LabelController(jsonLabelRepositoryImpl)).saveLabel("Name"));
        verify(jsonLabelRepositoryImpl).save((Label) any());
    }

    /**
     * Method under test: {@link LabelController#findLabelById(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindLabelById() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new LabelController()).findLabelById(1);
    }

    /**
     * Method under test: {@link LabelController#findLabelById(Integer)}
     */
    @Test
    void testFindLabelById2() {
        assertNull((new LabelController(new JsonLabelRepositoryImpl())).findLabelById(1));
    }

    /**
     * Method under test: {@link LabelController#getAllLabels()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllLabels() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new LabelController()).getAllLabels();
    }

    /**
     * Method under test: {@link LabelController#update(Label)}
     */
    @Test
    void testUpdate() {
        LabelController labelController = new LabelController();
        assertNull(labelController.update(new Label("Name")));
    }

    /**
     * Method under test: {@link LabelController#update(Label)}
     */
    @Test
    void testUpdate2() {
        assertNull((new LabelController()).update(null));
    }

    /**
     * Method under test: {@link LabelController#update(Label)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate3() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        LabelController labelController = new LabelController();
        labelController.update(new Label(1, "Name"));
    }

    /**
     * Method under test: {@link LabelController#update(Label)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate4() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access files outside the temporary directory (file 'src\main\resources\labels.json', permission 'write').
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        LabelController labelController = new LabelController(new JsonLabelRepositoryImpl());
        labelController.update(new Label(1, "Name"));
    }

    /**
     * Method under test: {@link LabelController#update(Label)}
     */
    @Test
    void testUpdate5() {
        LabelController labelController = new LabelController();
        assertNull(labelController.update(new Label(1, null)));
    }

    /**
     * Method under test: {@link LabelController#update(Label)}
     */
    @Test
    void testUpdate6() {
        LabelController labelController = new LabelController(null);
        assertNull(labelController.update(new Label(1, "Name")));
    }

    /**
     * Method under test: {@link LabelController#deleteLabelByID(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteLabelByID() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to call 'System.exit'.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new LabelController()).deleteLabelByID(1);
    }

    /**
     * Method under test: {@link LabelController#deleteLabelByID(Integer)}
     */
    @Test
    void testDeleteLabelByID2() {
        assertNull((new LabelController(new JsonLabelRepositoryImpl())).deleteLabelByID(1));
    }
}

