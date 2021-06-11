package db.ktx.service;

import db.ktx.entity.PageType;
import db.ktx.entity.staticPageType;
import db.ktx.repository.PagetypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagetypeService {

    @Autowired
    private PagetypeRepository repository;

    public List<PageType> pageTypes(){
        return  repository.findAll();
    }

    public String insertPageType(PageType pageType){
        repository.save(pageType);
        return "true";
    }

    public PageType getByType(staticPageType type){
        return repository.findByType(type);
    }

    public PageType updatePageType(PageType pageType){
        PageType basePage = repository.findById(pageType.getID()).orElse(null);
        basePage.setType(pageType.getType());
        basePage.setTitle(pageType.getTitle());
        basePage.setContent(pageType.getContent());
        basePage.setDescription(pageType.getDescription());

        return repository.save(basePage);
    }

    public String deleteById(int Id){
        try{
            repository.deleteById(Id);
        }catch (Exception ex){
            ex.getMessage();
            return "False";
        }
        return "true";
    }

}
