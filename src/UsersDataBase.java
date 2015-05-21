import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class UsersDataBase {

	private HashMap<String, String> userAndPass;
	private ArrayList<User> users;
	private static UsersDataBase instance = null;

	private UsersDataBase() {
		userAndPass = new HashMap<>();
		users = new ArrayList<>();
		getInitialUsers();
	}

	public static UsersDataBase getUsersDataBase() {
		if (instance == null) {
			instance = new UsersDataBase();
		}
		return instance;
	}

	public boolean addUser(User user, boolean check) {
		if (!check) {
			userAndPass.put(user.getUsername(), user.getPassword());
			users.add(user);
			return true;
		}else{
			if(!users.contains(user)){
				userAndPass.put(user.getUsername(), user.getPassword());
				users.add(user);
				return true;
			}
			else{
				return false;
			}
		}
	}

	public boolean checkValidity(String username, String password) {
		if (userAndPass.containsKey(username)
				&& userAndPass.get(username).equals(password)) {
			return true;
		}
		return false;
	}

	public void getInitialUsers() {
		File users = new File("data/users.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(users);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNext()) {
			String firstName = scanner.next();
			String lastName = scanner.next();
			String username = scanner.next();
			String password = scanner.next();
			String degree = scanner.next();
			Date dateOfBirth = new Date(scanner.next());
			addUser(new User(firstName, lastName, username, password, degree,
					dateOfBirth), false);
		}
	}
}