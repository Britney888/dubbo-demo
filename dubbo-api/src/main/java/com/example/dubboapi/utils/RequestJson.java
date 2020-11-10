package com.example.dubboapi.utils;
import com.example.dubboapi.common.ProtocolsChannelType;
import com.example.dubboapi.request.ProtocolsJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class RequestJson implements ProtocolsJson {
    private static final long serialVersionUID = -2110690815442621688L;
    protected Map<String, String> heads = new HashMap();
    protected Map<String, String> cookie = new HashMap();

    public RequestJson() {
    }

    public void setProtocal(ProtocolsChannelType protocal) {
        this.heads.put("protocal", protocal.getCode());
    }

    public abstract String getContentType();

    public abstract void addParam(String var1, String var2);

    public abstract void addParams(String var1, String[] var2);

    public abstract String[] getParams(String var1);

    public abstract String getParam(String var1);

    public abstract List<String> getParamKeyss();

    public void addHead(String headKey, String headVal) {
        this.heads.put(headKey, headVal);
    }

    public void addHeads(Map<String, String> _heads) {
        this.heads.putAll(_heads);
    }

    public Map<String, String> getHeads() {
        return this.heads;
    }

    public void addCookie(String key, String headVal) {
        this.cookie.put(key, headVal);
    }

    public Map<String, String> getCookies() {
        return this.cookie;
    }
}

