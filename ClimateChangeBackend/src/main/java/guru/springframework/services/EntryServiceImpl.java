package guru.springframework.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.converters.ProductFormToProduct;
import guru.springframework.domain.Entry;
import guru.springframework.repositories.EntryRepository;
import guru.springframework.repositories.ProductRepository;


@Service
public class EntryServiceImpl implements EntryService {

    private EntryRepository entryRepository;
//    private ProductFormToProduct productFormToProduct;

    @Autowired
    public EntryServiceImpl(EntryRepository entryRepository) {
    	this.entryRepository = entryRepository;
    }
	
	@Override
	public List<Entry> listAll() {
        List<Entry> products = new ArrayList<>();
        entryRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
	}

	@Override
	public Entry getById(Long id) {
		System.out.println("try to find id: " + id);
        return entryRepository.findById(id).orElse(null);
	}

	@Override
	public Entry saveOrUpdate(Entry entry) {
        entryRepository.save(entry);
        return entry;
	}

	@Override
	public void delete(Long id) {
        entryRepository.deleteById(id);		
	}
	


}
