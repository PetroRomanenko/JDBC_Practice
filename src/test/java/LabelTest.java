import com.ferros.model.Label;
import com.ferros.repository.jdbc.JdbcLabelRepositoryImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LabelTest {
    @Mock

    JdbcLabelRepositoryImpl sqlLabelRepositoryMock =Mockito.mock(JdbcLabelRepositoryImpl.class);

//    @Before
//    void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void getByIdLabelTest(){
        Label label = new Label(1,"Test");
        Mockito.when(sqlLabelRepositoryMock.getById(label.getId())).thenReturn(label);

        assertEquals(label, sqlLabelRepositoryMock.getById(label.getId()));

    }
    @Test
    public void getAllLabelTest(){
        List<Label> labelList = Arrays.asList(  new Label(1,"Test1"),
                                                new Label(2,"Test2"),
                                                new Label(3,"Test3"));

        Mockito.when(sqlLabelRepositoryMock.getAll()).thenReturn(labelList);

        assertEquals(labelList, sqlLabelRepositoryMock.getAll());
    }
    @Test
    public void saveLabelTest(){
        List<Label> labelList = Arrays.asList(  new Label(1,"Test1"),
                new Label(2,"Test2"),
                new Label(3,"Test3"));
        Label label = new Label(2, "Test2");
        Mockito.when(sqlLabelRepositoryMock.save(label)).thenReturn(labelList.get(1));

        assertEquals(label,sqlLabelRepositoryMock.save(label));
    }

    @Test
    public void updateLabelTest(){
        List<Label> labelList = Arrays.asList(  new Label(1,"Test1"),
                new Label(2,"Test2"),
                new Label(3,"Test3"));
        Label label = new Label(2, "Test2");
        Mockito.when(sqlLabelRepositoryMock.save(label)).thenReturn(labelList.get(1));

        assertEquals(label,sqlLabelRepositoryMock.save(label));
    }

    @Test
    public void deleteByIdLabel(){
        List<Label> labelList = Arrays.asList(  new Label(1,"Test1"),
                new Label(2,"Test2"),
                new Label(3,"Test3"));
        List<Label> labelList2 = Arrays.asList(  new Label(1,"Test1"),
                new Label(3,"Test3"));
    }
}



