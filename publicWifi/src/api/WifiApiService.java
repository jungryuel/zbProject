package api;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

class WifiApiService {
    private StringBuilder urlBuilder;

    public WifiApiService() {

        try {
            urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
            urlBuilder.append("/" + URLEncoder.encode("4d59516f487a6c6434326551756a77", "UTF-8")); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
            urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8")); /*요청파일타입 (xml,xmlf,xls,json) */
            urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo", "UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public JsonArray getWifiInfo(){
        try {
            StringBuilder urlModify = new StringBuilder(urlBuilder);
            urlModify.append("/" + URLEncoder.encode(String.valueOf(1), "UTF-8"));
            urlModify.append("/" + URLEncoder.encode(String.valueOf(1000), "UTF-8"));//1부터 1000까지 한번에 불러올 수 있는게

            URL url = new URL(urlModify.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();//프로토콜이 http인 경우 반환된 객체를 캐스팅
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");//응답 콘텐츠 유형구하기
            System.out.println("Response code: " + conn.getResponseCode());//응답코드
            Charset charset = Charset.forName("UTF-8");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();

            String inputline;
            while ((inputline = br.readLine()) != null) {
                sb.append(inputline);
            }
            br.close();
            conn.disconnect();
            Gson gson = new Gson();
            JsonElement json = gson.fromJson(sb.toString(), JsonElement.class);
            JsonObject jsonObj = json.getAsJsonObject();

            JsonArray jsonArr = jsonObj.get("TbPublicWifiInfo").getAsJsonObject().get("row").getAsJsonArray();
            return jsonArr;
        } catch (Exception e) {
            System.out.println(e);
            return new JsonArray();
        }
    }
}