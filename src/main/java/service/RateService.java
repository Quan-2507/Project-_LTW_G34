package service;

import dao.RateDAO;
import entity.Rates;


import java.util.Date;
import java.util.List;

public class RateService {

        private RateDAO rateDAO;

        public RateService() {
            this.rateDAO = new RateDAO(); // Khởi tạo RatesDAO
        }

        // Phương thức để thêm đánh giá
        public boolean addRating(int userId, int productId, int star, String comment, Date createAt) {
            // Kiểm tra điều kiện nếu cần
            // ...

            // Gọi phương thức addRating từ RatesDAO
            return rateDAO.addRating(userId, productId, star, comment, createAt);
        }

        public double getAverageRating(int productId) {
            return rateDAO.getAverageRating(productId);
        }

        public List<Integer> getRatingsForProduct(int productId) {
            return rateDAO.getRatingsForProduct(productId);
        }

        // Các phương thức khác tùy thuộc vào yêu cầu cụ thể của ứng dụng của bạn
        public Rates get(int id) {
            return rateDAO.get(id);
        }

}
