package com.me.common.util;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Created by C167 on 2016/2/29.
 */
public class AssertUtil {
    public static  void assertNotNull(Object o){
        assertThat(o).isNotNull();
    }
    public static  void assertIsNull(Object o){
        assertThat(o).isNull();
    }
    public static  void assertIsTrue(Object o){
        assertThat(o).isEqualTo(true);
    }
}
