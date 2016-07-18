package util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by navaneeth.basavaraj on 7/9/2016.
 */
public class HttpUtil {


	public String post(String uri){
		HttpPost httpPost;
		HttpClient client;
		HttpResponse response = null;
		try {
			httpPost = new HttpPost(uri);
			client = HttpClients.createDefault();
			response = client.execute(httpPost);
		}catch (Exception ex){
			System.out.println(ex);
		}
		return response.toString();
	}

	public String get(String uri){
		HttpGet httpGet;
		HttpClient client;
		HttpResponse response = null;
		try {
			httpGet = new HttpGet(uri);
			client = HttpClients.createDefault();
			//httpGet.addHeader("User-Agent", USER_AGENT);
			response = client.execute(httpGet);
			String responseBody = EntityUtils.toString(response.getEntity());
			System.out.println(responseBody);
			return responseBody;
		}catch (Exception ex){
			System.out.println(ex);
		}
		return null;
	}

	public String getCon(String uri) throws Exception{
		URL obj = new URL(uri);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 con.setRequestMethod("GET");
		return  con.getResponseMessage();
		}

	public String  createRequest(List<NameValuePair> params, String uri){
		StringBuilder sb = new StringBuilder(uri);
		sb.append("?");

		for(NameValuePair param : params){
			sb.append(param.getName()+ "=" + param.getValue() + "&");
		}
		return sb.toString().substring(0, sb.toString().lastIndexOf("&"));

	}

}
