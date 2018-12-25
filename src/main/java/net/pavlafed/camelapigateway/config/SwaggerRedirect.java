package net.pavlafed.camelapigateway.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerRedirect {

    @RequestMapping("/swagger-ui")
    public String redirectToUi() {
        return "redirect:/webjars/swagger-ui/index.html?url=/api/swagger&validatorUrl=";
    }
}
