package service;



import dao.CategoryDAO;
import entity.Categories;

import java.util.List;


public class CategoryService {
    CategoryDAO categoryDao = new CategoryDAO();

    public void insert(Categories category) {
        categoryDao.insert(category);
    }
    public void edit(Categories newCategory) {
        Categories oldCate = categoryDao.get(newCategory.getId());
        oldCate.setName(newCategory.getName());
        categoryDao.edit(oldCate);
    }
    public void delete(int id) {
        categoryDao.delete(id);

    }
    public Categories get(int id) {
        return categoryDao.get(id);
    }


    public Categories get(String name) {
        return categoryDao.get(name);
    }


    public List<Categories> getAll() {
        return categoryDao.getAll();
    }


    public List<Categories> search(String username) {
        return categoryDao.search(username);
    }


}
