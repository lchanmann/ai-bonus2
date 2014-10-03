package ai.core.impl;

import ai.core.Result;

public class Failure implements Result {

    private String reason;

    public Failure(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ").append(reason).append(" ]");
        return sb.toString();
    }
}
