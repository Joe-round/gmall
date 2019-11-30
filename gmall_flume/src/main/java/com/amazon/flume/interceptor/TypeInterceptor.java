package com.amazon.flume.interceptor;


import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类型拦截器
 *
 * @Author qiao
 * @Date 2019/11/29 18:49
 * @Version 1.0
 */
public class TypeIntercepor implements Interceptor {


    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {

        byte[] body = event.getBody();

        String log = new String(body, Charset.forName("UTF-8"));

        Map<String, String> headers = event.getHeaders();

        if (log.contains("start")){
            headers.put("topic","topic_start");
        }else {
            headers.put("topic","topic_event");
        }


        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        ArrayList<Event> interceptors = new ArrayList<>();

        for (Event event : interceptors) {
            Event intercept = intercept(event);
            interceptors.add(intercept);
        }


        return interceptors;
    }

    @Override
    public void close() {

    }
}
