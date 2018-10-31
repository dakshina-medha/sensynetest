import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.InputStream;

public class sensyneapitest {

    private static String getProductsURL = "http://localhost:5000/v1/products";
    private static String addProductURL = "http://localhost:5000/v1/product";

    private static HttpResponse<JsonNode> response;

    private static String name = "";
    private static Double price;


    public static void getProducts() throws UnirestException {

        sensyneapitest.response = Unirest.get(getProductsURL).asJson();

        }

        public static Boolean areproductsAvailable(){
         System.out.println("Status -->" + response.getStatus());
         System.out.println("getProducts reponse body -->" + response.getBody());
         return response.getStatus()==200;

        }

    public static void addProduct(String name, Double price) throws UnirestException {

        sensyneapitest.name = name;
        sensyneapitest.price = price;

        HttpResponse<InputStream> response = Unirest.post(addProductURL)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body("name="+name+"&price="+price)
                .asBinary();
        System.out.println("Add status -->" + response.getStatus());

    }

    public static Boolean verifyRecordAdded() throws UnirestException {
        Boolean flag = false;
        HttpResponse<JsonNode> output =  Unirest.get(getProductsURL).asJson();
        JSONArray jsonArray = output.getBody().getArray();

        String[] names = new String[jsonArray.length()];
        String[] prices = new String[jsonArray.length()];

        System.out.println("Values stored  "+name + " "+price);
        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            names [i] = jsonObject.getString("name");
            prices [i] = jsonObject.getString("price");

            System.out.println("name: "+names[i]);
            System.out.println("price: "+prices[i]);
            if(names[i].equals(name) && prices[i].contains(price.toString())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void updateRecord(String prod_id,String name, Double price_update) throws UnirestException {

        sensyneapitest.name = name;
        sensyneapitest.price = price_update;

        HttpResponse<InputStream> response = Unirest.put(addProductURL+"/"+prod_id)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body("name="+name+"&price="+price_update)
                .asBinary();
        System.out.println("Update status -->" + response.getStatus());
    }

    public static void deleteRecord(String prod_id) throws UnirestException {

        HttpResponse<InputStream> response = Unirest.delete(addProductURL+"/"+prod_id)
                .asBinary();
        System.out.println("Delete status -->" + response.getStatus());
        Assert.assertEquals("Delete Response code is not 200", 200, response.getStatus());
    }

   public static Boolean verifyRecordDeleted(int prod_id) throws UnirestException {
        Boolean flag = true;
        HttpResponse<JsonNode> output =  Unirest.get(getProductsURL).asJson();
        JSONArray jsonArray = output.getBody().getArray();

        int[] productIds = new int[jsonArray.length()];

        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            productIds [i] = jsonObject.getInt("id");

           if(productIds[i]==prod_id){
                flag = false;
                break;
            }
        }
        return flag;
    }

}


