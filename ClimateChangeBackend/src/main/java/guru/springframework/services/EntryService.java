package guru.springframework.services;

import java.util.List;

import guru.springframework.domain.Entry;



public interface EntryService {

	
    List<Entry> listAll();

    Entry getById(Long id);

    Entry saveOrUpdate(Entry entry);

    void delete(Long id);

//    Entry saveOrUpdateProductForm(EntryForm productForm);

}
