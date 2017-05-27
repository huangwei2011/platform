package org.hw.asynchttp;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	  public static void main(String[] argv) {
//	        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
//	        httpclient.start();
//
//	        final CountDownLatch latch = new CountDownLatch(1);
//	        final HttpGet request = new HttpGet("https://www.alipay.com/");
//
//	        System.out.println(" caller thread id is : " + Thread.currentThread().getId());
//
//	        httpclient.execute(request, new FutureCallback<HttpResponse>() {
//
//	            public void completed(final HttpResponse response) {
//	                latch.countDown();
//	                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
//	                System.out.println(request.getRequestLine() + "->" + response.getStatusLine());
//	                try {
//	                    String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//	                    System.out.println(" response content is : " + content);
//	                } catch (IOException e) {
//	                    e.printStackTrace();
//	                }
//	            }
//
//	            public void failed(final Exception ex) {
//	                latch.countDown();
//	                System.out.println(request.getRequestLine() + "->" + ex);
//	                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
//	            }
//
//	            public void cancelled() {
//	                latch.countDown();
//	                System.out.println(request.getRequestLine() + " cancelled");
//	                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
//	            }
//
//	        });
//	        try {
//	            latch.await();
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//
//	        try {
//	            httpclient.close();
//	        } catch (IOException ignore) {
//
//	        }
//		
		  testnsy();
	    }
	  
	  public static void testnsy()
	  {
		  CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
	        httpclient.start();

	        final CountDownLatch latch = new CountDownLatch(1);
	        final HttpGet request = new HttpGet("http://192.168.34.26:8080/start/");

	        System.out.println(" caller thread id is : " + Thread.currentThread().getId());

	        httpclient.execute(request, new FutureCallback<HttpResponse>() {

	            public void completed(final HttpResponse response) {
	                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
	                System.out.println(request.getRequestLine() + "->" + response.getStatusLine());
	                try {
	                    String content = EntityUtils.toString(response.getEntity(), "UTF-8");
	                    System.out.println(" response content is : " + content);
	                    Thread.sleep(2000);
	                    latch.countDown();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }

	            public void failed(final Exception ex) {
	                latch.countDown();
	                System.out.println(request.getRequestLine() + "->" + ex);
	                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
	            }

	            public void cancelled() {
	                latch.countDown();
	                System.out.println(request.getRequestLine() + " cancelled");
	                System.out.println(" callback thread id is : " + Thread.currentThread().getId());
	            }

	        });
	        try {
	        	System.out.println(1);
	            latch.await();
	            System.out.println(2);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        try {
	            httpclient.close();
	        } catch (IOException ignore) {

	        }
	    
	  }
}
