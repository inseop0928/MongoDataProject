package com.manager.movie;
import com.mongodb.*;
import java.util.*;
public class MovieDAO {
   private MongoClient mc;
   // var Client=require('mongodb').MongoClient;
   private DB db;
   //var db=client.db('mydb');
   private DBCollection dbc;
   // db.collection('recipe')
   
   public MovieDAO()
   {
	   try
	   {
	       mc=new MongoClient("localhost",27017);
	       db=mc.getDB("mydb");// database
	       dbc=db.getCollection("movie");//table
	   }catch(Exception ex) {}
   }

   public void insert(MovieVO vo)
   {
	   BasicDBObject obj=new BasicDBObject();// {} => JSON
	   obj.put("mno",vo.getMno()); // {no:1,name:"",sex:""}
	   obj.put("title",vo.getTitle());
	   obj.put("poster",vo.getPoster());
	   obj.put("director",vo.getDirector());
	   obj.put("actor",vo.getActor());
	   obj.put("genre",vo.getGenre());
	   obj.put("grade",vo.getGrade());
	   obj.put("regdate",vo.getRegdate());
	   obj.put("story",vo.getStory());
	   dbc.insert(obj);
   }
   
   public static void main(String[] args) {
	  MovieManager m=new MovieManager();
	  List<MovieVO> list=m.movieAllData();
	  MovieDAO dao=new MovieDAO();
	  int k=1;
	  for(MovieVO vo:list)
	  {
		  dao.insert(vo);
		  System.out.println("k="+k);
		  k++;
	  }
   }
   
}




