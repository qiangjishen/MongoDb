package cn.cnnic.mongoTest;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;

public class TestMongoDBShards {

	public static void main(String[] args) {
		 try{
             List<ServerAddress> addresses = new ArrayList<ServerAddress>();
             ServerAddress address1 = new ServerAddress("192.168.7.49", 20000);
             ServerAddress address2 = new ServerAddress("192.168.7.50", 20000);
             ServerAddress address3 = new ServerAddress("192.168.7.75", 20000);
             addresses.add(address1);
             addresses.add(address2);
             addresses.add(address3);

             MongoClient client = new MongoClient(addresses);
             //读操作从副本节点读取  
             ReadPreference preference = ReadPreference. secondary();  

             DB db = client.getDB( "testdb4");
             DBCollection coll = db.getCollection( "table1");

             BasicDBObject object = new BasicDBObject();
             object.append( "id", 3);

             DBObject dbObject = coll.findOne(object);


             System. out .println(dbObject);

       } catch(Exception e) {
             e.printStackTrace();
       }
	}
}
