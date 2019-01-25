package net.pavlafed.camelapigateway.validators;

import net.pavlafed.camelapigateway.model.Order;
import org.apache.camel.Message;
import org.apache.camel.ValidationException;
import org.apache.camel.spi.DataType;
import org.apache.camel.spi.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderValidator extends Validator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderValidator.class);

    public void validate(Message message, DataType type) throws ValidationException {
        boolean pass = false;
        Object body = message.getBody();
        LOG.info("Validating : [{}]", body);
        if (body instanceof Order) {
            Order order = (Order) body;
            if (order.getQty().compareTo(BigDecimal.ZERO) > 0) {
                LOG.info("OK");
                pass = true;
            }
        }
        if (!pass) {
            throw new ValidationException(message.getExchange(), "Negative qty");
        }
    }
}
