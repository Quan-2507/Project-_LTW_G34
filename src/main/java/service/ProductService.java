package service;

import dao.ProductDAO;
import entity.Products;

import java.util.List;

public class ProductService {

    ProductDAO productDao = new ProductDAO();

    public int numOfProducts(int currentPage, int productsPerPage, int categoryID) {
        return productDao.getNoOfProducts(currentPage, productsPerPage, categoryID);
    }

    public List<Products> getProductByPage(int currentPage, int productsPerPage, int categoryID) {
        return productDao.getProductByPage(currentPage, productsPerPage, categoryID);
    }

    public List<String> getMoreImage(int id) {
        return productDao.getMoreImage(id);
    }

    public Products getID(int id) {
        return  productDao.getID(id);
    }
    public List<Products> bestSeller(int id){
        return productDao.bestSeller(id);
    }
}
