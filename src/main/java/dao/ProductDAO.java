package dao;

import entity.Categories;
import entity.Images;
import entity.Products;
import entity.Rates;
import jdbc.JDBCConnection;
import service.CategoryService;
import service.RateService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ProductDAO {
    static CategoryService categoryService = new CategoryService();
    RateService rateService = new RateService();

    /*
  lấy ra sản phẩm theo id sản phẩm
  @param id
  @return Product
   */
    public static Products getProductById(int id) {
        Products product = null;
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            String sql = "select products.id, products.name, categories.id as c_id, products.description, products.size, products.costPrice, products.price, products.createAt, products.lastUpdate, products.status "+
                    "from products INNER JOIN categories ON products.categoryID = categories.id " +
                    "where products.id =?";
            PreparedStatement  pr = conn.prepareStatement(sql);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                String name = rs.getString("name");
                Categories category = categoryService.get(rs.getInt("c_id"));
                String description = rs.getString("description");
                String size = rs.getString("size");
                int costPrice = rs.getInt("costPrice");
                int price = rs.getInt("price");
                Date createAt = rs.getDate("createAt");
                Date lastUpdate = rs.getDate("lastUpdate");
                int status = rs.getInt("status");
                product = new Products(id, name, category, status, description, size, costPrice, price, createAt, lastUpdate);
            }
            JDBCConnection.close(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    /*
   lấy ra danh sách hình ảnh của sản phẩm đó
   @param product
   @return ArrayList<Image>
    */
    public static ArrayList<Images> listImageOfProduct(Products p) {
        ArrayList<Images> re = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            String sql = "Select Path1, Path2, Path3, Path4 " + "from images " + "where productID = ?";
            PreparedStatement  pr = conn.prepareStatement(sql);
            pr.setInt(1, p.getId());
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                String Path1 = resultSet.getString("Path1");
                String Path2 = resultSet.getString("Path2");
                String Path3 = resultSet.getString("Path3");
                String Path4 = resultSet.getString("Path4");
                Images img = new Images(Path1, Path2, Path3, Path4);
                re.add(img);
            }
            JDBCConnection.close(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }

    public List<Products> getProductByPage(int currentPage, int productsPerPage, int categoryID) {
        List<Products> list = new ArrayList<Products>();
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status, products.description, products.size, products.costPrice, products.price, rates.id as r_id, AVG(rates.star) AS star " +
                "FROM products " +
                "INNER JOIN categories ON products.categoryID = categories.id " +
                "LEFT JOIN rates ON rates.productID = products.id " +
                "WHERE products.categoryID = ? " +
                "GROUP BY products.id, products.name, products.images, categories.name, categories.id, products.status, products.description, products.size, products.costPrice, products.price, rates.id " +
                "LIMIT ?, ?";
//        Connection conn = JDBIConnector.connect();
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryID);
            ps.setInt(2, currentPage * productsPerPage - productsPerPage);
            ps.setInt(3, productsPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = categoryService.get(rs.getInt("c_id"));
                Rates rate = rateService.get(rs.getInt("r_id"));
                Products product = new Products();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setImage(rs.getString("images"));
                product.setStatus(rs.getInt("status"));
                product.setDescription(rs.getString("description"));
                product.setSize(rs.getString("size"));
                product.setCostPrice(rs.getInt("costPrice"));
                product.setPrice(rs.getInt("price"));
                product.setCategory(category);
                product.setRates(rate);
                list.add(product);
            }
            System.out.println("Câu truy vấn SQL: " + sql);
            System.out.println("currentPage: " + currentPage);
            System.out.println("productsPerPage: " + productsPerPage);
            System.out.println("Number of Products in ResultSet: " + list.size());

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public List<Products> getAll(int currentPage, int productsPerPage, int categoryID) {
        List<Products> productList = new ArrayList<Products>();
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status, " +
                "products.description, products.size, products.costPrice, products.price, rates.id as r_id, AVG(rates.star) AS star " +
                "FROM products " +
                "INNER JOIN categories ON products.categoryID = categories.id " +
                "LEFT JOIN rates ON rates.productID = products.id " +
                "WHERE products.categoryID = ? " +
                "GROUP BY products.id, products.name, products.images, categories.name, categories.id, products.status, products.description, products.size, products.costPrice, products.price, rates.id";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = categoryService.get(rs.getInt("c_id"));
                Rates rate = rateService.get(rs.getInt("r_id"));
                Products product = new Products();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setImage(rs.getString("images"));
                product.setStatus(rs.getInt("status"));
                product.setDescription(rs.getString("description"));
                product.setSize(rs.getString("size"));
                product.setCostPrice(rs.getInt("costPrice"));
                product.setPrice(rs.getInt("price"));
                product.setCategory(category);
                product.setRates(rate);
                productList.add(product);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
    public List<Products> getAll() {
        List<Products> productList = new ArrayList<>();
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status, " +
                "products.description, products.size, products.costPrice, products.price " +
                "FROM products " +
                "INNER JOIN categories ON products.categoryID = categories.id " +
                "GROUP BY products.id, products.name, products.images, categories.name, categories.id, products.status, products.description, products.size, products.costPrice, products.price ";
        try (Connection conn = JDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categories category = categoryService.get(rs.getInt("c_id"));


                Products product = new Products();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setImage(rs.getString("images"));
                product.setStatus(rs.getInt("status"));
                product.setDescription(rs.getString("description"));
                product.setSize(rs.getString("size"));
                product.setCostPrice(rs.getInt("costPrice"));
                product.setPrice(rs.getInt("price"));
                product.setCategory(category);

                // Sử dụng đối tượng rate nếu cần
                // product.setRate(rate);

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public int getNoOfProducts(int currentPage, int productsPerPage, int categoryID) {
        return getAll( currentPage,  productsPerPage, categoryID).size();
    }
    public int getNoOfProducts() {
        return getAll().size();
    }
    public List<String> getMoreImage(int id) {
        ArrayList<String> listImg = new ArrayList<String>();
        String sql = "SELECT path1, path2 ,path3 ,path4 FROM images where productID=?";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                listImg.add(rs.getString("path1"));
                listImg.add(rs.getString("path2"));
                listImg.add(rs.getString("path3"));
                listImg.add(rs.getString("path4"));
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listImg;
    }

    public Products getID (int id) {
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status," +
                " products.description, products.size, products.costPrice, products.price " +
                "FROM products INNER JOIN categories ON products.categoryID = categories.id INNER JOIN rates ON rates.productID = products.id " +
                "WHERE products.id = ?";
//        Connection conn = JDBIConnector.connect();
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = categoryService.get(rs.getInt("c_id"));
                Products product = new Products();
                product.setImage(rs.getString("images"));
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(category);
                product.setStatus(rs.getInt("status"));
                product.setDescription(rs.getString("description"));
                product.setSize(rs.getString("size"));
                product.setCostPrice(rs.getInt("costPrice"));
                product.setPrice(rs.getInt("price"));
                return product;
            }

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    public static List<Products> bestSeller(){
        List<Products> productsList = new ArrayList<Products>();
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status," +
                " products.description, products.size, products.costPrice, products.price " +
                "FROM products INNER JOIN categories ON products.categoryID = categories.id " +
                "INNER JOIN order_details ON products.id = order_details.productID " +
                "INNER JOIN orders ON orders.id = order_details.orderID INNER JOIN rates ON rates.productID = products.id " +
                "GROUP BY products.id, products.name, products.images, categories.name, categories.id, products.status, products.description, products.size, products.costPrice, products.price " +
                "ORDER BY SUM(order_details.quantity) DESC LIMIT 4";
//        Connection conn = JDBIConnector.connect();
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = categoryService.get(rs.getInt("c_id"));
                Products product = new Products();
                product.setImage(rs.getString("images"));
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(category);
                product.setStatus(rs.getInt("status"));
                product.setDescription(rs.getString("description"));
                product.setSize(rs.getString("size"));
                product.setCostPrice(rs.getInt("costPrice"));
                product.setPrice(rs.getInt("price"));
                productsList.add(product);
            }

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productsList;
    }
    public List<Products> searchByName(String txtSearch) {
        List<Products> list = new ArrayList<>();
        if(txtSearch != null && !txtSearch.trim().isEmpty()){
            String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status, " +
                    "products.description, products.size, products.costPrice, products.price, rates.id as r_id, AVG(rates.star) AS star " +
                    "FROM products " +
                    "INNER JOIN categories ON products.categoryID = categories.id " +
                    "LEFT JOIN rates ON rates.productID = products.id " +
                    "WHERE products.name LIKE ? " +
                    "GROUP BY products.id, products.name, products.images, categories.name, categories.id, products.status, products.description, products.size, products.costPrice, products.price ";  // Thêm GROUP BY để tránh lỗi khi sử dụng AVG

            Connection conn = JDBCConnection.getJDBCConnection();

            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + txtSearch + "%");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Categories category = categoryService.get(rs.getInt("c_id"));
                    Rates rate = rateService.get(rs.getInt("r_id"));
                    Products product = new Products();

                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setImage(rs.getString("images"));
                    product.setStatus(rs.getInt("status"));
                    product.setDescription(rs.getString("description"));
                    product.setSize(rs.getString("size"));
                    product.setCostPrice(rs.getInt("costPrice"));
                    product.setPrice(rs.getInt("price"));
                    product.setCategory(category);
                    product.setRates(rate);
                    list.add(product);
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<Products> newProducts(){
        List<Products> newProductsList = new ArrayList<Products>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT products.id, categories.id as c_id, products.name," +
                "products.description, products.size, products.costPrice, products.price, products.createAt, products.lastUpdate " +
                "FROM products INNER JOIN categories ON products.categoryID = categories.id " +
                "Order by products.createAt desc limit 8";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Products product = new Products();
                product.setId(resultSet.getInt("id"));
                Categories category = categoryService.get(resultSet.getInt("c_id"));
                product.setCategory(category);
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setSize(resultSet.getString("size"));
                product.setCostPrice(resultSet.getInt("costPrice"));
                product.setPrice(resultSet.getInt("price"));
                product.setCreateAt(resultSet.getDate("createAt"));
                product.setLastUpdate(resultSet.getDate("lastUpdate"));
                newProductsList.add(product);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newProductsList;
    }
    public static Products productSimilar(int idCate) {
        ArrayList<Products> listP = new ArrayList<>();
        Products result = null;
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "select products.id,products.categoryID, products.name, products.price, products.costPrice, products.quantity, products.size, products.description, products.status " +
                "from products where products.categoryID =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Categories category = categoryService.get(rs.getInt("c_id"));
                String description = rs.getString("description");
                String size = rs.getString("size");
                int costPrice = rs.getInt("costPrice");
                int price = rs.getInt("price");
                Date createAt = rs.getDate("createAt");
                Date lastUpdate = rs.getDate("lastUpdate");
                int quantity = rs.getInt("quantity");
                if(rs.getBoolean("status")) {
                    Products product = new Products(id, name, category, description, size, costPrice, price, createAt, lastUpdate,quantity);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random();
        int numberRandom = random.nextInt(listP.size());
        return result = listP.get(numberRandom);
    }
//    private static PreparedStatement createPreparedStatement(Connection connection,String command, double priceFil, String colorFil, String materialFil, int idCate) throws SQLException {
//        String sql ="";
//        if(idCate == 0) {
//            sql = "SELECT p.id, p.idCate, p.name, p.price, p.priceImport, p.quantity, p.color, p.material, p.description, p.height, p.width, p.length " +
//                    "FROM products AS p " +
//                    "WHERE p.status = 1 and ";
//        }else {
//            sql = "SELECT p.id, p.idCate, p.name, p.price, p.priceImport, p.quantity, p.color, p.material, p.description, p.height, p.width, p.length " +
//                    "FROM ( SELECT id, idCate, name, price, priceImport, quantity, color, material, description, height, width, length, status  from products where idCate =" + idCate +" ) as p " +
//                    "WHERE p.status = 1 and ";
//        }
//        if (priceFil != 0) {
//            if(command.equalsIgnoreCase("D")) {
//                sql += "p.price < ? ";
//            }else if(command.equalsIgnoreCase("T")) {
//                sql += "p.price >= ? ";
//            }
//        }
//        if (!colorFil.isEmpty()) {
//            if (priceFil != 0) {
//                sql += "AND ";
//            }
//            sql += " p.color = ? ";
//        }
//        if (!materialFil.isEmpty()) {
//            if (priceFil != 0 || !colorFil.isEmpty()) {
//                sql += "AND ";
//            }
//            sql += " p.material COLLATE utf8mb4_general_ci LIKE ? "; // Sử dụng LIKE và thêm dấu ?
//        }
//        PreparedStatement pr = connection.prepareStatement(sql);
//        int parameterIndex = 1;
//        if (priceFil != 0) {
//            pr.setDouble(parameterIndex++, priceFil);
//        }
//        if (!colorFil.isEmpty()) {
//            pr.setString(parameterIndex++, colorFil);
//        }
//        if (!materialFil.isEmpty()) {
//            pr.setString(parameterIndex, "%" + materialFil + "%"); // Thêm dấu % vào giữa chuỗi tìm kiếm
//        }
//        return pr;
//    }
//    public static int insertProduct(Products p) {
//        int re = 0;
//        Connection connection = JDBCConnection.getJDBCConnection();
//        String sql = "insert into products(name, idCate, price, priceImport, quantity, color, material, description, height, width, length) " +
//                "values(?,?,?,?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement pr = connection.prepareStatement(sql);
//            pr.setString(1, p.getName());
//            pr.setInt(2, p.getIdCate());
//            pr.setDouble(3, p.getPrice());
//            pr.setDouble(4, p.getPriceImport());
//            pr.setInt(5, p.getQuantityAvailable());
//            pr.setString(6, p.getColor());
//            pr.setString(7, p.getMaterial());
//            pr.setString(8, p.getDescription());
//            pr.setDouble(9, p.getHeight());
//            pr.setDouble(10, p.getWidth());
//            pr.setDouble(11, p.getLength());
//            re = pr.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return re;
//    }
//    public static int insertImageProduct(int id, String url) {
//        int re = 0;
//        Connection connection = JDBCConnection.getJDBCConnection();
//        String sql = "insert into images_product(idProduct, urlImage) " +
//                "values(?,?)";
//        try {
//            PreparedStatement pr = connection.prepareStatement(sql);
//            pr.setInt(1,id);
//            pr.setString(2,url);
//            re = pr.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return re;
//    }
//    public static ArrayList<Products> listAllProduct() {
//        ArrayList<Products> re = new ArrayList<>();
//        Connection connection = JDBCConnection.getJDBCConnection();
//        try {
//            String sql = "select p.id,p.idCate, p.name, p.price, p.priceImport, p.quantity, p.color, p.material, p.description, p.height, p.width, p.length, p.status " +
//                    "from products as p ";
//            PreparedStatement pr = connection.prepareStatement(sql);
//            ResultSet resultSet = pr.executeQuery();
//            while(resultSet.next()) {
//                int idProduct = resultSet.getInt("id");
//                int idCate = resultSet.getInt("idCate");
//                String name = resultSet.getString("name");
//                double priceImport = resultSet.getDouble("priceImport");
//                double price = resultSet.getDouble("price");
//                String description = resultSet.getString("description");
//                String color = resultSet.getString("color");
//                String material = resultSet.getString("material");
//                double width = resultSet.getDouble("width");
//                double height = resultSet.getDouble("height");
//                double lenght = resultSet.getDouble("length");
//                int quantity = resultSet.getInt("quantity");
//                boolean status = resultSet.getBoolean("status");
//                Products product = new Products(idProduct, idCate, name, priceImport, price,description,color,material,width,height,lenght,1,quantity, status);
//                re.add(product);
//            }
//            JDBCConnection.close(connection);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return re;
//    }
//    public static synchronized int delProduct(int id) throws SQLException {
//        int re = 0;
//        Connection connection = JDBCConnection.getJDBCConnection();
//        try {
//            PreparedStatement  s = connection.prepareStatement("select id from products where id =?");
//            s.setInt(1, id);
//            ResultSet resultSet = s.executeQuery();
//            if (resultSet.next()) {
//                s = connection.prepareStatement("delete from images_product where idProduct =?");
//                s.setInt(1, id);
//                s.executeUpdate();
//                s = connection.prepareStatement("delete from products where id =?");
//                s.setInt(1, id);
//                re = s.executeUpdate();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        JDBCConnection.close(connection);
//        return re;
//    }
//    public static synchronized int updateStatusProduct(int id, boolean status) throws SQLException {
//        int re = 0;
//        Connection connection = JDBCConnection.getJDBCConnection();
//        try {
//            PreparedStatement  s = connection.prepareStatement("select id from products where id =?");
//            s.setInt(1, id);
//            ResultSet resultSet = s.executeQuery();
//            if (resultSet.next()) {
//                s = connection.prepareStatement("update products set status =? where id =?");
//                s.setBoolean(1, status);
//                s.setInt(2, id);
//                re = s.executeUpdate();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        JDBCConnection.close(connection);
//        return re;
//    }
//    public static synchronized int updateProduct(Product p) throws SQLException {
//        int re = 0;
//        Connection connection = JDBCConnection.getJDBCConnection();
//        try {
//            PreparedStatement s = connection.prepareStatement("select id from products where id =?");
//            s.setInt(1, p.getIdProduct());
//            ResultSet resultSet = s.executeQuery();
//            if (resultSet.next()) {
//                s = connection.prepareStatement("UPDATE products SET " +
//                        "name = ?, " +
//                        "priceImport = ?, " +
//                        "price = ?, " +
//                        "description = ?, " +
//                        "color = ?, " +
//                        "material = ?, " +
//                        "width = ?, " +
//                        "height = ?, " +
//                        "length = ?, " +
//                        "quantity = ? " +
//                        "WHERE id = ?");
//                s.setString(1, p.getName());
//                s.setDouble(2, p.getPriceImport());
//                s.setDouble(3, p.getPrice());
//                s.setString(4, p.getDescription());
//                s.setString(5, p.getColor());
//                s.setString(6, p.getMaterial());
//                s.setDouble(7, p.getWidth());
//                s.setDouble(8, p.getHeight());
//                s.setDouble(9, p.getLength());
//                s.setInt(10, p.getQuantityAvailable());
//                s.setInt(11, p.getIdProduct());
//                re = s.executeUpdate();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        JDBCConnection.close(connection);
//        return re;
//    }
//    public static int delImgOfProduct(int id, String urlImage) throws SQLException {
//        int re = 0;
//        Connection connection = JDBCConnection.getJDBCConnection();
//        Statement s = connection.createStatement();
//        synchronized(s) {
//            try {
//                ResultSet resultSet = s.executeQuery("select id from images_product where idProduct=" + id);
//                if (resultSet.next()) {
//                    re = s.executeUpdate("DELETE FROM images_product WHERE urlImage = '" + urlImage + "'");
//
//                }
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            JDBCConnection.close(connection);
//        }
//        return re;
//    }
//    public static ArrayList<Images> getImgsByIdP(int idP) {
//        ArrayList<Images> imgs = new ArrayList<>();
//        Connection connection = JDBCConnection.getJDBCConnection();
//        String sql ="select id, idProduct, urlImage from images_product where idProduct =?";
//        try {
//            PreparedStatement pr = connection.prepareStatement(sql);
//            pr.setInt(1, idP);
//            ResultSet resultSet = pr.executeQuery();
//            while(resultSet.next()) {
//                int id = resultSet.getInt("id");
//                int idProduct = resultSet.getInt("idProduct");
//                String urlImage = resultSet.getString("urlImage");
//                Images image = new Images(id, idProduct, urlImage);
//                imgs.add(image);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return imgs;
//    }

    public static void main(String[] args) {
        System.out.println(getProductById(1));
    }
}
