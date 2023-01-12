package controller;

import com.ferros.controller.WriterController;
import com.ferros.model.Post;
import com.ferros.model.PostStatus;
import com.ferros.model.Writer;
import com.ferros.repository.WriterRepository;
import com.ferros.repository.jdbc.JdbcWriterRepositoryImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class WriterControllerTest {
    WriterController wc;
    Writer writerDavid;
    Writer writerDavidCopy;
    Writer writerPatrick;
    List<Post> davidPosts;
    List<Post> patricPosts;
    @Mock
    WriterRepository writerRepository = Mockito.mock(JdbcWriterRepositoryImpl.class);

    @Before
    @Ignore
    public void setUp(){
         wc = new WriterController();
         davidPosts= Arrays.asList(new Post("New day", PostStatus.ACTIVE),new Post("Yesterday", PostStatus.ACTIVE));
         patricPosts= Arrays.asList(new Post("My fails that helps me to become hero", PostStatus.ACTIVE),new Post("Iphone in avery days use", PostStatus.ACTIVE));
         writerDavid = new Writer(1,"David", "Piterson", davidPosts);
         writerDavidCopy = new Writer(1,"David", "Piterson", davidPosts);
         writerPatrick = new Writer(2,"Patrick", "Callman", patricPosts);
    }
    @Test
    @Ignore
    public void findWriterByIdWereNoSuchId(){
        WriterRepository writerRepository = Mockito.mock(JdbcWriterRepositoryImpl.class);


        when(writerRepository.getById(-1)).thenReturn(null);
        assertNull(wc.findWriterById(-1));
    }

    @Test
    @Ignore
    public void findWriterByyId(){
        when(writerRepository.getById(1)).thenReturn(writerDavid);
        assertEquals(writerDavidCopy, wc.findWriterById(1));
    }
}
