import java.util.HashMap;

public class UsersDataBase {

	private HashMap<String, String> userAndPass;
	private static UsersDataBase instance = null;

	private UsersDataBase() {
		userAndPass = new HashMap<>();
	}

	public static UsersDataBase getUsersDataBase() {
		if (instance == null) {
			instance = new UsersDataBase();
		}
		return instance;
	}

	public void addUser(User user) {
		userAndPass.put(user.getUsername(), user.getPassword());
	}

	public boolean checkValidity(String username, String password) {
		if (userAndPass.containsKey(username)
				&& userAndPass.get(username).equals(password)) {
			return true;
		}
		return false;
	}

}