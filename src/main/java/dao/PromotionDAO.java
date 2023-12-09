package dao;

import bean.Promotions;
import db.JDBIConnector;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PromotionDAO {
    public static List<Promotions> getAll(){
        List<Promotions> promotions = JDBIConnector.me().withHandle((handle ->
                handle.createQuery("select * from promotions").mapToBean(Promotions.class).stream().collect(Collectors.toList())
        ));
        return promotions;
    }
    public static Promotions getById(int id){
        Optional<Promotions> promotions = JDBIConnector.me().withHandle((handle ->
                handle.createQuery("select * from promotions where id= :id").bind("id",id)
                        .mapToBean(Promotions.class).stream().findFirst()
        ));
        return promotions.isEmpty()?null:promotions.get();
    }

    public static void main(String[] args) {
        List<Promotions> all = PromotionDAO.getAll();
        System.out.println(all);
    }
}
