
import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.system.service.SynthesizeLoginService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-dubbo-consumer.xml")
public class Test {

    @Autowired
    private SynthesizeLoginService synthesizeLoginService;

    @org.junit.Test
    public void test() throws IOException {
        Account account = synthesizeLoginService.findAccountByTel("156");
        System.out.println(account.getAccountPassword());
    }


}
