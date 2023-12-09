package service;

import bean.Promotions;
import dao.PromotionDAO;
import java.util.List;

public class PromotionService {
    private static PromotionService instance;

    public static PromotionService getInstance(){
        if(instance==null) instance = new PromotionService();
        return instance;
    }
    public List<Promotions> getAll(){
        return PromotionDAO.getAll();
    }
    public Promotions getById(int id){
        return PromotionDAO.getById(id);
    }
}
