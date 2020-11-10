package com.example.dubboapi.common;
public enum ProtocolsChannelType {
    HTTP("HTTP", "HTTP"),
    HTTPS("HTTPS", "HTTPS"),
    MQ("MQ", "MQ");

    private String code;
    private String msg;

    private ProtocolsChannelType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public static ProtocolsChannelType getByCode(String code) {
        ProtocolsChannelType[] arr$ = values();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            ProtocolsChannelType menuActionType = arr$[i$];
            if (menuActionType.getCode() == code) {
                return menuActionType;
            }
        }

        return null;
    }
}

