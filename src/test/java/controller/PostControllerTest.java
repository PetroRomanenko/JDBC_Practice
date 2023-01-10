package controller;

import com.ferros.controller.PostController;
import com.ferros.model.Label;
import com.ferros.model.Post;
import com.ferros.model.PostStatus;
import com.ferros.repository.jdbc.JdbcPostRepositoryImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PostControllerTest {
    private PostController pc;
    //    private Post post1;
    private Post postSame;
    private Post postNew;
    private List<Label> labelList;
    @Mock
    JdbcPostRepositoryImpl sqlPostRepository = Mockito.mock(JdbcPostRepositoryImpl.class);

    @Before
//    public void setUp() {
//         pc = new PostController(sqlPostRepository);
//
//          post1 = new Post(1,"My First Post", new Date().getTime(), -1L , PostStatus.ACTIVE, labelList);
//         postSame = new Post(1,"My First Post", new Date().getTime() , PostStatus.ACTIVE,labelList);
//         postNew = new Post(2,"My Second Post", new Date().getTime() , PostStatus.ACTIVE,labelList);
//         postNew = null;
//         }


    @Test
    @Ignore
    public void getAllLabelsInPostTestPost() {
        JdbcPostRepositoryImpl postRepository = mock(JdbcPostRepositoryImpl.class);
        PostController pc = new PostController(sqlPostRepository);
        List<Label> labelList = new ArrayList<>();
        labelList.add(new Label(1, "First"));
        labelList.add(new Label(2, "Second"));
        labelList.add(new Label(3, "Third"));
        Post post1 = new Post(1, "My First Post", new Date().getTime(), PostStatus.ACTIVE, labelList);
        List<Label> labelList1 = Arrays.asList(new Label(1, "First"),
                new Label(2, "Second"),
                new Label(3, "Third"));

        when(postRepository.getAllLabelsInPost(post1.getId())).thenReturn(labelList);

        assertEquals(labelList1, pc.getAllLabelsInThisPost(post1.getId()));
    }

    @Test
    @Ignore
    public void getAllLabelsInPostTestNullPost() {
        JdbcPostRepositoryImpl postRepository = mock(JdbcPostRepositoryImpl.class);
        PostController pc = new PostController(sqlPostRepository);
        List<Label> labelList = null;
        Post post1 = new Post(1, "My First Post", new Date().getTime(), PostStatus.ACTIVE, null);
        List<Label> labelList1 = Arrays.asList(new Label(1, "First"),
                new Label(2, "Second"),
                new Label(3, "Third"));

        when(postRepository.getAllLabelsInPost(post1.getId())).thenReturn(labelList);

        assertNull(pc.getAllLabelsInThisPost(post1.getId()));

    }

    @Test
    @Ignore
    public void savePostNullTest() {
        PostController pc = new PostController(sqlPostRepository);
        Post post1 = new Post(1, "My First Post", new Date().getTime(), PostStatus.ACTIVE, labelList);
        List<Label> labelList1 = Arrays.asList(new Label(1, "First"),
                new Label(2, "Second"),
                new Label(3, "Third"));
        when(sqlPostRepository.save(post1)).thenReturn(post1);
        assertEquals(null, pc.savePost(post1.getContent()));
    }

    @Test
    @Ignore
    public void saveLabelTest() {
        PostController pc = new PostController(sqlPostRepository);
        Post post1 = new Post(1, "My First Post", new Date().getTime(), PostStatus.ACTIVE, labelList);
        List<Label> labelList1 = Arrays.asList(new Label(1, "First"),
                new Label(2, "Second"),
                new Label(3, "Third"));
        post1.setLabels(labelList1);
        when(sqlPostRepository.save(any())).thenReturn(post1);
        assertEquals(post1, pc.savePost(post1.getContent()));
    }
//
//    @Test
//    public void findLabelByIdTest(){
//        LabelController lc = new LabelController(sqlLabelRepository);
//        Label label = new Label(1, "First");
//        Label label1 = new Label(1, "First");
//        when(sqlLabelRepository.getById(label1.getId())).thenReturn(label1);
//        assertEquals(label,lc.findLabelById(1) );
//    }
//    @Test
//    public void findLabelByIdTestNullResult(){
//        LabelController lc = new LabelController(sqlLabelRepository);
//        Label label = new Label(1, "First");
//        Label label1 = new Label(1, "First");
//        when(sqlLabelRepository.getById(label1.getId())).thenReturn(null);
//        assertNull(lc.findLabelById(1));
//    }
//    @Test
//    public void findLabelByIdTestFail(){
//        LabelController lc = new LabelController(sqlLabelRepository);
//        Label label = new Label(1, "First");
//        Label label1 = new Label(2, "Second");
//        when(sqlLabelRepository.getById(label1.getId())).thenReturn(label1);
//        assertNotEquals(label,lc.findLabelById(1) );
//    }
//
//    @Test
//    public void getAllLabelsTest(){
//        LabelController lc = new LabelController(sqlLabelRepository);
//        List<Label> labelList = Arrays.asList( new Label(1, "First"),
//                new Label(2, "Second"),
//                new Label(3, "Third"));
//        List<Label> labelList2 = Arrays.asList( new Label(1, "First"),
//                new Label(2, "Second"),
//                new Label(3, "Third"));
//        when(sqlLabelRepository.getAll()).thenReturn(labelList);
//        assertEquals(labelList2,lc.getAllLabels());
//
//    }  @Test
//    public void getAllLabelsTestNotEqual(){
//        LabelController lc = new LabelController(sqlLabelRepository);
//        List<Label> labelList = Arrays.asList( new Label(1, "First"),
//                new Label(2, "Second"),
//                new Label(3, "Third"));
//        List<Label> labelList2 = Arrays.asList( new Label(1, "First"),
//                new Label(2, "Second"),
//                new Label(3, "Third"),
//                new Label(4, "Forth"));
//        when(sqlLabelRepository.getAll()).thenReturn(labelList);
//        assertNotEquals(labelList2,lc.getAllLabels());
//
//    }
//    @Test
//    public void getAllLabelsTestEmptyData() {
//        LabelController lc = new LabelController(sqlLabelRepository);
//        List<Label> labelList2 = null;
//        when(sqlLabelRepository.getAll()).thenReturn(labelList2);
//        assertNull(lc.getAllLabels());
//    }
//
//    @Test
//    public void updateLabelsTest(){
//        LabelController lc = new LabelController(sqlLabelRepository);
//        Label label = new Label(4, "Forth");
//        Label label2 = new Label(4, "Forth");
//        when(sqlLabelRepository.update(label)).thenReturn(label);
//        assertEquals(label2,sqlLabelRepository.update(label));
//    }
//
//    @Test
//    public void updateLabelTestNullLabel(){
//        LabelController lc = new LabelController(sqlLabelRepository);
//        Label label = null;
//        Label label2 = new Label(null, "Forth");
//        Label label3 = new Label(1, null);
//        when(sqlLabelRepository.update(label)).thenReturn(null);
//        when(sqlLabelRepository.update(label2)).thenReturn(null);
//        assertNull(null,sqlLabelRepository.update(label));
//        assertNull(null,sqlLabelRepository.update(label2));
//    }
//    @Test
//    public void deleteLabelByIDTest(){
//        LabelController lc = new LabelController(sqlLabelRepository);
//        Label label = new Label(4, "Forth");
//        Label label2 = new Label(4, "Forth");
//        when(sqlLabelRepository.getById(label2.getId())).thenReturn(label);
//        assertEquals(label2,lc.deleteLabelByID(label.getId()));
//        verify(sqlLabelRepository,times(2)).getById(label.getId());
//        verify(sqlLabelRepository).deleteById(label.getId());
//    }
//    @Test
//    public void deleteLabelByIDTestNoSuchLabel(){
//        LabelController lc = new LabelController(sqlLabelRepository);
//        Label label = new Label(4, "Forth");
//        Label label2 = new Label(4, "Forth");
//        when(sqlLabelRepository.getById(label2.getId())).thenReturn(null);
//        assertEquals(null,lc.deleteLabelByID(label.getId()));
//        verify(sqlLabelRepository,times(1)).getById(label.getId());
//    }

}
