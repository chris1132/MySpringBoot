package com.boot1.chovy.util;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * ��������֤�����ι�����������https���󣩱�д֤�������
 * Created by wangchaohui on 2018/5/10.
 */
public class MyX509TrustManager implements X509TrustManager {
    /**
     * �÷�����Ϊ��ʱ�������пͻ���֤��(���ͻ���֤��)
     */
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    /**
     * �÷�����Ϊ��ʱ�������з�����֤��?(��������֤��)
     */
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    /**
     * �������ε�֤��
     * ?*?@return???
     * ?
     */
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
