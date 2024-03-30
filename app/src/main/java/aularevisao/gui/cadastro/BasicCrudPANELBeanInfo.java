package aularevisao.gui.cadastro;

import java.beans.*;

public class BasicCrudPANELBeanInfo extends SimpleBeanInfo {
    
    private final static Class beanClass = BasicCrudPANEL.class;
    private static BeanDescriptor beanDescriptor = null;
    
    @Override
    public BeanDescriptor getBeanDescriptor() {
        beanDescriptor = new BeanDescriptor(beanClass);
        beanDescriptor.setDisplayName("Painel Basico de CRUD");
        
        return beanDescriptor;
    }
}