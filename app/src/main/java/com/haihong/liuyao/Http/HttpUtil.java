package com.haihong.liuyao.Http;

import android.content.Context;

import com.haihong.liuyao.lyapp.R;
import com.loopj.android.http.*;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by lichanghong on 6/4/16.
 */
public class HttpUtil {
    private static AsyncHttpClient client = new AsyncHttpClient();
    static
    {
        client.setTimeout(5000);   //设置链接超时，如果不设置，默认为10s
    }

    public static void get(String url, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }
    private static String getAbsoluteUrl(String relativeUrl) {
        return relativeUrl;
    }
    public static AsyncHttpClient getClient()
    {
        return client;
    }

    //------------------- url --
    public static String getGanZhiURL(Context context)
    {
        return context.getString(R.string.ganzhiURL);
    }

    public static String  getUrl(HashMap<String, String> params) {
        // 添加url参数
        StringBuilder stringBuilder = new StringBuilder();
        if (params != null) {
            Iterator<String> it = params.keySet().iterator();
            StringBuffer sb = null;
            while (it.hasNext()) {
                String key = it.next();
                String value = params.get(key);
                if (sb == null) {
                    sb = new StringBuffer();
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(key);
                sb.append("=");
                sb.append(value);
            }
            stringBuilder.append(sb.toString());
        }
        final String encodedURL = URLEncoder.encode(stringBuilder.toString());
        return encodedURL;
    }

}
