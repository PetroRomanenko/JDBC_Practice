import com.ferros.controller.LabelController;
import com.ferros.model.Label;
import com.ferros.repository.jdbc.JdbcLabelRepositoryImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LabelControllerTest {

    @Mock
    JdbcLabelRepositoryImpl sqlLabelRepository = Mockito.mock(JdbcLabelRepositoryImpl.class);

    @InjectMocks
    LabelController controllerUnderTest = new LabelController(sqlLabelRepository);

    @Test
    @Ignore
    public void saveLabelNullTest(){

        Label label = new Label(null, "First");
        Label label1 = new Label(1, "First");
        when(sqlLabelRepository.save(label)).thenReturn(label1);
        assertEquals(null,controllerUnderTest.saveLabel(label.getName()));
    }
    @Test
    public void saveLabelTest(){
        Label label = new Label(1, "First");
        Label label1 = new Label(1, "First");
        when(sqlLabelRepository.save(label)).thenReturn(label);
        assertEquals(label1,controllerUnderTest.saveLabel(label.getName()));
    }

    @Test
    public void findLabelByIdTest(){
        Label label = new Label(1, "First");
        Label label1 = new Label(1, "First");
        when(sqlLabelRepository.getById(label1.getId())).thenReturn(label1);
        assertEquals(label,controllerUnderTest.findLabelById(1) );
    }
    @Test
    public void findLabelByIdTestNullResult(){
        Label label = new Label(1, "First");
        Label label1 = new Label(1, "First");
        when(sqlLabelRepository.getById(label1.getId())).thenReturn(null);
        assertNull(controllerUnderTest.findLabelById(1));
    }
    @Test
    public void findLabelByIdTestFail(){
        Label label = new Label(1, "First");
        Label label1 = new Label(2, "Second");
        when(sqlLabelRepository.getById(label1.getId())).thenReturn(label1);
        assertNotEquals(label,controllerUnderTest.findLabelById(1) );
    }

    @Test
    public void getAllLabelsTest(){
        List<Label> labelList = Arrays.asList( new Label(1, "First"),
                                              new Label(2, "Second"),
                                              new Label(3, "Third"));
        List<Label> labelList2 = Arrays.asList( new Label(1, "First"),
                new Label(2, "Second"),
                new Label(3, "Third"));
        when(sqlLabelRepository.getAll()).thenReturn(labelList);
        assertEquals(labelList2,controllerUnderTest.getAllLabels());

    }  @Test
    public void getAllLabelsTestNotEqual(){
        List<Label> labelList = Arrays.asList( new Label(1, "First"),
                                              new Label(2, "Second"),
                                              new Label(3, "Third"));
        List<Label> labelList2 = Arrays.asList( new Label(1, "First"),
                new Label(2, "Second"),
                new Label(3, "Third"),
                new Label(4, "Forth"));
        when(sqlLabelRepository.getAll()).thenReturn(labelList);
        assertNotEquals(labelList2,controllerUnderTest.getAllLabels());

    }
    @Test
    public void getAllLabelsTestEmptyData() {
        List<Label> labelList2 = null;
        when(sqlLabelRepository.getAll()).thenReturn(labelList2);
        assertNull(controllerUnderTest.getAllLabels());
    }

    @Test
    public void updateLabelsTest(){
        Label label = new Label(4, "Forth");
        Label label2 = new Label(4, "Forth");
        when(sqlLabelRepository.update(label)).thenReturn(label);
        assertEquals(label2,sqlLabelRepository.update(label));
    }

    @Test
    public void updateLabelTestNullLabel(){
        LabelController lc = new LabelController(sqlLabelRepository);
        Label label = null;
        Label label2 = new Label(null, "Forth");
        Label label3 = new Label(1, null);
        when(sqlLabelRepository.update(label)).thenReturn(null);
        when(sqlLabelRepository.update(label2)).thenReturn(null);
        assertNull(null,sqlLabelRepository.update(label));
        assertNull(null,sqlLabelRepository.update(label2));
    }
    @Test
    public void deleteLabelByIDTest(){
        LabelController lc = new LabelController(sqlLabelRepository);
        Label label = new Label(4, "Forth");
        Label label2 = new Label(4, "Forth");
        when(sqlLabelRepository.getById(label2.getId())).thenReturn(label);
        assertEquals(label2,lc.deleteLabelByID(label.getId()));
        verify(sqlLabelRepository,times(2)).getById(label.getId());
        verify(sqlLabelRepository).deleteById(label.getId());
    }
  @Test
    public void deleteLabelByIDTestNoSuchLabel(){
        LabelController lc = new LabelController(sqlLabelRepository);
        Label label = new Label(4, "Forth");
        Label label2 = new Label(4, "Forth");
        when(sqlLabelRepository.getById(label2.getId())).thenReturn(null);
        assertEquals(null,lc.deleteLabelByID(label.getId()));
        verify(sqlLabelRepository,times(1)).getById(label.getId());
    }


}
