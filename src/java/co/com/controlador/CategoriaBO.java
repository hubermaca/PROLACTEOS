package co.com.controlador;

import co.com.entidades.Categoria;
import co.com.modelo.CategoriaDaoJpa;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//mensaje pruebaFFdgfvsdghf

/**
 *
 * @author jj
 */
@ManagedBean(name = "categoriaBO")
@SessionScoped

public class CategoriaBO {

    private Categoria categoria;
    private CategoriaDaoJpa categoriaDaoJpa;
    private List<Categoria> listCategorias;
    private Categoria seleccionarCategoria;
    
//constructor
    public CategoriaBO() {
        categoriaDaoJpa = new CategoriaDaoJpa();
        init();
    }

    private void init() {
        categoria = new Categoria();
        listCategorias=categoriaDaoJpa.listAll();
        seleccionarCategoria= new Categoria();

                }
                
    public String agregarCategoria() {
        categoriaDaoJpa.crearCategoria(categoria);
         init();
        return null;
      
    }
    
    
    
    
    
    
//    set y get

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaDaoJpa getCategoriaDaoJpa() {
        return categoriaDaoJpa;
    }

    public void setCategoriaDaoJpa(CategoriaDaoJpa categoriaDaoJpa) {
        this.categoriaDaoJpa = categoriaDaoJpa;
    }

    public List<Categoria> getListCategorias() {
        return listCategorias;
    }

    public void setListCategorias(List<Categoria> listCategorias) {
        this.listCategorias = listCategorias;
    }

    public Categoria getSeleccionarCategoria() {
        return seleccionarCategoria;
    }

    public void setSeleccionarCategoria(Categoria seleccionarCategoria) {
        this.seleccionarCategoria = seleccionarCategoria;
    }
    
    
    
    
    
    

}
