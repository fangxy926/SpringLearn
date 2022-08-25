package com.example.springbootlearn;

import com.example.springbootlearn.transaction.entity.User1;
import com.example.springbootlearn.transaction.entity.User2;
import com.example.springbootlearn.transaction.service.User1Service;
import com.example.springbootlearn.transaction.service.User2Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {

    @Autowired
    private User1Service user1Service;

    @Autowired
    private User2Service user2Service;


    /**
     * 场景1.1：REQUIRED 外围方法没有开启事务。
     */

    @Test
    public void notransaction_exception_required_required() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();

        // 结果：user1和user2都插入成功
    }

    @Test
    public void notransaction_required_required_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiredException(user2);

        // 结果：user1插入成功，user2插入失败
    }

    /**
     * 场景1.2：REQUIRED 外围方法开启事务
     */

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_exception_required_required() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();
        // 结果：user1和user2都插入失败
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_required_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiredException(user2);

        // 结果：user1和user2都插入失败
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_required_exception_try() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        try {
            user2Service.addRequiredException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
        // 结果：user1和user2都插入失败
    }

    /**
     * 场景2.1：REQUIRES_NEW 外围方法没有开启事务
     */
    @Test
    public void notransaction_exception_requiresNew_requiresNew() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequiresNew(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiresNew(user2);
        throw new RuntimeException();
        // 结果：user1和user2都插入成功
    }

    @Test
    public void notransaction_requiresNew_requiresNew_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequiresNew(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiresNewException(user2);
        // 结果：user1插入成功，user2插入失败
    }

    /**
     * 场景2.2：REQUIRES_NEW 外围方法开启事务
     */
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_exception_required_requiresNew_requiresNew() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiresNew(user2);

        User2 user3 = new User2();
        user3.setName("王五");
        user2Service.addRequiresNew(user3);
        throw new RuntimeException();
        // 结果：张三插入失败，李四、王五插入成功
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_requiresNew_requiresNew_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiresNew(user2);

        User2 user3 = new User2();
        user3.setName("王五");
        user2Service.addRequiresNewException(user3);
        // 结果：李四插入成功， 张三、王五插入失败
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_requiresNew_requiresNew_exception_try() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiresNew(user2);
        User2 user3 = new User2();
        user3.setName("王五");
        try {
            user2Service.addRequiresNewException(user3);
        } catch (Exception e) {
            System.out.println("回滚");
        }
        // 结果：李四插入成功， 张三、王五插入失败
    }

    /**
     * 场景3.1 NESTED 外围方法没有开启事务
     */
    @Test
    public void notransaction_exception_nested_nested() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addNested(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addNested(user2);
        throw new RuntimeException();

        // 结果：张三、李四都插入成功
    }

    @Test
    public void notransaction_nested_nested_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addNested(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addNestedException(user2);
        // 张三插入成功、李四插入失败

    }

    @Test
    public void notransaction_nested_nested_exception_try() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addNested(user1);
        try {
            User2 user2 = new User2();
            user2.setName("李四");
            user2Service.addNestedException(user2);
        } catch (Exception e) {
            System.out.println("回滚");
        }
        // 结果： 张三插入成功、李四插入失败
    }


    /**
     * 场景3.2 NESTED 外围存在事务
     */
    @Test
    @Transactional
    public void transaction_exception_nested_nested() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addNested(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addNested(user2);
        throw new RuntimeException();
        // 结果：张三、李四都插入失败
    }

    @Transactional
    @Test
    public void transaction_nested_nested_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addNested(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addNestedException(user2);
        // 结果：张三、李四都插入失败
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_nested_nested_exception_try() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addNested(user1);

        try {
            User2 user2 = new User2();
            user2.setName("李四");
            user2Service.addNestedException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
        // 结果：张三、李四都插入失败
    }
}
