package Test;

import org.junit.Test;
import org.springframework.util.ClassUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class ResourceTest {
    @Test
    public void test() {
        Random random=new Random();
        StringBuilder sb = new StringBuilder(LocalDateTime.now().toString());
        System.out.println(sb.toString());
        for(int i=0;i<sb.length();i++){
            char cur=sb.charAt(i);
            if(cur=='-'||cur==':'||cur=='.'){
                cur=(char)('A'+random.nextInt(26));
                sb.replace(i,i+1,String.valueOf(cur));
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
