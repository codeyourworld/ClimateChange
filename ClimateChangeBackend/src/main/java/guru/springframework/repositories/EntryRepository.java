package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Entry;



/**
 * Created by jt on 1/10/17.
 */
public interface EntryRepository extends CrudRepository<Entry, Long> {
}
