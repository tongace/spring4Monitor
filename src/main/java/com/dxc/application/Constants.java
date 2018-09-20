package com.dxc.application;

public final class Constants {
    public static enum ACTIVE_FLAG{
        ACTIVE {
            public String toString() {
                return "Y";
            }
        },
        INACTIVE {
            public String toString() {
                return "N";
            }
        },
    }
}
