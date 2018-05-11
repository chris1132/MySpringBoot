package com.boot1.chovy.util;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 类描述：证书信任管理器（用于https请求）编写证书过滤器
 * Created by wangchaohui on 2018/5/10.
 * */
public class MyX509TrustManager implements X509TrustManager{	
	/**
	 * 该方法体为空时信任所有客户端证书(检查客户端证书)
	 */
	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {	
	}
	
	/**
	 * 该方法体为空时信任所有服务器证书 (检查服务器证书)
	 */
	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {	
	}
	
	/**返回信任的证书
	 * @return   
	 */
	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}
