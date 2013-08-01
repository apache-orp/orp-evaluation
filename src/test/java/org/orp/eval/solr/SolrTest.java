package org.orp.eval.solr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

import junit.framework.TestCase;


public class SolrTest extends TestCase{
	
	public void testSolr() 
			throws HttpException, IOException{
		String url = "http://localhost:9090/solr/schema";
		GetMethod get = new GetMethod(url);
		new HttpClient().executeMethod(get);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte[] arr = new byte[1024];
		int c = 0;
		while((c = get.getResponseBodyAsStream()
				.read(arr, 0, arr.length)) > 0){
			os.write(arr, 0, c);
		}
		System.out.println(new String(os.toByteArray(), "UTF-8"));
		System.out.println("Hello");
	}
}
