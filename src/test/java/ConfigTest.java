import com.imooc.RabbitMqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqConfig.class)
public class ConfigTest {
    @Test
    public void contextLoads() {
    }

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Test
    public void testAdmin() throws Exception {
        rabbitAdmin.declareExchange(new DirectExchange("test.direct", false, false));
        rabbitAdmin.declareQueue(new Queue("test.queue", false));
        rabbitAdmin.declareBinding(new Binding("test.queue",
                Binding.DestinationType.QUEUE, "test.direct", "direct",
                new HashMap<String, Object>()));
    }

}
