package service;

import dao.ProductDAO;
import entity.Products;

import java.util.List;

public class ProductService {

    ProductDAO productDao = new ProductDAO();
    public int numOfProducts() {
        return productDao.getNoOfProducts();
    }
    public List<Products> getProductByPage(int currentPage, int productsPerPage) {
        return productDao.getProductByPage(currentPage, productsPerPage);
    }
}
