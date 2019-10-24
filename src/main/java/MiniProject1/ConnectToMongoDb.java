package MiniProject1;

import java.net.UnknownHostException;
import java.util.Scanner;
import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.BasicDBObject;
import com.mongodb.Mongo;
import com.mongodb.DB;

public class ConnectToMongoDb {
	public static void main(String[] args) {
		try {
			/*
			 * This configuration is the following youtube video
			 * https://www.youtube.com/watch?v=pDiqTmTVG9o
			 * 
			 * */
			// Connect to MongoClient localhost 27017.
			MongoClient mongoClient = new MongoClient("localhost",27017);
			System.out.println("Connected to localhost MongoDB!");
			// Connect to MongoDB local and startup_log collection.
			DB dataBase = mongoClient.getDB("local");
			// Connect to dataBaseCollection.
			DBCollection collection = dataBase.getCollection("startup_log");
			// Connect to DBCursor.
			DBCursor cursor=collection.find();
			// Print all the data of the collection.
			while (cursor.hasNext()) {
				// Not sure about what is the role of int i in this case.
				// It works without the i implementation.
				int i = 1;
				System.out.println(cursor.next());
				i++;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}