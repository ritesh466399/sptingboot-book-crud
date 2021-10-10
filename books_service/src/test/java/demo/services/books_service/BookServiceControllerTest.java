package demo.services.books_service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import demo.services.books_service.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class BookServiceControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }


   @Test
   public void testBookAllOperations() throws Exception {

      //post books
      String inputJson1 = "{\n" +
              "        \"id\": 1,\n" +
              "        \"name\": \"title 1\",\n" +
              "        \"author\": \"author 1\",\n" +
              "        \"classification\": \"FICTION\",\n" +
              "        \"price\": 100\n" +
              "    }";

      String uri = "/books";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
              .contentType(MediaType.APPLICATION_JSON_VALUE)
              .content(inputJson1)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);


     // getbooks
      String getUri = "/books/1";
      MvcResult mvcResult1 = mvc.perform(MockMvcRequestBuilders.get(getUri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      int status1 = mvcResult1.getResponse().getStatus();
      assertEquals(200, status1);
      String content1= mvcResult1.getResponse().getContentAsString();
      Book book1 = super.mapFromJson(content1, Book.class);
      assertEquals(book1.getId(),new Long(1));
      assertEquals(book1.getAuthor(),"author 1");


   //update books
      String updateUri = "/books";
      String inputJson2 = "{\n" +
              "        \"id\": 1,\n" +
              "        \"name\": \"Lemon\",\n" +
              "        \"author\": \"author 1\",\n" +
              "        \"classification\": \"FICTION\",\n" +
              "        \"price\": 100\n" +
              "    }";

      MvcResult mvcResult2 = mvc.perform(MockMvcRequestBuilders.put(updateUri)
              .contentType(MediaType.APPLICATION_JSON_VALUE)
              .content(inputJson2)).andReturn();

      int status2 = mvcResult2.getResponse().getStatus();
     assertEquals(200, status2);



      String getUri2 = "/books/1";
      MvcResult mvcResult3 = mvc.perform(MockMvcRequestBuilders.get(getUri2)
              .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      int status3 = mvcResult3.getResponse().getStatus();
      assertEquals(200, status3);
      String content3= mvcResult3.getResponse().getContentAsString();
      Book book3 = super.mapFromJson(content3, Book.class);
      assertEquals(book3.getName(),"Lemon");


   }





}