package com.pxd.common.base.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Whether {

    NO(0),
    YES(1),

    ;

    private int code;

}
