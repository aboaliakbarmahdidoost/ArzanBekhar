import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.foodapp.domain.models.Investor;
import com.foodapp.domain.models.Product;
import com.foodapp.domain.models.User;

@Database(entities = {Investor.class, Product.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract InvestorDao investorDao();
    public abstract ProductDao productDao();
    public abstract UserDao userDao();
}