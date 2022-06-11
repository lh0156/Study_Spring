package hello.core.pratice.component;

import org.springframework.stereotype.Component;

@Component()
public class ComponentClass {

    public void save() {
        System.out.println("세이브합니다.");
    }

    public void join() {
        System.out.println("조인 합니다.");
    }
}
