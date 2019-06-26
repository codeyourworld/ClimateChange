package guru.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import guru.springframework.commands.EntryForm;
import guru.springframework.domain.Entry;

@Component
public class EntryForm2Entry implements Converter<EntryForm, Entry> {

    @Override
    public Entry convert(EntryForm entryForm) {
        Entry entry = new Entry();
        if (entryForm.getId() != null  && !StringUtils.isEmpty(entryForm.getId())) {
            entry.setId(new Long(entryForm.getId()));
        }
        
        

        entry.setPhone(entryForm.getPhone());
        entry.setAddress(entryForm.getAddress());
        entry.setUrl(entryForm.getUrl());
        entry.setEmail(entryForm.getEmail());
        entry.setName(entryForm.getName());
        entry.setOpeningHours(entryForm.getOpeningHours());
        entry.setImageID(entryForm.getImageID());
        entry.setInfo(entryForm.getInfo());
        entry.setImageUrl(entryForm.getImageUrl());
        //TODO type;
        return entry;
    }

}
