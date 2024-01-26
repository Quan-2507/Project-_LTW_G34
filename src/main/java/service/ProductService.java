package service;

import dao.ProductDAO;
import entity.Images;
import entity.Products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    static ProductService instance;
    public ProductService() {
    }

    public static ProductService getInstance() {
        if (instance == null)
            instance = new ProductService();
        return instance;
    }

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
    public List<Products> bestSeller(){
        return productDao.bestSeller();
    }
    public List<Products> searchByName(String txtSearch) {
        // Implement logic to search products by name in the database
        return productDao.searchByName(txtSearch);
    }
    public List<Products> getAll() {
        return productDao.getAll();
    }
    public int numOfProducts() {
        return productDao.getNoOfProducts();
    }

    public List<Products> newProducts(){
        return productDao.newProducts();
    }

    public Products getProductById(int id) {
        Products product = ProductDAO.getProductById(id);
        ArrayList<Images> listImageOfProduct = ProductDAO.listImageOfProduct(product);
        product.setImages(String.valueOf(listImageOfProduct));
        return product;
    }


//    public int insertProduct(Products p) {
//        return ProductDAO.insertProduct(p);
//    }
//    public int insertImageProduct(int id, String url) {
//        return ProductDAO.insertImageProduct(id, url);
//    }
//    public ArrayList<Products> listAllProduct() {
//        ArrayList<Products> listProduct = ProductDAO.listAllProduct();
//        ArrayList<Images> listImageOfProduct = null;
//        for(Products p:listProduct) {
//            listImageOfProduct = ProductDAO.listImageOfProduct(p);
//            p.setImages(listImageOfProduct);
//        }
//        return listProduct;
//    }
//    public int updateStatusProduct(int id, boolean status) throws SQLException {
//        return ProductDAO.updateStatusProduct(id, status);
//    }
//    public ArrayList<Images> getImgsByIdP(int idP) {
//        return ProductDAO.getImgsByIdP(idP);
//    }
//    public int delImgOfProduct(int id, String urlImage) throws SQLException {
//        return ProductDAO.delImgOfProduct(id, urlImage);
//    }
//    public int updateProduct(Products p) throws SQLException {
//        return ProductDAO.updateProduct(p);
//    }
    public Products productSimilar(int idCate) {
        Products product = ProductDAO.productSimilar(idCate);
        if(product != null) {
            ArrayList<Images> listImageOfProduct = ProductDAO.listImageOfProduct(product);
            product.setImages(String.valueOf(listImageOfProduct));
        }
        return product;
    }
//    public int delProduct(int id) {
//        try {
//            return  ProductDAO.delProduct(id);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
