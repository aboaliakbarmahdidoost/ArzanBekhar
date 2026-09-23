import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.foodapp.domain.models.Investor;
import com.foodapp.domain.models.Product;
import com.foodapp.domain.models.User;
import java.util.List;

@Dao
public interface InvestorDao {
    @Insert
    long insert(Investor investor);
    
    @Update
    void update(Investor investor);
    
    @Query("SELECT * FROM investor WHERE id = :id")
    Investor getById(long id);
    
    @Query("SELECT * FROM investor")
    List<Investor> getAll();
    
    @Query("DELETE FROM investor WHERE id = :id")
    void delete(long id);
}