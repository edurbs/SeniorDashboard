package com.mexum.dashboard.app.domain;

public enum YesNo {
    S,
    N;

    public boolean isYes(){
        return this == S;
    }

    public boolean isNo(){
        return this == N;
    }

}
