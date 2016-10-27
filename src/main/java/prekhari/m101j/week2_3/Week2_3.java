package prekhari.m101j.week2_3;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static prekhari.m101j.week2_3.Helpers.printJson;
/**
 * Created by ppcv on 10/26/2016.
 */
public class Week2_3 {

    public static  void main(String[] args) {
       // init the mongoclient class
        MongoClient client = new MongoClient();
        MongoDatabase stu = client.getDatabase("students");
        Bson sort = new Document("student_id",1).append("score",1);
        List<Document> grades = stu.getCollection("grades").find(new Document("type","homework")).sort(sort).into(new ArrayList<Document>());
        System.out.println(stu.getCollection("grades").count());
        for ( Document doc: grades) {
            stu.getCollection("grades").deleteOne(doc);
        }
        for ( Document doc: grades) {
            System.out.println(stu.getCollection("grades").count());
        }

    }
}
