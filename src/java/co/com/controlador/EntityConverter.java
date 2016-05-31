/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.controlador;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.context.RequestContext;



@SuppressWarnings("serial")
@FacesConverter(value = "entityConverter")
public class EntityConverter implements Converter, Serializable {

    // private static final Logger log = Logger
    // .getLogger(EntityConverter.class.getSimpleName());
    private static final String key = "com.hds.vpm.bandejas.utilidad.EntityConverter";
    private static final String empty = "";

    private Map<String, Object> getViewMap(FacesContext context) {
	Map<String, Object> viewMap = context.getViewRoot().getViewMap();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Map<String, Object> idMap = (Map) viewMap.get(key);
	if (idMap == null) {
	    idMap = new HashMap<String, Object>();
	    viewMap.put(key, idMap);
	}
	return idMap;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent c, String value) {
	if (value.isEmpty()) {
	    return null;
	}
	return getViewMap(context).get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent c, Object value) {
	if (value == null) {
	    return empty;
	}
	String id = value.toString();
	getViewMap(context).put(id, value);
	return id;
    }

/**
 * Codigo para actualizar desde el controlador
 */
    public static void ejecutarUpdate(String id) {
		final RequestContext context = RequestContext.getCurrentInstance();
		context.update(id);
	}


public static UIComponent buscarHtmlComponete(String idComponete) {
		final FacesContext context = FacesContext.getCurrentInstance();
		if (null != context) {
			return buscarHtmlComponete(context.getViewRoot(), idComponete);
		}
		return null;
	}



public static UIComponent buscarHtmlComponete(UIComponent parent,
			String idComponete) {
		if (idComponete.equals(parent.getId())) {
			return parent;
		}
		final Iterator<UIComponent> kids = parent.getFacetsAndChildren();
		while (kids.hasNext()) {
			final UIComponent kid = kids.next();
			final UIComponent found = buscarHtmlComponete(kid, idComponete);
			if (found != null) {
				return found;
			}
		}
		return null;
	}
    
    
    
}