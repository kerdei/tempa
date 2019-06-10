package hu.kerdei.tempa.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.kerdei.tempa.application.configuraton.TempaApplication;
import hu.kerdei.tempa.application.controller.MeasurementController;
import hu.kerdei.tempa.persistence.repository.TemperatureMeasurementRepository;
import hu.kerdei.tempa.service.domain.TemperatureMeasurementDto;
import hu.kerdei.tempa.service.impl.TemperatureMeasurementServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MeasurementController.class)
@ContextConfiguration(classes = {TempaApplication.class})
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TemperatureMeasurementServiceImpl measurementService;

    @MockBean
    private TemperatureMeasurementRepository measurementRepository;

    @Before
    public void setUp() {

    }

    @Test
    public void measurementsShouldReturnArray() throws Exception {
        //Given
        List<TemperatureMeasurementDto> testMeasurments = Arrays.asList(
                new TemperatureMeasurementDto(1L, 25.6, LocalDateTime.of(2019, 6, 10, 15, 30), "factsjoystick"),
                new TemperatureMeasurementDto(2L, 26.3, LocalDateTime.of(2019, 3, 5, 5, 15), "designategrumble"));

        //When
        when(measurementService.getAll()).thenReturn(testMeasurments);

        //Then
        mockMvc.perform(MockMvcRequestBuilders.get("/measurements").
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(jsonPath("$", hasSize(2))).
                andExpect(jsonPath("$[0].meterID", is(1))).
                andExpect(jsonPath("$[0].value", is(25.6))).
                andExpect(jsonPath("$[0].date", is("2019-06-10T15:30:00"))).
                andExpect(jsonPath("$[0].userName", is("factsjoystick"))).

                andExpect(jsonPath("$[1].meterID", is(2))).
                andExpect(jsonPath("$[1].value", is(26.3))).
                andExpect(jsonPath("$[1].date", is("2019-03-05T05:15:00"))).
                andExpect(jsonPath("$[1].userName", is("designategrumble"))).
                andDo(print());
    }


    @Test
    public void measurementsShouldReturnArrayEvenWhenEmpty() throws Exception {
        //Given
        //When
        when(measurementService.getAll()).thenReturn(Collections.emptyList());

        //Then
        mockMvc.perform(MockMvcRequestBuilders.get("/measurements").
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(jsonPath("$", hasSize(0))).
                andDo(print());
    }


    @Test
    public void measurementAddShouldReturnMeasurmentWhenOk() throws Exception {
        //Given

        TemperatureMeasurementDto newTestMeasurement = new TemperatureMeasurementDto(
                15L,
                25.0,
                LocalDateTime.of(2019, 6, 6, 6, 6),
                "jabburdensome");
        //When
        when(measurementService.add(newTestMeasurement)).thenReturn(newTestMeasurement);
        //Then
        mockMvc.perform(MockMvcRequestBuilders.post("/measurements/add").
                content(asJsonString(newTestMeasurement)).
                contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void measurementAddShouldNotOkStatusWhenBadInput() throws Exception {
        //Given
        String wrongInput = "wrongInput";
        //When
        //Then
        mockMvc.perform(MockMvcRequestBuilders.post("/measurements/add").
                content(asJsonString(wrongInput)).
                contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(status().isBadRequest())
                .andDo(print());
    }

    public static String asJsonString(final Object obj) {
        try {
            //needed bacause LocalDateTime
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.findAndRegisterModules();

            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
