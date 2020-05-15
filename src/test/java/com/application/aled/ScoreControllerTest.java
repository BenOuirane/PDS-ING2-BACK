package com.application.aled;

/**
 * Class: ScoreControllerTest
 * @author: BEN OUIRANE Hajer
 */


import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.application.aled.controller.ScoreController;
import com.application.aled.entity.Score;
import com.application.aled.service.ScoreService;
import com.application.aled.service.ScoreServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScoreControllerTest {

          @Mock
          private ScoreServiceImpl scoreService;

          @InjectMocks
          private ScoreController scoreController;
          @Before
          public  void setUp() throws Exception {
              mockMvc = MockMvcBuilders.standaloneSetup(scoreController).build();

          }


    private MockMvc mockMvc;

     private String mapToJson(Object object) throws JsonProcessingException {
         ObjectMapper objectMapper = new ObjectMapper();
         return  objectMapper.writeValueAsString(object);
     }


    @Test
    public void  testcreateScore() throws Exception {

        Score entity = new Score();
        entity.setId(Long.valueOf(1));
        entity.setNote_sociable(1);
        entity.setNote_self_ruling(2);
        entity.setNote_not_sick(3);
        entity.setNote_not_sick(4);
        entity.setNote_no_self_ruling(5);
        entity.setNote_no_athletic(6);
        entity.setNote_like_rest(7);
        entity.setNote_like_game(8);
        entity.setNote_like_cooking(9);
        entity.setNote_no_sociable(10);
        entity.setNote_hypertension(11);
        entity.setNote_good_social_condition(12);
        entity.setNote_good_financial_condition(13);
        entity.setNote_diabetes(14);
        entity.setNote_bad_social_condition(15);
        entity.setNote_bad_financial_condition(16);

            String inputInJson = this.mapToJson(entity);

            String uri = "/api/note";

        Mockito.when((scoreService.add(Mockito.any(Score.class)))).thenReturn(entity);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = response.getContentAsString();
           assertThat(outputInJson, is(equalTo(inputInJson)));
        //assertEquals(true, outputInJson = inputInJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());






          }







}
