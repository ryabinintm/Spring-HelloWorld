import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());

        // В классе App, по аналогии, вызовите еще раз бин HelloWorld,
        // затем 2 раза вызовите бин cat. Сравните 2 пары бинов по ссылке
        // и выведите результат в консоль. Для пары HelloWorld должно вернуться true,
        // для cat - false. Так вы можете увидеть результат того, как работает наш контейнер.
        HelloWorld bean2 =
                (HelloWorld) applicationContext.getBean("helloworld");
        Cat catBean1 = applicationContext.getBean(Cat.class);
        Cat catBean2 = applicationContext.getBean(Cat.class);
        System.out.printf("Для пары HelloWorld должно вернуться true: %b%n", bean == bean2);
        System.out.printf("Для пары Cat должно вернуться false: %b%n", catBean1 == catBean2);
    }
}