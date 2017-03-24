/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: wangyunxing[wang_yx2@suixingpay.com] 
 * @date: 2017年3月22日 下午4:43:10   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.util;

/**  
 * TODO
 * @author: wangyunxing[wang_yx2@suixingpay.com]
 * @date: 2017年3月22日 下午4:43:10
 * @version: V1.0
 * @review: wangyunxing[wang_yx2@suixingpay.com]/2017年3月22日 下午4:43:10
 */
public class StringToArrayUtil {
    public static  int[] stringTointArray(String str){
        String[] split = str.split(",");
        int[] ints=new int[split.length];

        for (int i = 0; i < split.length; i++) {
            ints[i]=Integer.valueOf(split[i]);
        }
        return ints;
    }

}
