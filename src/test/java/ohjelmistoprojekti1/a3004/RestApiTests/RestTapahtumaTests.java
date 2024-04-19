package ohjelmistoprojekti1.a3004.RestApiTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestTapahtumaTests {

    @Autowired
    private MockMvc mockMvc;

    // suorita get pyyntö /tapahtumat endpointiin ja odota vastaukseksi 200 OK.
    @Test
    @WithMockUser (username = "heikki", roles = {"ADMIN"})
    public void statusOk() throws Exception {

        mockMvc.perform(get("/tapahtumat"))
        .andExpect(status().isOk());

    }

    // suorita get pyyntö /tapahtumat endpointiin ja odota vastauksen tyypiksi Application_Json
    @Test
    @WithMockUser (username = "heikki", roles = {"ADMIN"})
    public void responseTypeApplicationJson() throws Exception {
        mockMvc.perform(get("/tapahtumat"))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
