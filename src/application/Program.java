package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDAO();

        System.out.println("=== Test 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== Test 2: Seller findByDepartment ===");
        Department dep = new Department(2, null);
        List<Seller> sellerList = sellerDao.findByDepartment(dep);
        sellerList.forEach(e -> System.out.println(e));

        System.out.println("=== Test 3: Seller findAll ===");
        sellerList = sellerDao.findAll();
        sellerList.forEach(e -> System.out.println(e));

        System.out.println("=== Test 4: Seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("ID inserido: " + newSeller.getId());
    }
}
