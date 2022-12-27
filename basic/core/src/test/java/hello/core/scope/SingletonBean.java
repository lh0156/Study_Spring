package hello.core.scope;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonBean {

    public final SingletonWithPrototypeTest1.PrototypeBean prototypeBean;

    @Autowired
    SingletonBean(SingletonWithPrototypeTest1.PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }





}
