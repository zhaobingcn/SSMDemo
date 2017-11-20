import com.ssm.app.SpringBootSSMApplication;
import com.ssm.app.domain.User;
import com.ssm.app.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhzy on 2017/11/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootSSMApplication.class)

public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        userMapper.insert(100, "admin", 50, "qeqweqw");
        User u = userMapper.findByName("admin");
        Assert.assertEquals(u.getAge().intValue(), 50);
    }

    @Test
    public void delete(){
        userMapper.delete("admin");
    }
}
