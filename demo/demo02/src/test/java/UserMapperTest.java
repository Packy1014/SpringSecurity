import com.packy.mapper.UserMapper;
import com.packy.model.Permission;
import com.packy.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindByUsername() {
        User user = userMapper.findByUsername("packy");
        System.out.println(user);
    }

    @Test
    public void testFindPermissionByUsername() {
        List<Permission> permissions = userMapper.findPermissionByUsername("packy");
        permissions.forEach((permission) -> System.out.println(permission.getPermName()));
    }

    @Test
    public void testUpdatePassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setUsername("jack");
        user.setPassword(passwordEncoder.encode("123456"));
        userMapper.updatePassword(user);
    }
}
