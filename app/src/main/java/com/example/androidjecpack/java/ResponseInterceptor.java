package com.example.androidjecpack.java;

import android.text.TextUtils;
import android.util.Log;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;



public class ResponseInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final String CACHE_DATA = "cacheData";
    private static final int REQUEST_SUCCEED = 200;

    private static final String TAG = "ResponseInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        ResponseBody responseBody = response.body();
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.buffer();
        String bodyStr = buffer.clone().readString(UTF8);
        //
        printLog(request, response, bodyStr);
        return response;
    }





    private void printLog(Request request, Response response, String bodyStr) {
//        if (BuildConfig.DEBUG) {
            String header = request.headers().toString();
            RequestBody body = request.newBuilder().build().body();
            Log.e(TAG,"okhttp:" + "\n"
                    + "method --> " + request.method() + "  code --> " + response.code() + "\n"
                    + "url:" + request.url() + "\n"
                    + "{" + header.toString() + "}"
                    + "\n");
            if (body != null) {
               Log.e(TAG,"body:" + bodyToString(body));
            }
            String message = response.message();
            if (CACHE_DATA.equals(message)) {
                Log.e(TAG,"返回数据来源( 缓存数据 )-->" + bodyStr);
            } else {
                Log.e(TAG,"返回数据来源( 网络数据 )-->" + bodyStr);
            }

//        }
    }


    private String bodyToString(RequestBody body) {
        try {
            final RequestBody copy = body;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }
}
