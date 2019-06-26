package guru.springframework.controllers;

import guru.springframework.commands.ProductForm;
import guru.springframework.converters.ProductToProductForm;
import guru.springframework.domain.Entry;
import guru.springframework.domain.Product;
import guru.springframework.services.EntryService;
import guru.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class ProductController {
    private ProductService productService;

    private ProductToProductForm productToProductForm;
	private EntryService entryService;

	@Autowired
	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}

    @Autowired
    public void setProductToProductForm(ProductToProductForm productToProductForm) {
        this.productToProductForm = productToProductForm;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/product/list";
    }

    @RequestMapping({"/entry/list", "/entry"})
    public String listEntries(Model model){
        model.addAttribute("entries", entryService.listAll());
        return "entries/list";
    }

    
    @RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "productes/list";
    }

    @RequestMapping("/entry/show/{id}")
    public String getEntry(@PathVariable String id, Model model){
    	System.out.println("/entry/show/{id}, " + id + " result: " + entryService.getById(Long.valueOf(id)));
        model.addAttribute("entry", entryService.getById(Long.valueOf(id)));
        return "entries/result";
    }

    
    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("product", productService.getById(Long.valueOf(id)));
        return "productes/show";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Product product = productService.getById(Long.valueOf(id));
        ProductForm productForm = productToProductForm.convert(product);

        model.addAttribute("productForm", productForm);
        return "productes/productform";
    }

    @RequestMapping("entry/edit/{id}")
    public String editEntry(@PathVariable String id, Model model){
        Entry entry = entryService.getById(Long.valueOf(id));
        //ProductForm productForm = productToProductForm.convert(product);

        model.addAttribute("entryForm", entry);
        return "entries/entryform";
    }

    
    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm", new ProductForm());
        return "productes/productform";
    }

    @RequestMapping("/entry/new")
    public String newEntry(Model model){
        model.addAttribute("entryForm", new Entry());
        return "entries/entryform";
    }

    @RequestMapping(value = "/entry", method = RequestMethod.POST)
    public String saveOrUpdateEntry(@Valid Entry entry, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "entries/entryform";
        }

        System.out.println(entry);
        
        Entry savedEntry = entryService.saveOrUpdate(entry);

        return "redirect:/entry/show/" + savedEntry.getId();
    }

    
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid ProductForm productForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "productes/productform";
        }

        Product savedProduct = productService.saveOrUpdateProductForm(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        productService.delete(Long.valueOf(id));
        return "redirect:/productes/list";
    }
}
