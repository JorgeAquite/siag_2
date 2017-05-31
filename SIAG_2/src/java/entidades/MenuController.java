/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entidades.util.JsfUtil;
import entidades.util.PagingInfo;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Aluca
 */
public class MenuController {

    public MenuController() {
        pagingInfo = new PagingInfo();
        converter = new MenuConverter();
    }
    private Menu menu = null;
    private List<Menu> menuItems = null;
    private MenuFacade jpaController = null;
    private MenuConverter converter = null;
    private PagingInfo pagingInfo = null;
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "SIAG_2PU")
    private EntityManagerFactory emf = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public MenuFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (MenuFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "menuJpa");
        }
        return jpaController;
    }

    public SelectItem[] getMenuItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getMenuItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Menu getMenu() {
        if (menu == null) {
            menu = (Menu) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentMenu", converter, null);
        }
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public String listSetup() {
        reset(true);
        return "menu_list";
    }

    public String createSetup() {
        reset(false);
        menu = new Menu();
        return "menu_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(menu);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Menu was successfully created.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("menu_detail");
    }

    public String editSetup() {
        return scalarSetup("menu_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        menu = (Menu) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentMenu", converter, null);
        if (menu == null) {
            String requestMenuString = JsfUtil.getRequestParameter("jsfcrud.currentMenu");
            JsfUtil.addErrorMessage("The menu with id " + requestMenuString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String menuString = converter.getAsString(FacesContext.getCurrentInstance(), null, menu);
        String currentMenuString = JsfUtil.getRequestParameter("jsfcrud.currentMenu");
        if (menuString == null || menuString.length() == 0 || !menuString.equals(currentMenuString)) {
            String outcome = editSetup();
            if ("menu_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit menu. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(menu);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Menu was successfully updated.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentMenu");
        java.math.BigDecimal id = new java.math.BigDecimal(idAsString);
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().remove(getJpaController().find(id));
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Menu was successfully deleted.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
        boolean ERROR = false;
        if ((ERROR)) {
            return relatedControllerOutcome;
        }
        return listSetup();
    }

    public List<Menu> getMenuItems() {
        if (menuItems == null) {
            getPagingInfo();
            menuItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return menuItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "menu_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "menu_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        menu = null;
        menuItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Menu newMenu = new Menu();
        String newMenuString = converter.getAsString(FacesContext.getCurrentInstance(), null, newMenu);
        String menuString = converter.getAsString(FacesContext.getCurrentInstance(), null, menu);
        if (!newMenuString.equals(menuString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
