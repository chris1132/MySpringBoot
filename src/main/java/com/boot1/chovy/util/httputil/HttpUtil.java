package com.boot1.chovy.util.httputil;

import com.boot1.chovy.util.JSONUtil;
import com.boot1.chovy.util.MyX509TrustManager;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

/**
 * Created by wangchaohui on 2018/5/11.
 */
public class HttpUtil {
    private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * ����https���󲢻�ȡ���
     *
     * @param requestUrl    �����ַ
     * @param requestMethod ����ʽ��GET��POST��
     * @param outputStr     �ύ������
     * @return JSONObject (ͨ��JSONObject.get(key)�ķ�ʽ��ȡjson���������ֵ)
     */
    public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
        String resJson = "";

        try {
            //����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��(֤�����)
            TrustManager[] tm = {new MyX509TrustManager()};
            //ȡ��SSL��SSLContextʵ��
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            //��ʼ��SSLContext
            sslContext.init(null, tm, new java.security.SecureRandom());
            //������SSLContext�����еõ�SSLSocketFactory����
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            //��������ʽ��GET/POST��
            httpUrlConn.setRequestMethod(requestMethod);

	        /*if ("GET".equalsIgnoreCase(requestMethod))
	            httpUrlConn.connect();   */
            //����������Ҫ�ύʱ(��outputStr��Ϊnullʱ���������д����)
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // ע������ʽ����ֹ��������
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // �����ص�������ת�����ַ���
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            //�ͷ���Դ
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            resJson = buffer.toString();
        } catch (ConnectException ce) {
            log.error("���ӳ�ʱ: {}", ce);
        } catch (Exception e) {
            log.error("https�����쳣: {}", e);
        }
        return resJson;
    }

}
