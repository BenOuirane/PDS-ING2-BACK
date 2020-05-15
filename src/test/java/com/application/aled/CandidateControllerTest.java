package com.application.aled;

/**
 * Class: CandidateControllerTest
 * @author: BEN OUIRANE Hajer
 */



import com.application.aled.controller.CandidateController;
import com.application.aled.controller.ScoreController;
import com.application.aled.entity.Candidate;
import com.application.aled.repository.CandidateRepository;
import com.application.aled.service.CandidateServiceImpl;
import com.application.aled.service.ScoreServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class CandidateControllerTest {



    @Mock
    private CandidateServiceImpl candidateService;

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateController candidateController;


    @Before
    public  void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(candidateController).build();

    }


    private MockMvc mockMvc;

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.writeValueAsString(object);
    }


    @Test
    public void  testtolist() throws Exception{

        Candidate candidate1 = new Candidate();

        candidate1.setId((long) 1);
        candidate1.setAge("20");
        candidate1.setScore(70);
        candidate1.setFirstname("hajer");
        candidate1.setLastname("ben");
        candidate1.setGenre("W");
        candidate1.setMail("ben@yahoo.com");
        candidate1.setAutonomy("SELF_RULING ");
        candidate1.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
        candidate1.setFinance("GOOD_FINANCIAL_CONDITION");
        candidate1.setHabit("LIKE_GAMES ");
        candidate1.setSocial_activity("SOCIABLE ");
        candidate1.setSport("ATHLETIC ");
        candidate1.setType_de_maladie("NOT_SICk ");



        Candidate candidate2 = new Candidate();

        candidate2.setId((long) 2);
        candidate2.setAge("21");
        candidate2.setScore(71);
        candidate2.setFirstname("insaf");
        candidate2.setLastname("bach");
        candidate2.setGenre("W");
        candidate2.setMail("bach@yahoo.com");
        candidate2.setAutonomy("SELF_RULING ");
        candidate2.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
        candidate2.setFinance("GOOD_FINANCIAL_CONDITION");
        candidate2.setHabit("LIKE_GAMES ");
        candidate2.setSocial_activity("SOCIABLE ");
        candidate2.setSport("ATHLETIC ");
        candidate2.setType_de_maladie("NOT_SICk ");

        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate1);
        candidateList.add(candidate2);

        Mockito.when(candidateService.tolist()).thenReturn(candidateList);
        String uri = "/candidate";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(candidateList);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson, is(equalTo(expectedJson)));

    }

    @Test
    public void  testgetAllCandidates() throws Exception{

        Candidate candidate1 = new Candidate();

        candidate1.setId((long) 1);
        candidate1.setAge("20");
        candidate1.setScore(70);
        candidate1.setFirstname("hajer");
        candidate1.setLastname("ben");
        candidate1.setGenre("W");
        candidate1.setMail("ben@yahoo.com");
        candidate1.setAutonomy("SELF_RULING ");
        candidate1.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
        candidate1.setFinance("GOOD_FINANCIAL_CONDITION");
        candidate1.setHabit("LIKE_GAMES ");
        candidate1.setSocial_activity("SOCIABLE ");
        candidate1.setSport("ATHLETIC ");
        candidate1.setType_de_maladie("NOT_SICk ");



        Candidate candidate2 = new Candidate();

        candidate2.setId((long) 2);
        candidate2.setAge("21");
        candidate2.setScore(71);
        candidate2.setFirstname("insaf");
        candidate2.setLastname("bach");
        candidate2.setGenre("W");
        candidate2.setMail("bach@yahoo.com");
        candidate2.setAutonomy("SELF_RULING ");
        candidate2.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
        candidate2.setFinance("GOOD_FINANCIAL_CONDITION");
        candidate2.setHabit("LIKE_GAMES ");
        candidate2.setSocial_activity("SOCIABLE ");
        candidate2.setSport("ATHLETIC ");
        candidate2.setType_de_maladie("NOT_SICk ");

        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate1);
        candidateList.add(candidate2);

        Mockito.when(candidateRepository.findAll()).thenReturn(candidateList);
        String uri = "/candidates";


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);

        MvcResult result;
        result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(candidateList);
        String outputInJson = result.getResponse().getContentAsString();
        MockHttpServletResponse response = result.getResponse();
        assertThat(outputInJson, is(equalTo(expectedJson)));
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }


    /*
    done
     */



    @Test
    public void  testpostCandidate() throws Exception {

        Candidate candidate = new Candidate();

        candidate.setId((long) 1);
        candidate.setAge("20");
        candidate.setScore(70);
        candidate.setFirstname("hajer");
        candidate.setLastname("ben");
        candidate.setGenre("W");
        candidate.setMail("ben@yahoo.com");
        candidate.setAutonomy("SELF_RULING ");
        candidate.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
        candidate.setFinance("GOOD_FINANCIAL_CONDITION");
        candidate.setHabit("LIKE_GAMES ");
        candidate.setSocial_activity("SOCIABLE ");
        candidate.setSport("ATHLETIC ");
        candidate.setType_de_maladie("NOT_SICk ");

        String inputInJson = this.mapToJson(candidate);

        String uri = "/candidates/create";

//        Mockito.when((candidateRepository.findBymail(Mockito.matches(String.valueOf(Candidate.class))))).thenReturn(candidate);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = response.getContentAsString();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }


    @Test
    public void  getscoreAllCandidat() throws Exception {

        Candidate candidate = new Candidate();

        candidate.setId((long) 1);
        candidate.setAge("20");
        candidate.setFirstname("hajer");
        candidate.setLastname("ben");
        candidate.setGenre("W");
        candidate.setMail("ben@yahoo.com");
        candidate.setAutonomy("SELF_RULING ");
        candidate.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
        candidate.setFinance("GOOD_FINANCIAL_CONDITION");
        candidate.setHabit("LIKE_GAMES ");
        candidate.setSocial_activity("SOCIABLE ");
        candidate.setSport("ATHLETIC ");
        candidate.setType_de_maladie("NOT_SICk ");

        String inputInJson = this.mapToJson(candidate);

        String uri = "/score";

        Mockito.when((candidateService.getscoreAllCandidat())).thenReturn(Collections.singletonList(candidate));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = response.getContentAsString();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

    @Test
    public void  sortScoreAllCandidat() throws Exception {

        Candidate candidate = new Candidate();

        candidate.setId((long) 1);
        candidate.setAge("20");
        candidate.setFirstname("hajer");
        candidate.setLastname("ben");
        candidate.setGenre("W");
        candidate.setMail("ben@yahoo.com");
        candidate.setAutonomy("SELF_RULING ");
        candidate.setEtat_sociale("GOOD_SOCIAL_CONDITION ");
        candidate.setFinance("GOOD_FINANCIAL_CONDITION");
        candidate.setHabit("LIKE_GAMES ");
        candidate.setSocial_activity("SOCIABLE ");
        candidate.setSport("ATHLETIC ");
        candidate.setType_de_maladie("NOT_SICk ");

        String inputInJson = this.mapToJson(candidate);
        ArrayList<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate);

        String uri = "/sort";

        Mockito.when((candidateService.sortScoreAllCandidat())).thenReturn(candidateList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = response.getContentAsString();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }


}
