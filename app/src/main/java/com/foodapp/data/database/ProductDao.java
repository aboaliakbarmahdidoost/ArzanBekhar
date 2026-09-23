import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.foodapp.domain.models.Product;
import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    long insert(Product product);
    
    @Update
    void update(Product product);
    
    @Query("SELECT * FROM product WHERE id = :id")
    Product getById(long id);
    
    @Query("SELECT * FROM product WHERE category = :category")
    List<Product> getByCategory(String category);
    
    @Query("SELECT * FROM product")
    List<Product> getAll();
    
    @Query("DELETE FROM product WHERE id = :id")
    void delete(long id);
}