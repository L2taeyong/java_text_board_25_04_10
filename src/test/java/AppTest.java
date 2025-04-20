import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AppTest {
  public static void main(String[] args) {
    String url = " /usr/article/write?subject=자바는 무엇인가요?&content=자바는 객체지향 프로그래밍 언어입니다.1+2=3&writerName=오애순&boardId=1&id=\"";
    Map<String, String> params = Util.getParams(url);

    System.out.println(params.get("subject"));
    System.out.println(params.get("content"));
    System.out.println(params.get("writerName"));
    System.out.println(params.get("boardId"));
  }
}

class Util {
 static Map getParams(String url) {
   Map<String,String> params = new HashMap<>();

   String[] urlBits = url.split("\\?", 2);

   if(urlBits.length == 1) return params;

   String queryStr = urlBits[1];

   for(String bit : queryStr.split("&")) {
     String[] bits = bit.split("=",2);

     if(bits.length == 1) continue;

     params.put(bits[0], bits[1]);
   }


   return params;
  }
}