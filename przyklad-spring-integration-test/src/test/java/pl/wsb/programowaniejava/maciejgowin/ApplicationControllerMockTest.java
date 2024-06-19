package pl.wsb.programowaniejava.maciejgowin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationControllerMockTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ExampleService exampleService;

    @Test
    void shouldReturnExample() throws Exception {
        // given
        when(exampleService.getValue()).thenReturn("mocked-value");

        // when & then
        MvcResult result = mockMvc.perform(get("/example")) // actual HTTP GET invocation
                .andExpect(status().isOk())
                .andExpect(content().string("mocked-value"))
                .andDo(print()).andReturn();
    }
}
