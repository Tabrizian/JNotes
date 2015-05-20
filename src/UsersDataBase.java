import java.util.ArrayList;
import java.util.HashMap;

public class UsersDataBase {

	private HashMap<String, String> userAndPass;
	private ArrayList<User> users;
	private static UsersDataBase instance = null;

	private UsersDataBase() {
		userAndPass = new HashMap<>();
		users = new ArrayList<>();
	}

	public static UsersDataBase getUsersDataBase() {
		if (instance == null) {
			instance = new UsersDataBase();
		}
		return instance;
	}

	public void addUser(User user) {
		userAndPass.put(user.getUsername(), user.getPassword());
		users.add(user);
	}

	public boolean checkValidity(String username, String password) {
		if (userAndPass.containsKey(username)
				&& userAndPass.get(username).equals(password)) {
			return true;
		}
		return false;
	}

}