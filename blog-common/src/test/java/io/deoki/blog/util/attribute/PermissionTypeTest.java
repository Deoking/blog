package io.deoki.blog.util.attribute;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionTypeTest {

    @Test
    public void test(){
        Field[] declaredFields = PermissionType.class.getDeclaredFields();
        System.out.println("========================================");
        for (Field field : declaredFields){
            System.out.println(field.getName());
        }
    }
}