package main.java.flixbus.assignment;

import com.fasterxml.jackson.databind.ObjectMapper;
import flixbus.assignment.*;
import flixbus.assignment.model.BusCost;
import flixbus.assignment.model.Connection;
import flixbus.assignment.model.DriverCost;
import flixbus.assignment.model.Information;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = BusController.class)
public class BusControllerTests {
    @Autowired
	private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ConnectionRepository connectionRepository;
    @MockBean
    private BusCostRepository busCostRepository;
    @MockBean
    private DriverCostRepository driverCostRepository;

    @Test
    public void testConnectionFound() throws Exception {
        // Mock data
        List<Connection> list1 = new ArrayList<>();
        Connection connection1 = new Connection(3, "Munich", "Stuttgart", 800, 8);
        Connection connection2 = new Connection(3, "Munich", "Vienna", 400, 3.5);
        list1.add(connection1);
        list1.add(connection2);
        List<Connection> list2 = new ArrayList<>();
        Connection connection3 = new Connection(1, "Berlin", "Munich", 800, 8);
        list2.add(connection3);
        Mockito.when(connectionRepository.findByCity1("Munich")).thenReturn(list1);
        Mockito.when(connectionRepository.findByCity2("Munich")).thenReturn(list2);
        Mockito.when(connectionRepository.findByCity1AndCity2("Munich", "Stuttgart")).thenReturn(connection1);
        //
        Mockito.when(busCostRepository.findByLineId(3)).thenReturn(new BusCost(3, 1.414111432));
        Mockito.when(driverCostRepository.findByLineId(3)).thenReturn(new DriverCost(3, 5.582751583));
        //

        ResultActions request = mockMvc.perform(get("/information?city1=Munich&city2=Stuttgart")).andExpect(status().isOk());
        String jsonString = request.andReturn().getResponse().getContentAsString();

        assertEquals(1, objectMapper.readValue(jsonString, Information.class).getNumLines());
        assertEquals(1131.2891456, objectMapper.readValue(jsonString, Information.class).getTotalBusCost());
        assertEquals(44.662012664, objectMapper.readValue(jsonString, Information.class).getTotalDriverCost());
        assertEquals(1175.951158264, objectMapper.readValue(jsonString, Information.class).getTotalCost());
    }

    @Test
    public void testConnectionNotFound() throws Exception {
        mockMvc.perform(get("/information?city1=Munich&city2=Stuttgar")).andExpect(status().isNotFound());
    }
}
