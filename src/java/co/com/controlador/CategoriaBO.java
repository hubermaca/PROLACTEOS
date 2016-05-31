
package co.com.controlador;

import co.com.entidades.Categoria;
import co.com.modelo.CategoriaDaoJpa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//mensaje pruebaFF
/**
 *
 * @author jj
 */

@ManagedBean(name = "categoriaBO")
@SessionScoped

public class CategoriaBO {
private Categoria categoria;
private CategoriaDaoJpa categoriaDaoJpa;
    


    
}
