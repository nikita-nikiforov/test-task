package app;

import app.service.ConsoleService;
import app.service.DepartmentService;
import app.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    LectorService lectorService;

    @Autowired
    ConsoleService consoleService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources(Application.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
        Application app = context.getBean(Application.class);
        app.start();
    }

    private void start() {
        consoleService.start();
    }
}
