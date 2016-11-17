package test;

import hello.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ionut.stetco on 11/16/2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest(classes = {HelloController.class})
@AutoConfigureMockMvc
public class HelloControllerMockTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        System.out.println("HelloControllerMockTest");
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Greetings from Spring Boot!")))
        .andExpect(forwardedUrl("<html><head><h1>Greetings from Spring Boot!</h1></head><body>test</body></html>"));
    }
}