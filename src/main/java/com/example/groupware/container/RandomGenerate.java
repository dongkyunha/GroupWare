package com.example.groupware.container;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.security.SecureRandom;

@Data
@EqualsAndHashCode(callSuper = false)
public class RandomGenerate {
    
    //난수 생성 클래스
    private static SecureRandom random = new SecureRandom();

    /** 랜덤 문자열을 생성한다 **/
    public static String generate(String DATA, int length) {
        if (length < 1){
            throw new IllegalArgumentException("length must be a positive number.");
        }
        System.out.println("DATA_FOR_RANDOM_STRING ==> " + DATA);

        random.setSeed(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(
                    DATA.charAt(random.nextInt(DATA.length())
            ));
        }
        return sb.toString();
    }

}
