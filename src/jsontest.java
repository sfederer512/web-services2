import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.json.JSONArray;
//import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public class jsontest {
    private static JSONTokener jsonOut;

    public static void main(String myHelpers[]) throws JSONException, IOException {
        String h="/home/saeed/NetBeansProjects/JavaApplication10/src/peaple.json";
               JSONObject req;
        req = new JSONObject(readFile(h));
        JSONObject locs = req.getJSONObject("Userr");

        JSONArray recs = locs.getJSONArray("User");

        for (int i = 0; i < recs.length(); ++i) {
    JSONObject rec = recs.getJSONObject(i);
    int id = rec.getInt("Id");
    System.out.println("\tUser Id:"+id);
    String loc = rec.getString("name");
        System.out.println("\tName: "+loc);
         String born = rec.getString("born");
        System.out.println("\tborn:" +born);
         String address = rec.getString("address");
        System.out.println("\taddress:" +address);
         String nationality = rec.getString("nationality");
        System.out.println("\tnationality:" +nationality);
         String tel = rec.getString("tel");
        System.out.println("\ttel:" +tel);
         String friendsip = rec.getJSONObject("friendsip").getString("friend");
        System.out.println("\tfriendsip:" +friendsip);
        System.out.println("\n");

    
}
             

                 
            
        
            
    }

    private static String readFile(String file) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        return stringBuilder.toString();
    }

}

    