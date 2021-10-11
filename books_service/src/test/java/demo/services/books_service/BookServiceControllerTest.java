package demo.services.books_service;

import demo.services.books_service.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;


public class BookServiceControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }


   @Test
   public void testBookAllOperations() throws Exception {

      //post books
      String postBookInputJson = "{\n" +
              "        \"id\": 1,\n" +
              "        \"name\": \"title 1\",\n" +
              "        \"author\": \"author 1\",\n" +
              "        \"classification\": \"FICTION\",\n" +
              "        \"price\": 100\n" +
              "    }";

      String uri = "/books";
      MvcResult postBookmvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
              .contentType(MediaType.APPLICATION_JSON_VALUE)
              .content(postBookInputJson)).andReturn();

      int status = postBookmvcResult.getResponse().getStatus();
      assertEquals(200, status);


     //get books
      String getUri = "/books/1";
      MvcResult getBookMvcResult = mvc.perform(MockMvcRequestBuilders.get(getUri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      int getBookStatus = getBookMvcResult.getResponse().getStatus();
      assertEquals(200, getBookStatus);
      String getBookRestResponse= getBookMvcResult.getResponse().getContentAsString();
      Book book = super.mapFromJson(getBookRestResponse, Book.class);
      assertEquals(book.getId(),new Long(1));
      assertEquals(book.getAuthor(),"author 1");


    //update books
      String updateUri = "/books";
      String updateBookInputJson = "{\n" +
              "        \"id\": 1,\n" +
              "        \"name\": \"Lemon\",\n" +
              "        \"author\": \"author 1\",\n" +
              "        \"classification\": \"FICTION\",\n" +
              "        \"price\": 100\n" +
              "    }";

      MvcResult updateBookMvcResult = mvc.perform(MockMvcRequestBuilders.put(updateUri)
              .contentType(MediaType.APPLICATION_JSON_VALUE)
              .content(updateBookInputJson)).andReturn();
      int updateBookStatus = updateBookMvcResult.getResponse().getStatus();
      assertEquals(200, updateBookStatus);



      MvcResult mvcResult3 = mvc.perform(MockMvcRequestBuilders.get(getUri)
              .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      int status3 = mvcResult3.getResponse().getStatus();
      assertEquals(200, status3);
      String content3= mvcResult3.getResponse().getContentAsString();
      Book book3 = super.mapFromJson(content3, Book.class);
      assertEquals(book3.getName(),"Lemon");


    //checkOut Books
       String checkOutinputJson = "[{\n" +
               "        \"id\": 1,\n" +
               "        \"name\": \"title 1\",\n" +
               "        \"author\": \"author 1\",\n" +
               "        \"classification\": \"FICTION\",\n" +
               "        \"price\": 100\n" +
               "    }]";
       String checkOutUri = "/books/checkout";
       MvcResult checkOutMvcResult = mvc.perform(MockMvcRequestBuilders.post(checkOutUri)
               .contentType(MediaType.APPLICATION_JSON_VALUE)
               .content(checkOutinputJson)).andReturn();
       int checkoutstatus = checkOutMvcResult.getResponse().getStatus();
       assertEquals(200, checkoutstatus);
       String checkoutContent= checkOutMvcResult.getResponse().getContentAsString();
       assertEquals(checkoutContent,"90.0");


       //delete books
       String deleteUri = "/books/1";
       MvcResult deleteMvcResult = mvc.perform(MockMvcRequestBuilders.delete(deleteUri)).andReturn();
       int deleteStatus = deleteMvcResult.getResponse().getStatus();
       assertEquals(200, deleteStatus);




   }





}