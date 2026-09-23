import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.foodapp.domain.models.User;
import java.util.List;

@Dao
public interface UserDao {
    @Insert
    long insert(User user);
    
    @Update
    void update(User user);
    
    @Query("SELECT * FROM user WHERE id = :id")
    User getById(long id);
    
    @Query("SELECT * FROM user WHERE email = :email")
    User getByEmail(String email);
    
    @Query("SELECT * FROM user")
    List<User> getAll();
    
    @Query("DELETE FROM user WHERE id = :id")
    void delete(long id);
}