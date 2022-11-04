package org.example.Controlador;

import org.example.Service.ServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador3 {


    @Autowired
    ServiceBean serviceBean;

    // method for add new person to the list
    @GetMapping("/bean/{bean}")
    public Object insertBean(@PathVariable String bean) {
        return serviceBean.getBean(bean);
    }


}
