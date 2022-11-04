package org.example.Service;

import org.example.Configuration.ConfigurationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServiceBean {


    @Autowired
    ConfigurationBean configurationBean;

    public Object getBean(String bean) {

        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
        context.register(ConfigurationBean.class);
        context.refresh();

        Object person = context.getBean(bean);

        return person;
    }
}
